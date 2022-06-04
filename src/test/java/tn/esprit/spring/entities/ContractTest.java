package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.ContratServiceImpl;

@SpringBootTest
public class ContractTest {
	@Autowired
	ContratServiceImpl contratService;
	@Test
	
	public void addContratTest() {
		Contrat cont1 = new Contrat();
		cont1.setReference(1l);
		cont1.setTypeContrat("3Alinfo5");
		Contrat cont2 = contratService.addContrat(cont1);
		assertEquals(cont1.getReference(), cont2.getReference());
	}
	
	@Test
	public void deleteContratTest() {
		contratService.deleteContrat("1");
		assertNull(contratService.retrieveContrat("1"));
	}
}
