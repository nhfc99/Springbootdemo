package com.nhfc99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nhfc99.shiro.MyExceptionResolver;

@SpringBootApplication
@Configuration
@ComponentScan("com.nhfc99.*")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// 注册统一异常处理bean
    @Bean
    public MyExceptionResolver myExceptionResolver() {
        return new MyExceptionResolver();
    }
}
