package com.example.springbootswagger2demo.swagger;

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

@Configuration  //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2Config {
    /**
     * 添加摘要信息
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                .title("标题：某公司_用户信息管理系统_接口文档")
                .description("描述：用于管理集团旗下公司的人员信息，具体包括xxx,xxx模块...")
                .contact(new Contact("Jet","https://blog.csdn.net/jet_green\n","945072633@qq.com"))
                        .version("版本号：1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootswagger2demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
