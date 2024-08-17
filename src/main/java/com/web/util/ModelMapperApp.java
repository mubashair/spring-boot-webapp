package com.web.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.web.dto.UserDTO;
import com.web.entity.UserEntity;
@Component
public class ModelMapperApp {
	private ModelMapper modelMapper = new ModelMapper();
	
	//coverting dto to entity
	public UserEntity dtoToEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, UserEntity.class);
	}
	//converting entity to dto 
	public UserDTO entityToDTO(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserDTO.class);
	}

}
