package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/")
	public String showLoginPage(){
		return "signIn";
	}

	@RequestMapping("/aboutUs")
	public String showInfoPage(){
		return "aboutUs";
	}
}