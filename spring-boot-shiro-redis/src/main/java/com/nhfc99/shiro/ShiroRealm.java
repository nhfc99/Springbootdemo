package com.nhfc99.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;

import com.nhfc99.sql.model.UPermissionDO;
import com.nhfc99.sql.model.URoleDO;
import com.nhfc99.sql.model.UUserDO;
import com.nhfc99.sql.service.UPermissionService;
import com.nhfc99.sql.service.URoleService;
import com.nhfc99.sql.service.UUserService;

import ch.qos.logback.classic.Logger;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = (Logger) LoggerFactory.getLogger(ShiroRealm.class);

    // 一般这里都写的是servic，这里省略直接调用dao
    @Resource
    private UUserService uUserDao;
    @Resource
    private URoleService uRoleDao;
    @Resource
    private UPermissionService uPermissionDOMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws org.apache.shiro.authc.AuthenticationException {
        // TODO Auto-generated method stub
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + token.toString());
        // 查出是否有此用户
        String username = token.getUsername();
        UUserDO hasUser = uUserDao.selectAllByName(username);

        if (hasUser != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<URoleDO> rlist = uRoleDao.findRoleByUid(hasUser.getId());// 获取用户角色
            List<UPermissionDO> plist = uPermissionDOMapper.findPermissionByUid(hasUser.getId());// 获取用户权限
            List<String> roleStrlist = new ArrayList<String>();//// 用户的角色集合
            List<String> perminsStrlist = new ArrayList<String>();// 用户的权限集合

//			roleStrlist.add("admin");
//			perminsStrlist.add("管理员添加");

            for (URoleDO role : rlist) {
                roleStrlist.add(role.getName());
            }
            for (UPermissionDO uPermission : plist) {
                perminsStrlist.add(uPermission.getName());
            }
            hasUser.setRoleStrlist(roleStrlist);
            hasUser.setPerminsStrlist(perminsStrlist);
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), getName());
        }
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // TODO Auto-generated method stub
        logger.info("##################执行Shiro权限认证##################");
        UUserDO user = (UUserDO) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 用户的角色集合
            info.addRoles(user.getRoleStrlist());
            // 用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
}