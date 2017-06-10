package com.bridgelabz.SpringMvcPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.SpringMvcPro.Dao.UserRegistrationDao;
import com.bridgelabz.SpringMvcPro.Model.UserRegistrationModel;

@Controller
@RequestMapping("/")
public class UserRegistrationController {

	@Autowired
	UserRegistrationDao userRegistrationDao ;
	@RequestMapping(value = "userRegistration", method = RequestMethod.POST)
	public ModelAndView userRegistration() {
		return new ModelAndView("UserRegistration");
	}
	
	@RequestMapping(value = "registrationUser", method = RequestMethod.POST)
	public ModelAndView registrationUser(UserRegistrationModel registrationModel) {
		System.out.println(registrationModel.getName());
		System.out.println(registrationModel.getEmail());
		System.out.println(registrationModel.getMobilnumber());
		System.out.println(registrationModel.getPassword());
		userRegistrationDao.save(registrationModel);
		
	return new ModelAndView("UserLogin");

	}

}
