package com.zhiliao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.net.ssl.TrustManagerFactory;


@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class CmsApplication {

	public static void main(String[] args){
		SpringApplication.run(CmsApplication.class, args);
	}
}