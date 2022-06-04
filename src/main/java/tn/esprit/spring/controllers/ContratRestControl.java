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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
@RestController

public class ContratRestControl {


	@Autowired 
	IContratService contratService; 
 
	@GetMapping("/retrieve-all-Contrat")
	public List<Contrat> retrieveAllContrat() {
		List<Contrat> list = contratService.retrieveAllContrat();
		return list;
	}
 
	@GetMapping("/retrieve-Contrat/{contrat-id}")
	public Contrat retrieveContrat(@PathVariable("Contrat-id") String ContratId) {
		return contratService.retrieveContrat(ContratId);
	}

	@PostMapping("/add-Contrat")
	public Contrat addContrat(@RequestBody Contrat c) {
		Contrat contrat = contratService.addContrat(c); 
		return contrat;
	}

	
	@DeleteMapping("/remove-Contrat/{contrat-id}") 
	public void removeContrat(@PathVariable("contrat-id") String contratId) { 
		contratService.deleteContrat(contratId);
	} 

	
	@PutMapping("/modify-Contrat") 
	public Contrat updateContrat(@RequestBody Contrat contrat) {
		return contratService.updateContrat(contrat);
	}
	 


}
