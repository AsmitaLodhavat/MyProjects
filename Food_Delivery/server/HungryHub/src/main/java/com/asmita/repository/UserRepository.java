package com.asmita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asmita.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByEmail(String username);
	
	
	
	

}
