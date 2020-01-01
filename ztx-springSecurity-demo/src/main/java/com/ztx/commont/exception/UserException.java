package com.ztx.commont.exception;

public class UserException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String message;
	
	public UserException(String id, String message) {
		super("this is user exception");
		this.id = id;
		this.message = message;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
