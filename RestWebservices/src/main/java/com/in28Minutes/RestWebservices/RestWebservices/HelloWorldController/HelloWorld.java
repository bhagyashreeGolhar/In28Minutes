package com.in28Minutes.RestWebservices.RestWebservices.HelloWorldController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28Minutes.RestWebservices.RestWebservices.HelloWorldBean.HelloWorldBean;

@RestController
public class HelloWorld 
{
	
	@RequestMapping(method= RequestMethod.GET,path="/helloWorld")
	public String helloWorld()
	{
		return "hello world";
	}

	@GetMapping("/hello-World")
	public String getHelloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/helloWorldBean")
	public HelloWorldBean getHelloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/helloWorld/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(name);
	}
}
