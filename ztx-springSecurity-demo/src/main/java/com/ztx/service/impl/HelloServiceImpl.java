package com.ztx.service.impl;

import org.springframework.stereotype.Service;

import com.ztx.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String getInfo(String username) {
		System.out.println("test:"+username);
		return username;
	}

}
