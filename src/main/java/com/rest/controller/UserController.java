package com.rest.controller;

import static com.rest.exception.ApiError.fieldError;
import static com.rest.response.ApiResponseBuilder.error;
import static com.rest.response.ApiResponseBuilder.success;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dto.UserDto;
import com.rest.entity.User;
import com.rest.exception.ResourceNotFoundException;
import com.rest.service.UserService;
import com.rest.validator.UserValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
@Api(tags = "User's Data")
public class UserController {

	private final UserService service;

	private final UserValidator userValidator;

	@PostMapping("/save")
	@ApiOperation(value = "save user", response = UserDto.class)
	public ResponseEntity<JSONObject> save(@Valid @RequestBody UserDto dto, BindingResult bindingResult) {

		ValidationUtils.invokeValidator(userValidator, dto, bindingResult);

		if (bindingResult.hasErrors()) {
			return badRequest().body(error(fieldError(bindingResult)).getJsonResponse());
		}

		User user = dto.to();

		service.save(user);

		return ok(success(UserDto.from(user)).getJsonResponse());
	}

	@PutMapping("/update")
	@ApiOperation(value = "update user", response = UserDto.class)
	public ResponseEntity<JSONObject> update(@Valid @RequestBody UserDto dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return badRequest().body(error(fieldError(bindingResult)).getJsonResponse());
		}

		User user = service.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);

		dto.update(user);

		service.save(user);

		return ok(success(UserDto.from(user)).getJsonResponse());
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("delete user by id")
	public ResponseEntity<JSONObject> delete(@PathVariable Long id) {

		User user = service.findById(id).orElseThrow(ResourceNotFoundException::new);

		service.delete(user);

		return ok(success("user with id :" + user.getId() + " deleted").getJsonResponse());
	}
}
