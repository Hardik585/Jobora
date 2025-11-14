package com.jobora.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobora.dto.UserDTO;
import com.jobora.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

	public Optional<UserDTO> findByEmail(String email);
}
