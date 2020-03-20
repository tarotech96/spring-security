/**
 * 
 */
package nvcong.taro_oppa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import nvcong.taro_oppa.entities.User;
import nvcong.taro_oppa.security.JwtGenerator;
import nvcong.taro_oppa.service.UserService;
import utils.Utils;

/**
 * @author Taro 
 * Login Controller Class
 */ 
@RestController
@CrossOrigin(value = "*")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtGenerator jwtGenerator;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public LoginController(UserService userService, JwtGenerator jwtGenerator, PasswordEncoder passwordEncoder) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
		this.jwtGenerator = jwtGenerator;
		this.passwordEncoder = passwordEncoder;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
		Map<String, String> map = new HashMap<String, String>();
		HttpStatus httpStatus = null;
		Gson gson = new Gson();
		String email = user.getEmail();
		String password = user.getPassword();
		User findByEmail = userService.findByEmail(email);
		Utils utils = new Utils();
		if (findByEmail == null) {
			String errMessage = utils.CustomError("Email is incorrect");
			httpStatus = HttpStatus.BAD_REQUEST;
			map.put("errorr", errMessage);
		} else if (!passwordEncoder.matches(password, findByEmail.getPassword())) {
			String token = jwtGenerator.generate(user);
			httpStatus = HttpStatus.OK;
			map.put("userInfo", gson.toJson(findByEmail));
			map.put("token", token);
		} else {
			String errMessage = utils.CustomError("Password is incorrect");
			httpStatus = HttpStatus.BAD_REQUEST;
			map.put("errorr", errMessage);
		}
		return new ResponseEntity<Map<String, String>>(map, httpStatus);
	}
	
}
