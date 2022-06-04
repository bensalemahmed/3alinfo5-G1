package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repositories.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);


	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises = null;
		try {

			l.info("In Method retrieveAllEntreprises :");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Entreprise entreprise : entreprises) {
				l.debug("Entreprise :" + entreprise.getName() + " " + entreprise.getRaisonSocial());
			}
			l.info("Out of Method retrieveAllEntreprises with Success" + entreprises.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprises with Errors : " + e);
		}

		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		Entreprise entreprise_saved = null;
		try {
			l.info("In Method addEntreprise :");
			entreprise_saved = entrepriseRepository.save(entreprise);
			l.debug("Entreprise :" + entreprise.getName() + " " + entreprise.getRaisonSocial() + " is saved succesfully.");
			l.info("Out of Method addEntreprise with Success");
		} catch (Exception ex) {
			l.info("Out of Method addEntreprise with errors" + ex);
		}

		return entreprise_saved;
	}

	@Override
	public void deleteEntreprise(String id) {
		try {
			l.info("In Method deleteEntreprise :");
			entrepriseRepository.deleteById(Long.parseLong(id));
			l.debug("Entreprise with id : " + id + " is deleted succesfully.");
			l.info("Out of Method deleteEntreprise with Success");

		} catch (Exception e) {
			l.info("Out of Method deleteEntreprise with errors" + e);
		}
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise entreprise) {
		Entreprise entrepriseUpdated = null;

		try {
			l.info("In Method updateEntreprise :");
			entrepriseUpdated = entrepriseRepository.save(entreprise);
			l.debug("Entreprise :" + entreprise.getName() + " " + entreprise.getRaisonSocial() + " is updated succesfully.");
			l.info("Out of Method updateEntreprise with Success");
		} catch (Exception ex) {
			l.info("Out of Method updateEntreprise with errors" + ex);
		}

		return entrepriseUpdated;
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		Entreprise entreprise = null;
		try {
			l.info("In Method retrieveEntreprise :");
			entreprise = entrepriseRepository.findById(Long.parseLong(id)).get();
			l.debug("Entreprise with id : " + id + " exists.");
			l.info("Out of Method retrieveEntreprise with Success");

		} catch (Exception ex) {
			l.info("Out of Method retrieveEntreprise with errors" + ex);
		}

		return entreprise;
	}

}
