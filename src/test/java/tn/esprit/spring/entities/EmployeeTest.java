package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.DepartmentServiceImpl;
import tn.esprit.spring.services.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeTest {
	@Autowired
	EmployeeServiceImpl employeeService;
	@Test
	
	public void addEmployeeTest() {
		Employee emp1 = new Employee();
		emp1.setId(1l);
		emp1.setNom("3Alinfo5");
		Employee emp2 = employeeService.addEmployee(emp1);
		assertEquals(emp1.getId(), emp2.getId());
	}
	
	@Test
	public void deleteEmployeeTest() {
		employeeService.deleteEmployee("1");
		assertNull(employeeService.retrieveEmployee("1"));
	}
}
