package com.leeyonsoft.clonepintrest.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login.html")
	public ModelAndView Login() {
		String pageTitle = "ClonePintrestWebÕº∆¨∑÷œÌ’æ”√ªßµ«¬º";
		return new ModelAndView("login", "pageTitle", pageTitle);
	}
	
	
}
