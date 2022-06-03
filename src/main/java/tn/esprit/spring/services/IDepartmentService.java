package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartmentService {

	List<Departement> retrieveAllDepartements(); 
	Departement addDepartement(Departement d);
	void deleteDepartement(Long id);
	Departement updateDepartement(Departement d);
	Departement retrieveDepartement(Long id);
}
