package com.jobora.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDTO {

	private Long id;
	@NotBlank(message = "Name is null or blank")
	private String name;
	@NotBlank(message = "email is null or blank")
	private String email;
	@NotBlank(message = "password is null or blank")
	private String password;
	@NotBlank(message = "Acccount type is null or blank")
	private AccountyType accountType;

}
