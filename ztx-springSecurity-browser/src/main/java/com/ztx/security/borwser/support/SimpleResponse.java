package com.ztx.security.borwser.support;

public class SimpleResponse {
	
	private Object content;


	public Object getContent() {
		return content;
	}


	public void setContent(Object content) {
		this.content = content;
	}


	public SimpleResponse(Object content) {
		super();
		this.content = content;
	}


	public SimpleResponse() {
		super();
	}
}
