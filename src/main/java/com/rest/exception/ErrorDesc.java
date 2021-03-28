package com.rest.exception;

import static com.rest.exception.ErrorCode.VALIDATION_ERROR_CODE;

public enum ErrorDesc {

	VALIDATION_ERROR(VALIDATION_ERROR_CODE, "Validation Error");
	
	private String code;
	
    private String message;

    ErrorDesc(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
