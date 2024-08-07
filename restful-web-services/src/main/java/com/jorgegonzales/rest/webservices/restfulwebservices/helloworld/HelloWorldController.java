package com.jorgegonzales.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	private MessageSource messageSource;
	public HelloWorldController(MessageSource messageSouce) {
		this.messageSource = messageSouce;
	}
	//One way to map
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	//Recommended way to map
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//Path Parameters
	// /users/{id}/todo/{id}
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(
				String.format("Hello World %s", name));
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();//get different locale by addinger header in request Accept-Language : nl
		return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
	}
}
