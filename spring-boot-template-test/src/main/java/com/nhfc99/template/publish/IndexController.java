package com.nhfc99.template.publish;

import com.nhfc99.template.component.annotations.apirequestlogaspect.APIRequestLog;
import com.nhfc99.template.component.jwt.annotation.PassToken;
import com.nhfc99.template.component.redis.RedisUtil;
import com.nhfc99.template.domain.User;
import com.nhfc99.template.service.UserService;
import com.nhfc99.template.utils.JSONResult;
import com.nhfc99.template.utils.JSONUtils;
import com.nhfc99.template.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.beans.ConstructorProperties;
import java.util.Date;

import static org.slf4j.LoggerFactory.getLogger;

@Api("Index测试接口")
@RestController
@RequestMapping("/nhfc99/publish/index")
public class IndexController {
    private static final Logger logger = getLogger(IndexController.class);

    @Value("${activename}")
    String data;

    @Value("${app.description}")
    String des;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserService userService;

    @APIRequestLog
    @GetMapping("/list")
    @ResponseBody
    @ApiOperation(value = "获取列表", notes = "获取列表信息")
    @ApiImplicitParam(paramType = "query", name = "name", value = "用户名", required = true, dataType = "String")
    @PassToken
    public Object list(@RequestParam("name") String name) {
        logger.info("test log");
        Integer state = 1 / 0;
        return JSONResult.success(this.des);
    }

    @APIRequestLog
    @GetMapping("/testredis")
    public Object testRedis() {
        Object value = redisUtil.get("user");
        if (value == null) {
            logger.info("还没有用户信息");
            redisUtil.set("user", "nhfc99");
            return JSONResult.failed("没有这样的用户信息");
        } else {
            logger.info("已有用户信息");
            redisUtil.del("user");
            return JSONResult.success(value);
        }
    }

    @ConstructorProperties({"years", "ultimateAnswer"})
    public IndexController() {

    }

    @PostMapping("/data")
    @ResponseBody
    @ApiOperation(value = "UserInfoVo传参", notes = "类型是UserInfoVo")
    @ApiImplicitParam(paramType = "query", name = "userInfoVo", value = "UserInfoVo值", required = true, dataType = "UserInfoVo")
    public Object showData(@Valid @RequestBody UserInfoVo userInfoVo) {
        return userInfoVo;
    }

    @GetMapping("/requestbaidu")
    public Object restBaiDu() {
        return JSONUtils.beanToJson(restTemplate.getForObject("http://www.baidu.com", String.class));
    }

    @PostMapping("/insert")
    @ResponseBody
    @ApiOperation(value = "User传参", notes = "类型是User")
    @ApiImplicitParam(paramType = "query", name = "User", value = "User值", required = true, dataType = "User")
    public Object insertUserInfo(@RequestBody User user) {
        int count = userService.insertSelective(user);
        return JSONResult.success(count);
    }

    @RequestMapping("/index")
    public ModelAndView test(){
        ModelAndView mav=new ModelAndView("thymeleaf/index");
        mav.addObject("time", new Date());
        mav.getModel().put("name", "caoyc");
        return mav;
    }

    @RequestMapping("/indexjsp")
    public ModelAndView testjsp(){
        ModelAndView mav=new ModelAndView("jsp/jndex");
        mav.addObject("time", new Date());
        mav.getModel().put("name", "cccc");
        return mav;
    }
}
