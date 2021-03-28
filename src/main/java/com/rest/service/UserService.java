package com.rest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rest.entity.User;
import com.rest.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	@Transactional
	public User save(User user) {
		User u = repository.save(user);
		return u;
	}

	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}
	
	public void delete(User user) {
		repository.delete(user);
	}
	
	public User findByUserName(String userName) {
		return repository.findByUserName(userName);
	}
}
