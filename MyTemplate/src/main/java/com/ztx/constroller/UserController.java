package com.ztx.constroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztx.config.SecurityProperties;

@Controller
public class UserController {
	
	@Autowired
	private SecurityProperties securityProperties;
	//private com.ztx.security.SecurityProperties securityProperties;
	@RequestMapping("/properties")
	private String properties() {
		//System.out.println("2properties:"+securityProperties.getBrowserProperties().getLoginProperties().getLoginPage());
		System.out.println("properties:"+securityProperties.getCode().getUrl());
		return "user";
	}
	
	
	@RequestMapping("/user")
	private String userInfo() {
		return "user";
	}

}