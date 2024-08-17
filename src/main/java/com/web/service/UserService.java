package com.web.service;

import com.web.dto.UserDTO;
import com.web.entity.UserEntity;

public interface UserService {
	void saveUser(UserDTO userDTo);
	Boolean findByEmail(String email);

}
