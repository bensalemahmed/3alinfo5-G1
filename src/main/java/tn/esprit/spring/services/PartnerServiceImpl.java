package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Partner;
import tn.esprit.spring.repositories.PartnerRepository;

@Service
public class PartnerServiceImpl implements IPartnerService {
	
	@Autowired
	PartnerRepository partnerRepository;

	private static final Logger l = LogManager.getLogger(PartnerServiceImpl.class);

	@Override
	public List<Partner> retrieveAllPartners() {
		List<Partner> partners = null;
		try {

			l.info("In Method retrieveAllPartners :");
			partners = (List<Partner>) partnerRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Partner partner : partners) {
				l.debug("Partner :" + partner.getPrenom() + " " + partner.getNom());
			}
			l.info("Out of Method retrieveAllPartners with Success" + partners.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllPartners with Errors : " + e);
		}

		return partners;
	}

	@Override
	public Partner addPartner(Partner partner) {

		Partner partner_saved = null;
		try {
			l.info("In Method addPartner :");
			partner_saved = partnerRepository.save(partner);
			l.debug("Partner :" + partner.getPrenom() + " " + partner.getNom() + " is saved succesfully.");
			l.info("Out of Method addPartner with Success");
		} catch (Exception ex) {
			l.info("Out of Method addPartner with errors" + ex);
		}

		return partner_saved;
	}

	@Override
	public Partner updatePartner(Partner partner) {

		Partner partnerUpdated = null;

		try {
			l.info("In Method updatePartner :");
			partnerUpdated = partnerRepository.save(partner);
			l.debug("Partner :" + partner.getPrenom() + " " + partner.getNom() + " is updated succesfully.");
			l.info("Out of Method updatePartner with Success");
		} catch (Exception ex) {
			l.info("Out of Method updatePartner with errors" + ex);
		}

		return partnerUpdated;
	}

	@Override
	public void deletePartner(String id) {

		try {
			l.info("In Method deletePartner :");
			partnerRepository.deleteById(Long.parseLong(id));
			l.debug("Partner with id : " + id + " is deleted succesfully.");
			l.info("Out of Method deletePartner with Success");

		} catch (Exception e) {
			l.info("Out of Method deletePartner with errors" + e);
		}

	}

	@Override
	public Partner retrievePartner(String id) {
		
		Partner partner = null;
		try {
			l.info("In Method retrievePartner :");
			partner = partnerRepository.findById(Long.parseLong(id)).get();
			l.debug("Partner with id : " + id + " exists.");
			l.info("Out of Method retrievePartner with Success");

		} catch (Exception ex) {
			l.info("Out of Method retrievePartner with errors" + ex);
		}

		return partner;
	}

}
