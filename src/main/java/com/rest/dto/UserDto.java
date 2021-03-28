package com.rest.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.rest.entity.User;

import lombok.Data;

@Data
public class UserDto {

	private Long id;

	@NotBlank
	private String userName;

	@Email
	private String email;

	@NotBlank
	private String phone;

	@NotBlank
	private String password;

	@Temporal(TemporalType.DATE)
	private Date date;

	public User to() {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setDate(date);
		return user;
	}

	public void update(User user) {
		
		user.setUserName(userName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setDate(date);
	}

	public static UserDto from(User user) {
		
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUserName(user.getUserName());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setPassword(user.getPassword());
		dto.setDate(user.getDate());
		return dto;
	}
}
