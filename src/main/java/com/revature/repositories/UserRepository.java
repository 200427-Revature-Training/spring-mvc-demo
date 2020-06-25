package com.revature.repositories;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserRepository {
	Map<Integer, User> names = new HashMap<>();
	
	// Initialization Block
	{
		names.put(1, new User(1, "Abby", LocalDate.of(2000, 1, 1)));
		names.put(2, new User(2, "Billy", LocalDate.of(2001, 1, 1)));
		names.put(3, new User(3, "Cindy", LocalDate.of(2002, 1, 1)));
	}
	
	public Collection<User> getAllUsers() {
		return names.values();
	}
	
	public Optional<User> getNameById(int id) {
		return Optional.ofNullable(names.get(id));
	}

	public User save(User user) {
		user.setId(names.size()+1);
		names.put(user.getId(), user);
		return user;
	}

	public User put(User user) {
		names.put(user.getId(), user);
		return user;
	}

	public Collection<User> getUsersOlderThan(Integer olderThan) {
		LocalDate threshold = LocalDate.now().minus(olderThan, ChronoUnit.YEARS);
		
		return names
			.values()
			.stream()
			.distinct()
			// checks whether users are older than olderThan years old
			.filter(user -> user.getBirthdate().isBefore(threshold))
			.collect(Collectors.toList());
	}
}
