package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.services.HelloService;

/**
 * The @Controller annotation is a stereotype annotation which allow Spring to manage this class
 * as a bean and also know that it should server as a controller that can handle requests.
 * 
 * Mapping Annotations - These annotations map a request URL context to a method to act as a handler.
 * We can provide context on the class which will provide an initial context (think our router context
 * in express). Methods can then receive further mapping to provide context for that specific handler.
 * 
 *		@RequestMapping - Maps all requests with this context to this handler or controller.
 *		@GetMapping - Maps all get requests with this context to this handler or controller.
 *
 *
 *		@ResponseBody - Indicates the return value of this method is treated as the response
 *			to the request.  Meaning, turn the object into JSON and write that as the response.
 */
@Controller
@RequestMapping("/hello") // Map /hello to this controller
public class HelloController {
	@Autowired
	HelloService helloService;
	
	@GetMapping
	@ResponseBody // returned String should be JSON response
	public String sayHelloById() {
		return "Hello " + helloService.getNameById(1) + "!";
	}

}
