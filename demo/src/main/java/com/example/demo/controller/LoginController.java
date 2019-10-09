/**
 * 
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author nguye
 *
 */

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {	
		System.out.println(username + "=========" + password);
		return "redirect:home";
	}
	
}
