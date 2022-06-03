package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Partner;


public interface IPartnerService {
	
	List<Partner> retrieveAllPartners(); 
	Partner addPartner(Partner partner);
	void deletePartner(String id);
	Partner updatePartner(Partner partner);
	Partner retrievePartner(String id);

}
