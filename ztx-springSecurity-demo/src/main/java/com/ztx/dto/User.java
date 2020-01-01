package com.ztx.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.ztx.voladitor.MyConstraint;

public class User {
	private int id;
	@MyConstraint(message="username")
	private String username;
	@NotBlank
	private String password;
	
	private Date birthday;
	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView {};
	
	
	@JsonView(UserSimpleView.class)//UserSimpleView试图下显示
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@JsonView(UserSimpleView.class)//UserSimpleView试图下显示
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonView(UserSimpleView.class)//UserSimpleView试图下显示
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDetailView.class)//视图下显示
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
