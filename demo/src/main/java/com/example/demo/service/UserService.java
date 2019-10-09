/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

/**
 * @author nguye
 *
 */
public interface UserService {
	
	public List<User> getAllUsers();
	
	public User loginUserInfo();
	
}
