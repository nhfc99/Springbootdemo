package com.nhfc99.template.component.jwt;

import com.nhfc99.template.component.jwt.annotation.PassToken;
import com.nhfc99.template.component.jwt.annotation.RequireToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JWTTokenInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(JWTTokenInterceptor.class);

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(RequireToken.class)) {
            RequireToken requireToken = method.getAnnotation(RequireToken.class);
            if (requireToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId = jwtUtils.getUserId(token);
                if (userId == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }

                //可以加入获取用户信息，如果用户信息不存在则抛出异常

                //判断token是否过期
                if (jwtUtils.isTokenExpired(token)) {
                    throw new RuntimeException("token已过期，请重新登录");
                }
                //判断token是否验证通过
                if (jwtUtils.validateToken(token)) {
                    throw new RuntimeException("无效token，请重新登录");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
