package com.jocata.journal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getIndexPage()	{
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage()	{
		return "login";
	}
}
