package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Partner;

public interface PartnerRepository extends  CrudRepository<Partner, Long> {

}
