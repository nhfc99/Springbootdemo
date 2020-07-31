package com.nhfc99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.nhfc99.*")
@EnableWebMvc
@EnableSwagger2
public class TemplateApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TemplateApplication.class, args);
    }
}