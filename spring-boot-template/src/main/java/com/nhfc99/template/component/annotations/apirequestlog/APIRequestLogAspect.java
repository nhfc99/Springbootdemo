package com.nhfc99.template.component.annotations.apirequestlog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class APIRequestLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(Object.class);

    //    @Pointcut(value = "execution(public * com.nhfc99.template.publish.IndexController.*(..))")
    @Pointcut("@annotation(com.nhfc99.template.component.annotations.apirequestlog.APIRequestLog)")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，打印请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求内容
        logger.info("############################## - Begin");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("############################## - End");
    }

    @After("webLog()")
    public void afterReturn() {
        logger.info("afterReturn");
    }
}
