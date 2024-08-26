package com.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.web.dto.UserDTO;
import com.web.entity.UserEntity;

public interface UserService extends UserDetailsService{
	void saveUser(UserDTO userDTo);
	Boolean findByEmail(String email);

}
