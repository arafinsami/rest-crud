package com.rest.validator;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rest.dto.UserDto;
import com.rest.entity.User;
import com.rest.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

	private final UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserDto dto = (UserDto) target;
		User user = userService.findByUserName(dto.getUserName());
		if (Objects.nonNull(user)) {
			errors.rejectValue("userName", "error.user.name.exists", "username already exits");
		}
	}

}
