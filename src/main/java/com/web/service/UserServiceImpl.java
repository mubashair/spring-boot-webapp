package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.dto.UserDTO;
import com.web.entity.UserEntity;
import com.web.repo.UserRepo;
import com.web.util.ModelMapperApp;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	private ModelMapperApp modelMapperApp;
    @Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(UserDTO userDTO) {
		//encodeing password
		String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encryptedPassword);
		
		
		//this is mannual method to dto to entity
		
		
		/*UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());*/
		
		//automatic coversion with the help of modelmapper 
		//also adding dependency of modelmapper in pom.xml
		//just with the help of single line of code
		//converting dto to entity
		UserEntity userEntity = modelMapperApp.dtoToEntity(userDTO);
		
		
		userRepo.save(userEntity);
	}

	@Override
	public Boolean findByEmail(String email) {
		UserEntity userEmail = userRepo.findByEmail(email);
		if(userEmail != null) {//if it returns true it means that email is already there in db
			return Boolean.TRUE;//use constant instead of true because memory allocation will happen every time
		}else {
			return Boolean.FALSE;
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity =userRepo.findByEmail(username);
		if(userEntity == null)
			throw new UsernameNotFoundException("Not a valid user");
		return User.withUsername(userEntity.getEmail()).password(userEntity.getPassword()).build();
		
	}

	
}
