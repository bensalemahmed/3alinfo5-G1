package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger l = LogManager.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<Employee> retrieveAllEmployees() {
		List<Employee> employees = null;
		try {

			l.info("In Method retrieveAllEmployees :");
			employees = (List<Employee>) employeeRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Employee e : employees) {
				l.debug("Employee :" + e.getPrenom() + " " + e.getNom());
			}
			l.info("Out of Method retrieveAllEmployees with Success" + employees.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllEmployees with Errors : " + e);
		}

		return employees;
	}

	@Override
	public Employee addEmployee(Employee e) {

		Employee e_saved = null;
		try {
			l.info("In Method addEmployee :");
			e_saved = employeeRepository.save(e);
			l.debug("Employee :" + e.getPrenom() + " " + e.getNom() + " is saved succesfully.");
			l.info("Out of Method addEmployee with Success");
		} catch (Exception ex) {
			l.info("Out of Method addEmployee with errors" + ex);
		}

		return e_saved;
	}

	@Override
	public Employee updateEmployee(Employee e) {

		Employee employeeUpdated = null;

		try {
			l.info("In Method updateEmployee :");
			employeeUpdated = employeeRepository.save(e);
			l.debug("Employee :" + e.getPrenom() + " " + e.getNom() + " is updated succesfully.");
			l.info("Out of Method updateEmployee with Success");
		} catch (Exception ex) {
			l.info("Out of Method updateEmployee with errors" + ex);
		}

		return employeeUpdated;
	}

	@Override
	public void deleteEmployee(String id) {

		try {
			l.info("In Method deleteEmployee :");
			employeeRepository.deleteById(Long.parseLong(id));
			l.debug("Employee with id : " + id + " is deleted succesfully.");
			l.info("Out of Method deleteEmployee with Success");

		} catch (Exception e) {
			l.info("Out of Method deleteEmployee with errors" + e);
		}

	}

	@Override
	public Employee retrieveEmployee(String id) {
		Employee e = null;
		try {
			l.info("In Method retrieveEmployee :");
			e = employeeRepository.findById(Long.parseLong(id)).get();
			l.debug("Employee with id : " + id + " exists.");
			l.info("Out of Method retrieveEmployee with Success");

		} catch (Exception ex) {
			l.info("Out of Method retrieveEmployee with errors" + ex);
		}

		return e;
	}

}
