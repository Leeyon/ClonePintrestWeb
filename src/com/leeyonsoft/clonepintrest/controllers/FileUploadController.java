package com.leeyonsoft.clonepintrest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.leeyonsoft.clonepintrest.application.SiteSettings;
import com.leeyonsoft.clonepintrest.dao.PhotoDao;
import com.leeyonsoft.clonepintrest.models.UserEntity;
import com.leeyonsoft.clonepintrest.utility.*;

@Controller
public class FileUploadController {

	// �ļ��ϴ�ҳ��
	@RequestMapping(value = "/fileupload.html", method = RequestMethod.GET)
	public ModelAndView fileUpload(@RequestParam("uid") int userId) {

		String message = "�û���Ȩ���ڣ������µ�¼";
		UserEntity user = CacheUtil.GetUser(userId);
		if (user != null) {
			return new ModelAndView("fileupload", "user", user);
		} else {
			return new ModelAndView("login", "pageTitle", message);
		}
	}

	@RequestMapping(value = "/upload.html", method = RequestMethod.GET)
	public @ResponseBody ModelAndView provideUploadInfo() {
		return new ModelAndView("index");
	}

	// �ļ��ϴ�
	@RequestMapping(value = "/upload.html", method = RequestMethod.POST)
	public @ResponseBody ModelAndView handleFileUpload(
			@RequestParam("file") MultipartFile file,
			@RequestParam("uid") int userId) {

		String message = "�û���Ȩ���ڣ������µ�¼";
		UserEntity user = CacheUtil.GetUser(userId);
		if (user == null) {
			return new ModelAndView("login", "pageTitle", message);
		}

		if (!file.isEmpty()) {

			try {

				byte[] bytes = file.getBytes();

				String largeImageFileName = ImageUtil.saveImage(bytes);
				if (largeImageFileName != "") {
					String dbFileName = SiteSettings.LargeImageFilePrefix
							+ largeImageFileName;
					String thumbnailFileName = ImageUtil.resizeImage(
							largeImageFileName, SiteSettings.ImageResizedWidth);
					String dbThumbFileName = "";
					if (thumbnailFileName == "") {
						dbThumbFileName = dbFileName;
					} else {
						dbThumbFileName = SiteSettings.ThumbnailFilePrefix
								+ largeImageFileName;
					}
					boolean uploadResult = PhotoDao.SavePhoto(dbFileName,
							dbThumbFileName, userId);
					if (uploadResult) {
						return new ModelAndView(new RedirectView(
								"user.html?uid=" + user.getId()));
					} else {
						message = "ͼƬ�ϴ�ʧ��";
						return new ModelAndView("error", "errorMessage",
								message);
					}
				} else {
					message = "ͼƬ����ʧ��";
					return new ModelAndView("error", "errorMessage", message);
				}
			} catch (Exception e) {

				message = "�ϴ�ʧ�� =>" + e.getMessage();
				return new ModelAndView("error", "errorMessage", message);
			}
		} else {
			message = "���ϴ���ͼƬ����Ϊ��";
			return new ModelAndView("error", "errorMessage", message);
		}
	}
}
