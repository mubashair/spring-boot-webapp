package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);

}
