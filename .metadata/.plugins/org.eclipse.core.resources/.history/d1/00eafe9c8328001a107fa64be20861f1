package com.ztx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.ztx")
@ComponentScan("com.ztx")
public class DeptConsumerFeign80_Aop {
	

	public static void main(String[] args) {
		
		SpringApplication.run(DeptConsumerFeign80_Aop.class, args);

	}

}
