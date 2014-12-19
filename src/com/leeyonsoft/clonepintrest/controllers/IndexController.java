package com.leeyonsoft.clonepintrest.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping("/index.html")
	public ModelAndView index() {
		String message = "Hello World, Spring 4! In Index page";
		return new ModelAndView("index", "message", message);
	}
	
}
