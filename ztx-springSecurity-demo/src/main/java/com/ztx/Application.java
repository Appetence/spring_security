package com.ztx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = {"com.ztx.web","com.ztx","com.ztx.security.borwser"})//拦截器配置这里需要指认包路径
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})//不启用security
@EnableSwagger2
public class Application {
	 public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		 }
}