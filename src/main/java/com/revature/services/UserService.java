package com.revature.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public Collection<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User getNameById(int id) {
		return userRepository.getNameById(id)
					.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public User save(User user) {
		return userRepository.save(user);
	}
}
