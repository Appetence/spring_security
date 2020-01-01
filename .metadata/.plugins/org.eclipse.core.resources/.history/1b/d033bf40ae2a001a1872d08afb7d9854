package com.ztx.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/RestCliean")
public class RestCliean {
	@Value("${eureka.client.service-url.defaultZone}")
	private String port;
	@Value("${spring.profiles}")
	private String profiles;
	@Value("${spring.application.name}")
	private String name;
	@RequestMapping(value = "/	",method = RequestMethod.GET)
	public String info() {
		String str = "----"+"Port:"+port+"profile:"+profiles+"name:"+name;
		System.out.print(str);
		return str;
	}
}
