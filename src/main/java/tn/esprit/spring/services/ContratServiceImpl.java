package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repositories.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	@Override
	public List<Contrat> retrieveAllContrat() {
		List<Contrat> contrat = null;
		try {

			l.info("In Method retrieveAllContrat :");
			contrat = (List<Contrat>) contratRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Contrat c : contrat) {
				l.debug("Contrat :" + c.getReference() + " of employee " + c.getEmploye());
			}
			l.info("Out of Method retrieveAllContracts with Success" + contrat.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllContracts with Errors : " + e);
		}

		return contrat;
	}

	@Override
	public Contrat addContrat(Contrat c) {

		Contrat c_saved = null;
		try {
			l.info("In Method addContrat :");
			c_saved = contratRepository.save(c);
			l.debug("Contrat :" + c.getReference() + " of employee " + c.getEmploye() + " is saved succesfully.");
			l.info("Out of Method addContrat with Success");
		} catch (Exception ex) {
			l.info("Out of Method addContrat with errors" + ex);
		}

		return c_saved;
	}

	@Override
	public Contrat updateContrat(Contrat c) {

		Contrat contratUpdated = null;

		try {
			l.info("In Method updateContrat :");
			contratUpdated = contratRepository.save(c);
			l.debug("Contrat :" + c.getReference() + " of employee " + c.getEmploye() + " is updated succesfully.");
			l.info("Out of Method updateContrat with Success");
		} catch (Exception ex) {
			l.info("Out of Method updateContrat with errors" + ex);
		}

		return contratUpdated;
	}

	@Override
	public void deleteContrat(String id) {

		try {
			l.info("In Method deleteContrat :");
			contratRepository.deleteById(Long.parseLong(id));
			l.debug("Contrat with id : " + id + " is deleted succesfully.");
			l.info("Out of Method deleteContrat with Success");

		} catch (Exception e) {
			l.info("Out of Method deleteContrat with errors" + e);
		}

	}

	@Override
	public Contrat retrieveContrat(String id) {
		Contrat c = null;
		try {
			l.info("In Method retrieveContrat :");
			c = contratRepository.findById(Long.parseLong(id)).get();
			l.debug("Contrat with id : " + id + " exists.");
			l.info("Out of Method retrieveContrat with Success");

		} catch (Exception ex) {
			l.info("Out of Method retrieveContrat with errors" + ex);
		}

		return c;
	}

}
