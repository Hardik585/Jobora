package com.jobora.mapper;

import org.springframework.stereotype.Component;

import com.jobora.dto.UserDTO;
import com.jobora.entity.UserEntity;

@Component
public class UserMapper {

	public UserDTO toDTO(UserEntity e) {
		return new UserDTO(e.getId(), e.getName(), e.getEmail(), e.getAccountType(), e.getPassword());
	}

	public UserEntity toEntity(UserDTO dto) {
		return new UserEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword(), dto.getAccountType());
	}
}
