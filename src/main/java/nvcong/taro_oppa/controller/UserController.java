/**
 * 
 */
package nvcong.taro_oppa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvcong.taro_oppa.entities.User;
import nvcong.taro_oppa.service.UserService;

/**
 * @author Taro User Controller Class
 */
@RestController
@RequestMapping(value = "/rest")
@CrossOrigin(value = "*")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/user/list")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<Map<String, String>> insert(@RequestBody User user) {
		return userService.insert(user);
	}

	@PostMapping(value = "/update")
	public boolean update(@RequestBody User user) {
		return userService.update(user);
	}

}
