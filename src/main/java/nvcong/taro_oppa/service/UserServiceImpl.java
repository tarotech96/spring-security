/**
 * 
 */
package nvcong.taro_oppa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nvcong.taro_oppa.entities.User;
import nvcong.taro_oppa.repository.UserRepository;
import utils.Utils;

/**
 * @author Taro User Service Implement Class
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private Utils utils;
	private User findByEmail;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> results = new ArrayList<User>();
		try {
			results = userRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(utils.CustomError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return results;
	}

	@Override
	public ResponseEntity<Map<String, String>> insert(User user) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		findByEmail = userRepo.findByEmail(user.getEmail());
		HttpStatus httpStatus = null;
		if (findByEmail != null) {
			httpStatus = HttpStatus.CONFLICT;
			map.put("message", "Email is already exist");
		} else {
			String passEncode = passwordEncoder.encode(user.getPassword());
			user.setPassword(passEncode);
			userRepo.save(user);
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<Map<String, String>>(map, httpStatus);
	}

	@Override
	public boolean update(User user) {
		User findByEmail = userRepo.findByEmail(user.getEmail());
		findByEmail.setCompany(user.getCompany());
		findByEmail.setFullName(user.getFullName());
		findByEmail.setAddress(user.getAddress());
		findByEmail.setCountry(user.getCountry());
		findByEmail.setCity(user.getCity());
		userRepo.save(findByEmail);
		return true;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		User findByEmail = new User();
		try {
			findByEmail = userRepo.findByEmail(email);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return findByEmail;
	}
	
	@Override
	public List<User> sortByName(String fullName) {
		return userRepo.sortByName(fullName);
	}
	
	@Override
	public List<User> searchByName(String fullName) {
		return userRepo.searchByName(fullName);
	}

}
