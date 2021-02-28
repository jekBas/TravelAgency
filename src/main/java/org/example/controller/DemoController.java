package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String showLoginPage(){
		return "signIn";
	}

	@RequestMapping("/aboutUs")
	public String showInfoPage(){
//		User user = new User("Name","Surname","testmail@gmail.com","Qwerty@1234");
//		userService.saveUser(user);

		return "aboutUs";
	}
}