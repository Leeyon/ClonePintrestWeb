package com.leeyonsoft.clonepintrest.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.leeyonsoft.clonepintrest.models.UserEntity;
import com.leeyonsoft.clonepintrest.utility.CacheUtil;

@Controller
public class IndexController {
	
	@RequestMapping("/index.html")
	public ModelAndView index() {
		String message = "Hello World, Spring 4! In Index page";
		UserEntity user=CacheUtil.GetUser(1);
		if(user!=null)
		{
			message=user.getName();
		}
		return new ModelAndView("index", "message", message);
	}
	
}
