package com.hackifytech.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackifytech.blog.models.User;
import com.hackifytech.blog.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}