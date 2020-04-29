package com.jocata.journal.dao;

import com.jocata.journal.entity.User;

public interface UserDao {
	
	public User saveUser(User user);
	public User getUserbyUsername(String username);
}
