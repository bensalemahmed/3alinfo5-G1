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

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RestController
public class EntrepriseRestControl {
	
	@Autowired 
	IEntrepriseService entrepriseService; 
 
	@GetMapping("/retrieve-all-Entreprises")
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> list = entrepriseService.retrieveAllEntreprises();
		return list;
	}
 
	@GetMapping("/retrieve-Entreprise/{entreprise-id}")
	public Entreprise retrieveEntreprise(@PathVariable("entreprise-id") String entrepriseId) {
		return entrepriseService.retrieveEntreprise(entrepriseId);
	}

	@PostMapping("/add-Entreprise")
	public Entreprise addEntreprise(@RequestBody Entreprise entreprise) {
		Entreprise entreprise_added = entrepriseService.addEntreprise(entreprise); 
		return entreprise_added;
	}

	
	@DeleteMapping("/remove-Entreprise/{entreprise-id}") 
	public void deleteEntreprise(@PathVariable("entreprise-id") String entrepriseId) { 
		entrepriseService.deleteEntreprise(entrepriseId);
	} 

	
	@PutMapping("/modify-Entreprise") 
	public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
		return entrepriseService.updateEntreprise(entreprise);
	}

}
