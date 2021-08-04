package com.ap_commerce.engine.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap_commerce.engine.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}
