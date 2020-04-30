package com.jocata.journal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jocata.journal.entity.User;

@Controller
public class FirstController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getIndexPage()	{
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage(Model model,
			@RequestParam(required=false) String error,
			@RequestParam(required=false) String logout,
			@RequestParam(required=false) String invalidSession,
			@RequestParam(required=false) String sessionExpired)	{
		
		if (error != null)
			model.addAttribute("error", "Invalid username or password");
		if (logout != null)
			model.addAttribute("logout", "Logout Successful");
		if (invalidSession != null)
			model.addAttribute("invalidSession", "Session is Invalid. Please Login");
		if (sessionExpired != null)
			model.addAttribute("sessionExpired", "Your Session is Expired. Please login again");
		
		return "login";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String getRegistrationPage()	{
		return "signup";
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user)	{
		return "redirect:/user/home";
	}
}
