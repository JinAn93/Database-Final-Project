package com.fasoo.spring.service;

import java.util.List;

import com.fasoo.spring.model.User;

public interface IUserService {

	User findById(String id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(String id);
	
	List<User> findAllUsers();

	boolean isUserIdUnique(String user_id);
	
	int isPasswordValid(String password);
}
