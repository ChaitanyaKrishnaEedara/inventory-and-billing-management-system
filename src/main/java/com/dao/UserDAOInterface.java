package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAOInterface {
	public String addUser(User u);

	public User login(String username, String password);
	
	public User getUserDetails(String username);

	public List<User> getAllUsers();

}
