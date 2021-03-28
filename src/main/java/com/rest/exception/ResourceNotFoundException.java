package com.rest.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String s) {
		super(s);
	}

	public ResourceNotFoundException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public ResourceNotFoundException(Throwable throwable) {
		super(throwable);
	}

	protected ResourceNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1);
	}
}
