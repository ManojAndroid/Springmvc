package com.bridgelabz.SpringRestController.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.SpringRestController.model.Employee;
 
 
@RestController

/*@RequestMapping("")*/
public class EmployeeController {
 
    Employee employee = new Employee();
 
    @RequestMapping(value="/kfc/brands",produces="application/Xml")
	public @ResponseBody Employee getEmployeeInXML() {

		
    	employee.setName("manoj");
    	employee.setEmail("manojkmrsingh71@gmail.com");
    	System.out.println(employee);
		return employee;
	

	}
   /* @RequestMapping(value="/kfc/brands",produces="application/Json")
	public @ResponseBody Employee getEmployeeInJSON() {

		
    	employee.setName("manoj");
    	employee.setEmail("manojkmrsingh71@gmail.com");
    	System.out.println(employee);
		return employee;
	

	}*/
 

 
}