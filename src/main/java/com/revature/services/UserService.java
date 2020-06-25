package com.revature.services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

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
	
	public User getUserById(int id) {
		return userRepository.getNameById(id)
					.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User put(User user) {
		return userRepository.put(user);
	}

	public User patch(Map<String, String> values) {
		int id = Integer.valueOf(values.get("id"));
		User user = this.getUserById(id);
		
		// Replace the name field if provided
		if (values.containsKey("name")) {
			user.setName(values.get("name"));
		}
		
		// Replace the birthdate if provided
		if (values.containsKey("birthdate")) {
			user.setBirthdate(LocalDate.parse(values.get("birthdate")));
		}
		
		return put(user);
	}

	public Collection<User> getUsersOlderThan(Integer olderThan) {
		return userRepository.getUsersOlderThan(olderThan);
	}
}
