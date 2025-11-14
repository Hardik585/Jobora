package com.jobora.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotBlank(message = "{user.name.absent}")
	private String name;
	
	@NotBlank(message = "{user.email.absent}")
	@Email
	private String email;
	
	@NotNull(message = "{user.acctype.absent}")
	private AccountyType accountType;
	
	@NotBlank(message = "{user.password.absent}")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9]).{5,16}$" , message ="{user.password.invalid}")
	private String password;

}
