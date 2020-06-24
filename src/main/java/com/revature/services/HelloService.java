package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.HelloRepository;

@Service
public class HelloService {
	@Autowired
	HelloRepository helloRepository;
	
	public Optional<String> getNameById(int id) {
		return helloRepository.getNameById(id);
	}
}
