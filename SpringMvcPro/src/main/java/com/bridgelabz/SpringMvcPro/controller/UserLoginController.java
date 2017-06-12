package com.bridgelabz.SpringMvcPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.SpringMvcPro.Dao.UserRegistrationDao;

@Controller
@RequestMapping("/")
public class UserLoginController {
	@Autowired
	UserRegistrationDao userRegistrationDao;

	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public ModelAndView userLogin() {
		return new ModelAndView("UserLogin");
	}

	@RequestMapping(value = "LoginUser", method = RequestMethod.POST)
	public ModelAndView userLogin1(@RequestParam String email, @RequestParam String password) {

		System.out.println(email);
		System.out.println(password);
		if (email != null && password != null) {
			
			boolean loginResult=userRegistrationDao.Login(email, password);
			System.out.println(loginResult);
			if(loginResult==true)
			{
			return new ModelAndView("Home");
			}
			else
			{
				return new ModelAndView("UserLogin");

			}
		}
		return new ModelAndView("UserLogin");

	}
}
