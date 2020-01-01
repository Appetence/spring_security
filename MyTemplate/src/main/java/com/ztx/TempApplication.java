package com.ztx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.ztx"})//����������������Ҫָ�ϰ�·��
public class TempApplication {
	
		 public static void main(String[] args) {
				SpringApplication.run(TempApplication.class, args);
			 }

}
