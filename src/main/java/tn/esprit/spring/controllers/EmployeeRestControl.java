package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.services.IEmployeeService;

@RestController

public class EmployeeRestControl {


	@Autowired 
	IEmployeeService employeeService; 
 
	@GetMapping("/retrieve-all-Employees")
	public List<Employee> retrieveAllEmployees() {
		List<Employee> list = employeeService.retrieveAllEmployees();
		return list;
	}
 
	@GetMapping("/retrieve-Employee/{employee-id}")
	public Employee retrieveEmployee(@PathVariable("employee-id") String EmployeeId) {
		return employeeService.retrieveEmployee(EmployeeId);
	}

	@PostMapping("/add-Employee")
	public Employee addEmployee(@RequestBody Employee e) {
		Employee employee = employeeService.addEmployee(e); 
		return employee;
	}

	
	@DeleteMapping("/remove-Employee/{employee-id}") 
	public void removeEmployee(@PathVariable("employee-id") String employeeId) { 
		employeeService.deleteEmployee(employeeId);
	} 

	
	@PutMapping("/modify-Employee") 
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	 


}
