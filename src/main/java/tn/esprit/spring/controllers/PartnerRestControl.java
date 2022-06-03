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

import tn.esprit.spring.entities.Partner;
import tn.esprit.spring.services.IPartnerService;

@RestController
public class PartnerRestControl {
	
	@Autowired 
	IPartnerService partnerService; 
 
	@GetMapping("/retrieve-all-Partners")
	public List<Partner> retrieveAllPartners() {
		List<Partner> list = partnerService.retrieveAllPartners();
		return list;
	}
 
	@GetMapping("/retrieve-Partner/{partner-id}")
	public Partner retrievePartner(@PathVariable("partner-id") String partnerId) {
		return partnerService.retrievePartner(partnerId);
	}

	@PostMapping("/add-Partner")
	public Partner addPartner(@RequestBody Partner partner) {
		Partner partner_added = partnerService.addPartner(partner); 
		return partner_added;
	}

	
	@DeleteMapping("/remove-Partner/{partner-id}") 
	public void deletePartner(@PathVariable("partner-id") String partnerId) { 
		partnerService.deletePartner(partnerId);
	} 

	
	@PutMapping("/modify-Partner") 
	public Partner updatePartner(@RequestBody Partner partner) {
		return partnerService.updatePartner(partner);
	}

}
