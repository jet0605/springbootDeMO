package com.example.springbootswagger2demo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@SpringBootApplication()
public class SpringbootSwagger2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwagger2DemoApplication.class, args);
	}
}
