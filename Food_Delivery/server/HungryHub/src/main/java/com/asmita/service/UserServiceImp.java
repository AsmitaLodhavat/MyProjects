package com.asmita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmita.config.JwtProvider;
import com.asmita.model.User;
import com.asmita.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserByJwtToken(String jwt) throws Exception {
		String email = jwtProvider.getEmailFromJwtToken(jwt);
		User user = findUserByEmail(email);
		
		return user;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {

		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			throw new Exception("User not Found");
		}
		return user;
	}
	
	

}
