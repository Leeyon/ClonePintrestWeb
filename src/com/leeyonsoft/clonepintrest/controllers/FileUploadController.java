package com.leeyonsoft.clonepintrest.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.leeyonsoft.clonepintrest.application.SiteSettings;
import com.leeyonsoft.clonepintrest.utility.*;

@Controller
public class FileUploadController {

	
	@RequestMapping(value = "/fileupload.html", method = RequestMethod.GET)
	public ModelAndView FileUpload() {
		return new ModelAndView("fileupload");
	}

	
	@RequestMapping(value = "/upload.html", method = RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "You can upload a file by posting to this same URL.";
	}

	@RequestMapping(value = "/upload.html", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
			@RequestParam("file") MultipartFile file) {
		
		String name="";
		
		if (!file.isEmpty()) {
			try {
				
				byte[] bytes = file.getBytes();
				
				name=ImageUtil.saveImage(bytes);
				
				if(name!="")
				{
					name+=ImageUtil.resizeImage(name, SiteSettings.ImageResizedWidth);
				}
				
				return "You successfully uploaded " + name + "!";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	

}
