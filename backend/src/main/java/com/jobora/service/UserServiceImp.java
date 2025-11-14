package com.jobora.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jobora.config.JoboraSecurityConfig;
import com.jobora.custom.exception.JoboraException;
import com.jobora.dto.LoginDTO;
import com.jobora.dto.UserDTO;
import com.jobora.entity.UserEntity;
import com.jobora.mapper.UserMapper;
import com.jobora.repo.UserRepo;

@Service
public class UserServiceImp implements UserService {

	private final JoboraSecurityConfig joboraSecurityConfig;

	private UserRepo userRepo;
	private UserMapper userMapper;
	private PasswordEncoder pwdEncoder;

	public UserServiceImp(UserRepo userRepo, UserMapper userMapper, PasswordEncoder pwdEncoder,
			JoboraSecurityConfig joboraSecurityConfig) {
		this.userRepo = userRepo;
		this.userMapper = userMapper;
		this.pwdEncoder = pwdEncoder;
		this.joboraSecurityConfig = joboraSecurityConfig;
	}

	@Override
	public UserDTO registerUser(UserDTO userDto) throws JoboraException {
		Optional<UserDTO> isUser = userRepo.findByEmail(userDto.getEmail());
		if (isUser.isPresent()) {
			throw new JoboraException("USER_FOUND");
		}

		UserEntity uEntity = userMapper.toEntity(userDto);
		uEntity.setPassword(pwdEncoder.encode(uEntity.getPassword()));
		UserEntity savedUser = userRepo.save(uEntity);
		return userMapper.toDTO(savedUser);
	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) throws JoboraException {
		UserDTO isUserPresent = userRepo.findByEmail(loginDTO.getEmail())
				                        .orElseThrow(() -> new JoboraException("USER_NOT_FOUND"));
		if (!pwdEncoder.matches(loginDTO.getPassword(),isUserPresent.getPassword())){
			throw new JoboraException("INVALID_PASSWORD");
		}
		return isUserPresent;
	}

}
