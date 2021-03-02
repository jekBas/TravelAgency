package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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




	@RequestMapping("/aboutUs")
	public String showInfoPage(){
//		User user = new User("Nameadsadsa","testmaildsa@gmail.com","Qwerty@1234");
//		userService.saveUser(user);

		return "aboutUs";
	}
}