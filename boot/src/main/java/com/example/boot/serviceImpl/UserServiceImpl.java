package com.example.boot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.beans.User;
import com.example.boot.repository.UserRepository;
import com.example.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = userRepo.findAllUsers();
		return userList;
	}

	@Override
	public User getBasedOnUid(Long uid) {
		User user = userRepo.findByUserId(uid);
		return user;
	}

}
