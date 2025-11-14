package com.jobora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobora.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
