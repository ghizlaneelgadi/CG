package com.axway.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.axway.cg.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByMail(String mail);
	
	User findByMail(String mail);
	
}
