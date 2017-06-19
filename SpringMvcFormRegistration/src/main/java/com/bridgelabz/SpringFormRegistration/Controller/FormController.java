package com.bridgelabz.SpringFormRegistration.Controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.SpringFormRegistration.Model.StudentRegistrationModel;
import com.bridgelabz.SpringFormRegistration.Validation.FormValidation;

@Controller
public class FormController {

	@RequestMapping(value = "/")
	public ModelAndView initForm() 
	{

		return new ModelAndView("StudentRegistration", "form", new StudentRegistrationModel());
		

	}
	   @ExceptionHandler(/*{SpringException.class}*/)

	@RequestMapping(value = "Register", method = RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute("form") @Valid StudentRegistrationModel form, BindingResult result) 
	{
		
		
		  FormValidation formValidation = new FormValidation();  
		  formValidation.validate(form, result);  
		  
		  if (result.hasErrors()) {  
			return new ModelAndView("StudentRegistration","form",form);

		}

		return new ModelAndView("StudentLogin");

	}

}
