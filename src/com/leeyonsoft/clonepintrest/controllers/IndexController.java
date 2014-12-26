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

	// վ����ҳ
	@RequestMapping("/index.html")
	public ModelAndView index() {
		
		List<PhotoViewModel> photos = PhotoDao.GetPhotos();
		return new ModelAndView("index", "photos", photos);
	}

	// �ҵĸ���ҳ��
	@RequestMapping(value = "/user.html", method = RequestMethod.GET)
	public ModelAndView user(@RequestParam("uid") int userId) {

		String message = "�û���Ȩ���ڣ������µ�¼";
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

	// ������ҳ��
	@RequestMapping(value = "/error.html", method = RequestMethod.GET)
	public ModelAndView error() {
		String message = "���Ǵ�����ҳ��";
		return new ModelAndView("error", "errorMessage", message);
	}

}
