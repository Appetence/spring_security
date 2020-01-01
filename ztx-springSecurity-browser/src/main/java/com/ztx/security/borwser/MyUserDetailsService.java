package com.ztx.security.borwser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class MyUserDetailsService implements UserDetailsService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
//类似于shiro的ralem   执行认证逻辑
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("用户名："+username);
		String password = passwordEncoder.encode("123");
		logger.info("用户密码："+password);
		//return new User(username, "123", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		//最后一个参数为用户所拥有的的权限
		//AuthorityUtils.commaSeparatedStringToAuthorityList("admin")将字符串按照，分隔为一个集合
		//中间的四个参数分别用于校验，用户是否被锁定，用户密码有效期等功能，具体逻辑用户可以自定义一个implements UserDetails接口的实体类来进行校验
		return new User(username, password, true, true, true, true,  AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
