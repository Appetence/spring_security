package com.ztx.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ztx.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping("signIn")
	 public String hello() {
		 return "signIn";
	 }
	@JsonView(User.UserSimpleView.class)
	//@RequestMapping(value="/user",method = RequestMethod.GET)
	@PostMapping
	public User create(@Valid @RequestBody User user,BindingResult errors) {//校验实体类中的@NotBlank类似注解
		if(errors.hasErrors()) {
			//有错误
			errors.getAllErrors().stream().forEach(error  -> System.out.println(error.getDefaultMessage()));
		}
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		System.out.println(user.getId());
		System.out.println(user.getBirthday());
		user.setId(1);
		return user;
	}
	
	
	@GetMapping
	public List<User> query(User user){
		
		List<User> list = new ArrayList<User>();
		list.add(new User());
		list.add(new User());
		list.add(new User());
		//线性方式输出
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		//System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
		return list;
	}
	@JsonView(User.UserDetailView.class)
	//@RequestMapping(value="/user/{id:\\d+}",method = RequestMethod.GET)//限制id只能为数字
	@GetMapping("/{id:\\d+}")
	public User  getInfo(@PathVariable(name="id") String thisId){//获取url中的指定id
		User u = new User();
		u.setUsername("1");
		u.setPassword("11");
		//throw new UserException("1","我这出问题了");
		return u;
	}
	
}
