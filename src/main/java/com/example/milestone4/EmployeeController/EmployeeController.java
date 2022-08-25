package com.example.milestone4.EmployeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.milestone4.Exception.UserNotFoundException;
import com.example.milestone4.Employee.Employee;
import com.example.milestone4.EmployeeService.EmployeeService;



@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService EmployeeService;
	
	@RequestMapping("/Employees")
	public List<Employee> getAllEmployees()
	{
		return EmployeeService.getAllEmployees();
	}
	
	@RequestMapping("/Employees/{id}")
	public Employee geEmployee(@PathVariable String id)
	{
		Employee to = EmployeeService.getEmployee(id);
		if(to==null)
		{
			throw new UserNotFoundException("Id is not present");
		}
		return to;
	}
	
	@PostMapping("/Employees")
	public void addEmployee(@RequestBody Employee Employee)
	{
		EmployeeService.addEmployee(Employee);
	}
	
	@PutMapping("/Employees/{id}")
	public void updateEmployee(@RequestBody Employee Employee,@PathVariable String id)
	{
		EmployeeService.updateEmployee(id, Employee);
	}
	
	@DeleteMapping("/Employees/{id}")
	public void deleteEmployee(@PathVariable String id)
	{
		EmployeeService.deleteEmployee(id);
	}
	

}

