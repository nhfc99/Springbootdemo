package com.nhfc99.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.nhfc99.template.*")
@EnableWebMvc
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}