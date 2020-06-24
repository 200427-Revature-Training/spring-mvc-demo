package com.revature.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.models.User;
import com.revature.services.UserService;

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
 *		@PostMapping - Maps all post requests with this conext to this handler or controller.
 *
 *
 *		@RequestBody - Maps the body of the request to a handler function parameter with this 
 *			annotation.
 *		@ResponseBody - Indicates the return value of this method is treated as the response
 *			to the request.  Meaning, turn the object into JSON and write that as the response.
 *		@PathVariable can be used in method parameter lists to inject a path variable into the 
 *			method when it is called.  The path parameter itself is indicated in the mapping using
 *			/users/{id} syntax, where id is a path variable.
 *		@ResponseStatus - Set the status code to be returned by this handler.
 *
 *		@ExceptionHandler can be be used over a method to indicate a method that can be called
 *			when an exception is thrown and not handled until it bubbles to Spring. The 
 *			handling functions can provide fallback logic, including client response.
 *
 *		ResponseEntity - Represents a response wrapping some data to respond with.  The generic type
 *			is the body of the response, and the response entity can be configured with headers, 
 *			status, etc. This is useful when you need dynamic control of these things.
 *
 *		@ControllerAdvise - Can be used to define a class to advise all controllers or multiple 
 *			controllers. Useful when you need to provide the same logical handlers in some scenarios.
 *			For example, using a controller advisor for exception handling allows you to isolate
 *			your logic to a single place.
 */
@Controller
@RequestMapping("/users") // Map /hello to this controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	@ResponseBody // returned String should be JSON response
	public Collection<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// /users/{id}
	@GetMapping("/{id}")
	@ResponseBody
	public User getUserById(@PathVariable int id) {
		return userService.getNameById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	// You could write an exceptionhandler at the controller level, but its often more
	// flexible to write them at a higher level that any controller can leverage
}







