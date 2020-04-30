package com.jocata.journal.cfgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jocata.journal.dao.UserDao;
import com.jocata.journal.entity.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserbyUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found with username "+username);
		return new CustomUserDetails(user);
	}

}
