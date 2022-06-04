package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseRepository extends  CrudRepository<Entreprise, Long> {

}
