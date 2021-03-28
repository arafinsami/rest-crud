package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
}
