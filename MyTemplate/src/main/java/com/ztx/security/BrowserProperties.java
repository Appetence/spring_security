package com.ztx.security;

public class BrowserProperties {
	
	private String loginPage = "/signIn.html";
	
	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	
	private LoginProperties loginProperties =new LoginProperties();

	public LoginProperties getLoginProperties() {
		return loginProperties;
	}

	public void setLoginProperties(LoginProperties loginProperties) {
		this.loginProperties = loginProperties;
	}
	
	

}
