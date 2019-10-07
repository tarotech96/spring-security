/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entities.User;
import com.example.service.UserService;

/**
 * @author nguye
 *
 */

@Controller
@RequestMapping(value = "/")
public class UserController {

	final String TITLE = "USERMANAGEMENT";

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<User> list = userService.list();
		model.addAttribute("listUser", list);
		model.addAttribute("title", TITLE);
		return "usermanagement";
	}

	@RequestMapping(value = "/user/insert", method = RequestMethod.POST)
	public String insert(Model model, @RequestBody User user) {
		model.addAttribute("user", userService.insertUser(user));
		return "adduser";
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.PUT)
	public String update(Model model, @RequestBody User user) {
		model.addAttribute("user", userService.updatUser(user));
		return "updateuser";
	}

}
