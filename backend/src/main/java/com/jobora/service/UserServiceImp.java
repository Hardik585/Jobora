package com.jobora.service;

import org.springframework.stereotype.Service;

import com.jobora.dto.UserDTO;
import com.jobora.entity.UserEntity;
import com.jobora.mapper.UserMapper;
import com.jobora.repo.UserRepo;

@Service
public class UserServiceImp implements UserService {

	private UserRepo userRepo;
	private UserMapper userMapper;

	public UserServiceImp(UserRepo userRepo, UserMapper userMapper) {
		this.userRepo = userRepo;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO registerUser(UserDTO userDto) {
		UserEntity uEntity = userMapper.toEntity(userDto);
		UserEntity savedUser = userRepo.save(uEntity);
		return userMapper.toDTO(savedUser);
	}

}
