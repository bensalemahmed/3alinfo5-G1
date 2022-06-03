package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.DepartmentServiceImpl;


@SpringBootTest
public class DepartmentTest {
	
		@Autowired
		DepartmentServiceImpl departmentService;
		@Test
		
		public void addDepartmentTest() {
			Departement dep1 = new Departement();
			dep1.setId(1l);
			dep1.setName("3Alinfo5");
			Departement dep2 = departmentService.addDepartement(dep1);
			assertEquals(dep1.getId(), dep2.getId());
		}
		
		@Test
		public void deleteDepartmentTest() {
			departmentService.deleteDepartement(1l);
			assertNull(departmentService.retrieveDepartement(1l));
		}
		
	

	}

