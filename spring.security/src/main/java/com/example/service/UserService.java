/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.entities.User;

/**
 * @author nguye
 *
 */
public interface UserService {
	
	public List<User> list();
	
	public User insertUser(User user);
	
	public User updatUser(User user);
	
	public boolean deleteUser(int userId);
	
	
}
