package com.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String loginPage(@RequestParam(name = "loginFailed", defaultValue = "false") boolean error,
			Map<String, Object> map) {
		if (error) {
			map.put("errorMessage", "Invalid Username or Password");
		}
		return "login";
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}

}
