package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DemoController {
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;




	@RequestMapping("/aboutUs")
	public String showInfoPage(){
//		User user = new User("Vovka","Vova","Hutei","vovka@gmail.com",passwordEncoder.encode("Vovk@1998"));
//		userService.saveUser(user);
//
//		System.out.println(user.getRoles().name());

//		User user1 = userService.findByUsername("Nameadsadsa");
//		System.out.println(user1.getUserName());

		return "aboutUs";
	}
}