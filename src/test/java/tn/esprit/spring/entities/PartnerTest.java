package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.PartnerServiceImpl;

@SpringBootTest
public class PartnerTest {
	@Autowired
	PartnerServiceImpl partnerService;
	@Test
	
	public void addPartnerTest() {
		Partner partner = new Partner();
		partner.setId(1l);
		partner.setNom("Souhail");
		Partner partner2 = partnerService.addPartner(partner);
		assertEquals(partner.getId(), partner2.getId());
	}
	
	@Test
	public void deletePartnerTest() {
		partnerService.deletePartner("1");
		assertNull(partnerService.retrievePartner("1"));
	}
	

}
