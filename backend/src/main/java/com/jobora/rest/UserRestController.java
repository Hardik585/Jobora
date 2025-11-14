package com.jobora.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobora.dto.UserDTO;
import com.jobora.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserRestController {

	private UserService service;

	public UserRestController(UserService service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) {
		UserDTO registerdUser = service.registerUser(userDto);
		return new ResponseEntity<>(registerdUser, HttpStatus.CREATED);
	}
}
