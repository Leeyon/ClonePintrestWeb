package com.leeyonsoft.clonepintrest.models;

public class APIResult<T> {

	private T data;
	private int apiStatus;
	private String message;
	private String Version;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getApiStatus() {
		return apiStatus;
	}
	public void setApiStatus(int apiStatus) {
		this.apiStatus = apiStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	
	
}
