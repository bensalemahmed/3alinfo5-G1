package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employee;

@Repository
public interface EmployeeRepository extends  CrudRepository<Employee, Long>{

}
