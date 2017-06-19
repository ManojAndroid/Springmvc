package com.bridgelabz.SpringFormRegistration.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bridgelabz.SpringFormRegistration.Model.StudentRegistrationModel;

public class FormValidation  implements Validator{

	 private Pattern pattern;  
	 private Matcher matcher;  
	  
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	 String ID_PATTERN = "[0-9]+";  
	 String STRING_PATTERN = "[a-zA-Z]+";  
	 String MOBILE_PATTERN = "[0-9]{10}";  
	  
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) 
	
	
	{
		StudentRegistrationModel   studentRegistrationModel=(StudentRegistrationModel) target; 
		 /* first name validation*/
		 ValidationUtils.rejectIfEmpty(errors, "name", "required.name",  "Name is required.");  
		  if (!(studentRegistrationModel.getName() != null && studentRegistrationModel.getName().isEmpty())) 
		  {  
		   pattern = Pattern.compile(STRING_PATTERN);  
		   matcher = pattern.matcher(studentRegistrationModel.getName());  
		   if (!matcher.matches()) {  
		    errors.rejectValue("name", "name.containNonChar",  
		      "Enter a valid name");  
		   }  
		  } 
		  
		  
		  /* Last name validation*/
		  ValidationUtils.rejectIfEmpty(errors, "lastname", "required.lastname","lastname is required.");  
		  if (!(studentRegistrationModel.getLastname() != null && studentRegistrationModel.getLastname().isEmpty())) 
		  {  
		   pattern = Pattern.compile(STRING_PATTERN);  
		   matcher = pattern.matcher(studentRegistrationModel.getLastname());  
		   if (!matcher.matches())
		   {  
		    errors.rejectValue("lastname", "lastname.containNonChar", "Enter a valid lastname");  
		   }  
		  } 
		  
		  
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",  
				    "required.password", "Password is required.");  
				  
				// password matching validation  
				  /*if (!studentRegistrationModel.getPassword().equals(studentRegistrationModel.getConfirmpassword())) {  
				   errors.rejectValue("confirmPassword", "password.mismatch",  
				     "Password does not match");  
				  }*/  
		  
		  
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip",  
				    "required.zip", "zip is required.");  
		  
		  
		  
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","required.email", "Email is required.");  
				// email validation in spring  
				  if (!(studentRegistrationModel.getEmail() != null && studentRegistrationModel.getEmail().isEmpty())) 
				  {  
				   pattern = Pattern.compile(EMAIL_PATTERN);  
				   matcher = pattern.matcher(studentRegistrationModel.getEmail());  
				   if (!matcher.matches()) 
				   { 
					   errors.rejectValue("email", "email.incorrect","Enter a correct email");  
				   }  
				  }  
				  
		  
				  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age",  
						    "required.age", "age is required.");
		  
	}

}
