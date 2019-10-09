/**
 * 
 */
package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

/**
 * @author nguye
 *
 */

@Controller
@RequestMapping(value = "")
public class LoginController {

	@Autowired
	private UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = { "", "/login" })
	public String login(HttpServletRequest request, Model model) {
		User userLogin = userService.loginUserInfo();
		if (userLogin != null) {
			return "redirect:/home";
		}
		return "/login";
	}

}
