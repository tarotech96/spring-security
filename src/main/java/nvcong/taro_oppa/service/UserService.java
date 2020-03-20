/**
 * 
 */
package nvcong.taro_oppa.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import nvcong.taro_oppa.entities.User;

/**
 * @author Taro
 *	User Service
 */
public interface UserService {

	public List<User> getAllUsers();
	
	public ResponseEntity<Map<String, String>> insert(User user);
	
	public List<User> sortByName(String fullName);
	
	public List<User> searchByName(String fullName);
	
	public boolean update(User user);
	
	public User findByEmail(String email);
	
}
