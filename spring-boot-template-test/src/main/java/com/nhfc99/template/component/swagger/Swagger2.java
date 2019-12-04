package com.nhfc99.template.component.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class Swagger2 {
    //指定扫描哪些包
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //要扫描的包路径（这里无需通过命名空间，太low了）
                .apis(RequestHandlerSelectors.basePackage("com.nhfc99"))//显示API注解的接口
                .paths(PathSelectors.any())
                .build();
    }

    //配置swagger的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Docs")
                //创始人
                .contact(new Contact("nhfc99", "nhfc99", "nhfc99@163.com"))
                .description("接口文档V0.1")
                //版本
                .version("0.1")
                //描述
                .build();
    }
}
