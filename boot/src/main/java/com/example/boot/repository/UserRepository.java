package com.example.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.boot.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Query("from User u")
	public List<User> findAllUsers();
	User findByUserId(Long id);
}
