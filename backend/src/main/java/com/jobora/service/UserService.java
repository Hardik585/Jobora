package com.jobora.service;

import com.jobora.custom.exception.JoboraException;
import com.jobora.dto.LoginDTO;
import com.jobora.dto.UserDTO;

public interface UserService {

	public UserDTO registerUser(UserDTO userDto) throws JoboraException;
	
	public UserDTO loginUser(LoginDTO loginDTO) throws JoboraException;
}
