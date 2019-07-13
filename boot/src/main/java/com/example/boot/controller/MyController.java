package com.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.boot.beans.User;
import com.example.boot.service.UserService;


@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping({"/","/home"})
	public String getHomePage()	{
		return "index";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String getLoginPage()	{
		return "login";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String getRegistrationPage()	{
		return "register";
	}
	
	@RequestMapping(value="checkuser",method= {RequestMethod.POST,RequestMethod.GET})
	public String validateUser()	{
		return "userHome";
	}
	
	@RequestMapping(value="saveUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user)	{
		User user1 = userService.saveUser(user);
		return "redirect:/checkuser";
	}
}
