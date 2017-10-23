package com.intuit.assignment.daolayer.exception;

public class AppException extends Exception {

	public AppException(AppExceptionEnum appExceptionEnum, String description) {
		this.exceptionEnum = appExceptionEnum;
		this.description = description;
	}

	private static final long serialVersionUID = 1L;
	private AppExceptionEnum exceptionEnum;
	private String description;

	public AppExceptionEnum getExceptionEnum() {
		return exceptionEnum;
	}

	public void setExceptionEnum(AppExceptionEnum exceptionEnum) {
		this.exceptionEnum = exceptionEnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
