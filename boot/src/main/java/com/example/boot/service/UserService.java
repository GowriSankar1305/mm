package com.example.boot.service;

import java.util.List;

import com.example.boot.beans.User;

public interface UserService {
	
	public User saveUser(User user);
	public List<User> getAllUsers();
	public User getBasedOnUid(Long uid);
}
