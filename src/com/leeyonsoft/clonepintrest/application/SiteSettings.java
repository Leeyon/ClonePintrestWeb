package com.leeyonsoft.clonepintrest.application;

public class SiteSettings {

	// 原图的路径 (放在IIS目录下)
	public static final String LargeImageFilePath = "C:\\inetpub\\wwwroot\\Images\\Large\\";

	// 缩略图的路径 (放在IIS目录下)
	public static final String ThumbnailFilePath = "C:\\inetpub\\wwwroot\\Images\\Thumbnail\\";

	// 原图的文件名前缀
	public static final String LargeImageFilePrefix = "Images\\Large\\";

	// 缩略图的文件名前缀
	public static final String ThumbnailFilePrefix = "Images\\Thumbnail\\";

	// 压缩图片的固定宽度
	public static final int ImageResizedWidth = 371;

	// API的版本号
	public static final String ApiVersion = "1.0.0.0";

	// 网站地址(随发布更改,IIS图片服务目录)
	public static final String SiteUrl = "http:\\\\localhost:62231\\";

}
