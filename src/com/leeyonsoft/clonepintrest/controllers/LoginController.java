package com.leeyonsoft.clonepintrest.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.leeyonsoft.clonepintrest.dao.UserDao;
import com.leeyonsoft.clonepintrest.application.SiteSettings;
import com.leeyonsoft.clonepintrest.models.APIResult;
import com.leeyonsoft.clonepintrest.models.UserEntity;

/**
 * @author Leeyon
 *
 */
@Controller
public class LoginController {

	private Gson gson = new Gson();

	@RequestMapping("/login.html")
	public ModelAndView Login() {
		String pageTitle = "ClonePintrestWebÍ¼Æ¬·ÖÏíÕ¾µÇÂ¼";
		return new ModelAndView("login", "pageTitle", pageTitle);
	}

	//ÓÃ»§µÇÂ¼
	@RequestMapping(value = "/Auth.html", method = RequestMethod.POST)
	public @ResponseBody String Auth(@RequestParam("name") String name,
			@RequestParam("pass") String pass) {
		String result = "";

		UserEntity authUser = UserDao.auth(name, pass);

		APIResult<UserEntity> resultObj = new APIResult<UserEntity>();
		resultObj.setVersion(SiteSettings.ApiVersion);
		resultObj.setData(authUser);

		if (authUser != null) {
			resultObj.setMessage("µÇÂ¼³É¹¦");
		} else {
			resultObj.setMessage("µÇÂ¼Ê§°Ü");
		}
		result = gson.toJson(resultObj);
		return result;
	}

	// ÓÃ»§×¢²á
	@RequestMapping(value = "/Register.html", method = RequestMethod.POST)
	public @ResponseBody String Register(@RequestParam("name") String name,
			@RequestParam("pass") String pass,
			@RequestParam("displayName") String displayName) {
		String result = "";

		Boolean isSucessful  = UserDao.register(name, pass, displayName);
		
		APIResult<Boolean> resultObj = new APIResult<Boolean>();
		resultObj.setVersion(SiteSettings.ApiVersion);
		resultObj.setData(isSucessful);

		if (isSucessful) {
			resultObj.setMessage("×¢²á³É¹¦");
		} else {
			resultObj.setMessage("×¢²áÊ§°Ü");
		}
		result = gson.toJson(resultObj);
		return result;
	}

}
