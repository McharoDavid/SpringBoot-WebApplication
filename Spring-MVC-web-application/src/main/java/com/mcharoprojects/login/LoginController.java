package com.mcharoprojects.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcharoprojects.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String handleLoginPost(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(!service.isUserValid(name, password)) {
			model.put("errorMessage", "Invalid Name or Password");
			return "login";
		}else {
			model.put("name", name);
			return "welcome";
		}
		
	}
	
//	@RequestMapping(value = "/")
//	public String Home() {
//		return "home";
	
//	}

}
