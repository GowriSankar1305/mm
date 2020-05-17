package com.jocata.controller.admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
	
	@GetMapping(value="/login")
	public String getHome(Model model
			,@RequestParam(required=false) String error
			,@RequestParam(required=false) String logout)	{
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		if (error != null)
			model.addAttribute("error", "Invalid username or password");
		if (logout != null)
			model.addAttribute("logout", "Logged out successfully");
		return "login";
	}
}
