package com.in28Minutes.RestWebservices.RestWebservices.HelloWorldBean;

public class HelloWorldBean {
	
	public String message;
	
	public HelloWorldBean(String message)
	{
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
