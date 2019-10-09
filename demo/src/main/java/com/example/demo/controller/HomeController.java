/**
 * 
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nguye
 *
 */

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	public String homePage() {
		return "home";
	}
}
