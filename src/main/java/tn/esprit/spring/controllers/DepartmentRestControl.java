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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.DepartmentServiceImpl;
import tn.esprit.spring.services.IDepartmentService;

@RestController
public class DepartmentRestControl {



	@Autowired
	IDepartmentService departmentService; 
 
	@GetMapping("/retrieve-all-Departements")
	public List<Departement> retrieveAllDepartements() {
		List<Departement> list = departmentService.retrieveAllDepartements();
		return list;
	}
 
	@GetMapping("/retrieve-Departement/{departement-id}")
	public Departement retrieveDepartement(@PathVariable("departement-id") Long departementId) {
		return departmentService.retrieveDepartement(departementId);
	}

	@PostMapping("/add-Departement")
	public Departement addDepartement(@RequestBody Departement d) {
		Departement departement = departmentService.addDepartement(d); 
		return departement;
	}

	
	@DeleteMapping("/remove-Departement/{departement-id}") 
	public void removeDepartement(@PathVariable("departement-id") Long departementId) { 
		departmentService.deleteDepartement(departementId);
	} 

	
	@PutMapping("/modify-Departement") 
	public Departement updateDepartement(@RequestBody Departement departement) {
		return departmentService.updateDepartement(departement);
	}
	 



}
