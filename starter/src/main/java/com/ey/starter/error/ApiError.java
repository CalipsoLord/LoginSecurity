package com.ey.starter.error;

import org.springframework.http.HttpStatus;

public class ApiError {
	
	private HttpStatus httpStatus;
	private String error;
	private String message;
	
	public ApiError(HttpStatus status, String msg, String err) {
		this.httpStatus = status;
		this.message = msg;
		this.error = err;
	}
	
	

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
