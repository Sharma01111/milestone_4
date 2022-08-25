package com.example.milestone4.EmployeeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.milestone4.Employee.Employee;
@Service
public class EmployeeService {
	private List<Employee> Employees = new ArrayList<>(Arrays.asList(
			new Employee("1","Rishabh","72000"),
			new Employee("2","Rochak","50000"),
			new Employee("3","Abhiraj","17000"),
			new Employee("4","Prajwal","80000"),
			new Employee("5","Sumit","30000"),
			new Employee("6","Shaddan","19000"),
			new Employee("7","Aman","63000"),
			new Employee("8","Agam","75000"),
			new Employee("9","Divyanshu","40000"),
			new Employee("10","Krishna","60000")
			));
	
	public List<Employee> getAllEmployees()
	{
		return Employees;
	}
	
	public Employee getEmployee(String id)
	{
		try {
		return Employees.stream().filter(t->t.getId().equals(id)).findFirst().get();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public void addEmployee(Employee Employee)
	{
		Employees.add(Employee);
	}
	
	public void updateEmployee(String id,Employee Employee)
	{
		for(int i=0;i<Employees.size();i++)
		{
			Employee t = Employees.get(i);
			if(t.getId().equals(id))
			{
				Employees.set(i, Employee);
				return;
			}
		}
	}
	
	public void deleteEmployee(String id)
	{
		Employees.removeIf(t->t.getId().equals(id));
	}


}
