package com.rest.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiError implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Map<String, String> fieldErrors = new HashMap<>();

	public static Map<String, String> fieldError(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			errors.forEach(e -> {
				fieldErrors.put(e.getField(), e.getDefaultMessage());
			});
		}
		return fieldErrors;
	}
}
