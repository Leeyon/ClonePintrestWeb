package com.leeyonsoft.clonepintrest.controllers;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leeyonsoft.clonepintrest.dao.PhotoDao;
import com.leeyonsoft.clonepintrest.models.PhotoViewModel;
import com.leeyonsoft.clonepintrest.models.UserEntity;
import com.leeyonsoft.clonepintrest.models.UserPhotoViewModel;
import com.leeyonsoft.clonepintrest.utility.CacheUtil;

@Controller
public class IndexController {

	// 站点主页
	@RequestMapping("/index.html")
	public ModelAndView index() {
		
		List<PhotoViewModel> photos = PhotoDao.GetPhotos();
		return new ModelAndView("index", "photos", photos);
	}

	// 我的个人页面
	@RequestMapping(value = "/user.html", method = RequestMethod.GET)
	public ModelAndView user(@RequestParam("uid") int userId) {

		String message = "用户授权过期，请重新登录";
		UserEntity user = CacheUtil.GetUser(userId);
		if (user != null) {

			List<PhotoViewModel> photos = PhotoDao.GetPhotos(userId);

			UserPhotoViewModel data = new UserPhotoViewModel();
			data.setUser(user);
			data.setPhotoViewModels(photos);

			return new ModelAndView("user", "data", data);
		} else {
			return new ModelAndView("login", "pageTitle", message);
		}
	}

	// 错误处理页面
	@RequestMapping(value = "/error.html", method = RequestMethod.GET)
	public ModelAndView error() {
		String message = "这是错误处理页面";
		return new ModelAndView("error", "errorMessage", message);
	}

}
