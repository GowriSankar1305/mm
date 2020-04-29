package com.jocata.journal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.journal.dao.UserDao;
import com.jocata.journal.entity.User;
import com.jocata.journal.utils.HibernateUtils;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;

	@Override
	public User saveUser(User user) {
		return hibernateUtils.saveEntity(user);
	}

	@Override
	public User getUserbyUsername(String username) {
		return hibernateUtils.loadEntityByUniqueStringProperty(User.class, "userName", username);
	}
	
	
}
