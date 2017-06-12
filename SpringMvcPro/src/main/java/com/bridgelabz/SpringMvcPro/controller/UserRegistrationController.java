package com.bridgelabz.SpringMvcPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String registrationUser(Model model,UserRegistrationModel registrationModel,@RequestParam String email) {

		
		boolean loginResult = userRegistrationDao.emailExistValidation(email);
		if (loginResult == true) {
			model.addAttribute("msg", "This Email aready exist");
			return "UserRegistration";
		}
		else{
		System.out.println(registrationModel.getName());
		System.out.println(registrationModel.getEmail());
		System.out.println(registrationModel.getMobilnumber());
		System.out.println(registrationModel.getPassword());
		userRegistrationDao.save(registrationModel);
		model.addAttribute("sucess", "Sucessfully Registered");
		return "UserLogin";
		}
	}

}
