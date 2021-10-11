package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	// To find by userName or userEmail
	public User findByUserNameOrUserEmail(String userName, String userEmail);
	
	// To find by userName
	public User findByUserName(String userName);
	
	// To find by userEmail
	public User findByUserEmail(String userEmail);
}
