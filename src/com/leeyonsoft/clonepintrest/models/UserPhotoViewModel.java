package com.leeyonsoft.clonepintrest.models;

import java.util.List;

public class UserPhotoViewModel {

	private UserEntity user;
	private List<PhotoViewModel> photoViewModels;
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<PhotoViewModel> getPhotoViewModels() {
		return photoViewModels;
	}
	public void setPhotoViewModels(List<PhotoViewModel> photoViewModels) {
		this.photoViewModels = photoViewModels;
	}
	
}
