package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Departement;

@Repository
public interface DepartmentRepositoty extends CrudRepository <Departement, Long> {

}
