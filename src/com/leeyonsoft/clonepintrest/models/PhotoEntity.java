// Generated 2014-12-16 20:05:31 by Hibernate Tools 4.3.1

/**
 * Appphoto generated by hbm2java
 */


package com.leeyonsoft.clonepintrest.models;

public class PhotoEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 285275131732029739L;
	
	private Integer id;
	private String smallPhotoPath;
	private String bigPhotoPath;

	public PhotoEntity() {
	}

	public PhotoEntity(String smallPhotoPath, String bigPhotoPath) {
		this.smallPhotoPath = smallPhotoPath;
		this.bigPhotoPath = bigPhotoPath;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSmallPhotoPath() {
		return this.smallPhotoPath;
	}

	public void setSmallPhotoPath(String smallPhotoPath) {
		this.smallPhotoPath = smallPhotoPath;
	}

	public String getBigPhotoPath() {
		return this.bigPhotoPath;
	}

	public void setBigPhotoPath(String bigPhotoPath) {
		this.bigPhotoPath = bigPhotoPath;
	}

}
