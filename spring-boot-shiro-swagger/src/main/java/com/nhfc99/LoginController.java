package com.nhfc99;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nhfc99.sql.model.UUserDO;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/login")
@Api(tags = "登录控制器API接口")
public class LoginController {

    private static Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/tologin", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "所有用户的登录入口")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true, paramType = "query", dataType = "string")})

    public String tologin(@RequestParam("username") String username, @RequestParam("passwd") String passwd) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, passwd, "tologin");
        Subject currentUser = SecurityUtils.getSubject();
        logger.info("对用户[" + username + "]进行登录验证..验证开始");
        try {
            currentUser.login(token);
            // 验证是否登录成功
            if (currentUser.isAuthenticated()) {
                String value = "用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)";
                logger.info(value);
                System.out.println(value);
                return value;
            } else {
                token.clear();
                String value = "用户[" + username + "]登录认证失败,重新登陆";
                System.out.println(value);
                return value;
            }
        } catch (UnknownAccountException uae) {
            String value = "对用户[" + username + "]进行登录验证..验证失败-username wasn't in the system";
            logger.info(value);
            return value;
        } catch (IncorrectCredentialsException ice) {
            String value = "对用户[" + username + "]进行登录验证..验证失败-password didn't match";
            logger.info(value);
            return value;
        } catch (LockedAccountException lae) {
            String value = "对用户[" + username + "]进行登录验证..验证失败-account is locked in the system";
            logger.info(value);
            return value;
        }
    }

    @RequestMapping(value = "/logined", method = RequestMethod.GET)
    @ResponseBody
    @RequiresRoles({"admin"})
    public String loginedAfter() {
        return "测试信息";
    }

    // 跳转到登录表单页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        // 模版名称，实际的目录为：src/main/webapp/jsp/index.html
        mv.setViewName("login");
        return mv;
    }

    // 登录成功后，跳转的页面
    @RequestMapping("/success")
    @ResponseBody
    public String index(Model model) {
        return "success";
    }

    // 未登录，可以访问的页面
    @RequestMapping("/index")
    public String list(Model model) {
        return "index";
    }

    // 登陆验证，这里方便url测试，正式上线需要使用POST方式提交
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.GET)
    @ResponseBody
    public String index(UUserDO user) {
        if (user.getNickname() != null && user.getPswd() != null) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getNickname(), user.getPswd(), "login");
            Subject currentUser = SecurityUtils.getSubject();
            logger.info("对用户[" + user.getNickname() + "]进行登录验证..验证开始");
            try {
                currentUser.login(token);
                // 验证是否登录成功
                if (currentUser.isAuthenticated()) {
                    logger.info("用户[" + user.getNickname() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
                    System.out.println("用户[" + user.getNickname() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
                    return "redirect:/";
                } else {
                    token.clear();
                    System.out.println("用户[" + user.getNickname() + "]登录认证失败,重新登陆");
                    return "redirect:/login";
                }
            } catch (UnknownAccountException uae) {
                logger.info("对用户[" + user.getNickname() + "]进行登录验证..验证失败-username wasn't in the system");
            } catch (IncorrectCredentialsException ice) {
                logger.info("对用户[" + user.getNickname() + "]进行登录验证..验证失败-password didn't match");
            } catch (LockedAccountException lae) {
                logger.info("对用户[" + user.getNickname() + "]进行登录验证..验证失败-account is locked in the system");
            }
        }
        return "login";
    }

    /**
     * ajax登录请求接口方式登陆
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> submitLogin(@RequestParam(value = "nickname") String username,
                                           @RequestParam(value = "pswd") String password) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }
        return resultMap;
    }

    // 登出
    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout() {
        return "logout";
    }

    // 错误页面展示
    @GetMapping("/403")
    @ResponseBody
    public String error() {
        return "error ok!";
    }

    // 错误页面展示
    @GetMapping("/authorizationErr")
    @ResponseBody
    public String authorizationError() {
        return "Authorization error!";
    }

    // 错误页面展示
    @GetMapping("/authenticationErr")
    @ResponseBody
    public String authenticationError() {
        return "Authentication error!";
    }

    // 管理员功能
    @RequiresRoles("admin")
    @RequiresPermissions("管理员添加")
    @RequestMapping(value = "/admin/add")
    public String create() {
        return "add success!";
    }

    // 用户功能
    @RequiresRoles("user")
    @RequiresPermissions("用户查询")
    @RequestMapping(value = "/user/select")
    @ResponseBody
    public String detail() {
        return "select success!";
    }

}