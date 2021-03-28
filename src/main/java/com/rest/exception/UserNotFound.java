package com.rest.exception;

import lombok.Data;

@Data
public class UserNotFound {

	private String message;
	
	public UserNotFound() {
	}
}
