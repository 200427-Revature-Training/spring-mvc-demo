package com.revature.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
	Map<Integer, String> names = new HashMap<>();
	
	// Initialization Block
	{
		names.put(1, "Abby");
		names.put(2, "Billy");
		names.put(3, "Cindy");
	}
	
	public Optional<String> getNameById(int id) {
		return Optional.of(names.get(id));
	}
}
