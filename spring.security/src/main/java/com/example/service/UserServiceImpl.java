/**
 * 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

/**
 * @author nguye
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		try {
			list = userRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updatUser(User user) {
		// TODO Auto-generated method stub
		try {
			userRepository.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		try {
			userRepository.deleteById(userId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
