package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
public class EntrepriseTest {
	
	@Autowired
	EntrepriseServiceImpl entrepriseService;
	
	@Test
	public void addPartnerTest() {
		Entreprise entreprise = new Entreprise();
		entreprise.setId(1l);
		entreprise.setName("Vermeg");
		Entreprise entreprise2 = entrepriseService.addEntreprise(entreprise);
		assertEquals(entreprise.getId(), entreprise2.getId());
	}
	
	@Test
	public void deletePartnerTest() {
		entrepriseService.deleteEntreprise("1");
		assertNull(entrepriseService.retrieveEntreprise("1"));
	}

}
