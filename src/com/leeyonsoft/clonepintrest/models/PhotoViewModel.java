package com.leeyonsoft.clonepintrest.models;

import com.leeyonsoft.clonepintrest.application.SiteSettings;

public class PhotoViewModel {

	private int userId;
	private String userDisplayName;
	private String largePhotoPath;
	private String thumbnailPath;

	public PhotoViewModel(String userDisplayName, String largePhotoPath,
			String thumbnailPath) {
		this.setUserDisplayName(userDisplayName);
		this.setLargePhotoPath(largePhotoPath);
		this.setThumbnailPath(thumbnailPath);
	}

	public PhotoViewModel(int userId, String userDisplayName,
			String largePhotoPath, String thumbnailPath) {
		this.setUserId(userId);
		this.setUserDisplayName(userDisplayName);
		this.setLargePhotoPath(largePhotoPath);
		this.setThumbnailPath(thumbnailPath);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getLargePhotoPath() {
		return largePhotoPath;
	}

	public void setLargePhotoPath(String largePhotoPath) {
		// this.largePhotoPath = SiteSettings.SiteUrl + largePhotoPath;
		this.largePhotoPath = largePhotoPath;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnaliPath) {
		// this.thumbnailPath = SiteSettings.SiteUrl + thumbnaliPath;
		this.thumbnailPath = thumbnaliPath;
	}

}
