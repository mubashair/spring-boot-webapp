package com.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dto.UserDTO;
import com.web.service.UserService;

//it is always look for web page
@Controller // to work with view layer we use @controller not restController view layer mean
			// jsp or html
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("home1") // localhost:8080/home
	//@ResponseBody // not look for web page like jsp or html
	public String displayMessage(@RequestParam String cafeName, ModelMap map) {
		System.out.println(cafeName);
		map.put("cName", cafeName);
		return "home";
	}
	@GetMapping("/userRegisterPage")
	public String viewUserRegisterForm() {
		return "userRegister";
	}
	@PostMapping("saveUser")
	public String saveUser(UserDTO userDTO, Map<String, Object> map) {
		Boolean userExists = userService.findByEmail(userDTO.getEmail());
		if(userExists) {
			map.put("errorMessage", "User Already Exist");
		}else {
			map.put("successMessage", "User register successfully");
			userService.saveUser(userDTO);
		}
		
		return "login";
	}
	@PostMapping("findByEmail")
	@ResponseBody//dispatcher servlet will not look for jsp
	public Boolean findByEmail(String email) {
		Boolean userExists = userService.findByEmail(email);
		if(userExists) {
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	@GetMapping("/testApiOne")
	@ResponseBody//dispatcher servlet will not look for jsp
	public String testApiOne(String email) {
		return "TestApiOne authenticated";
	}
	@GetMapping("/testApiTwo")
	@ResponseBody//dispatcher servlet will not look for jsp
	public String testApiTwo(String email) {
		return "TestApiTwo without authentication";
	}
	@GetMapping("/testApiThree")
	@ResponseBody//dispatcher servlet will not look for jsp
	public String testApiThree(String email) {
		return "TestApiThree access denied";
	}

}
