package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repositories.DepartmentRepositoty;

@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	DepartmentRepositoty departmentRepository;

	private static final Logger l = LogManager.getLogger(DepartmentServiceImpl.class);

	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> departements = null;
		try {

			l.info("In Method retrieveAllDepartements :");
			departements = (List<Departement>) departmentRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Departement d : departements) {
				l.debug("Departement :" + d.getName());
			}
			l.info("Out of Method retrieveAllDepartements with Success" + departements.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllDepartements with Errors : " + e);
		}

		return departements;
	}

	@Override
	public Departement addDepartement(Departement d) {

		Departement d_saved = null;
		try {
			l.info("In Method addDepartement :");
			d_saved = departmentRepository.save(d);
			l.debug("Departement :" + d.getName() + " is saved succesfully.");
			l.info("Out of Method addDepartement with Success");
		} catch (Exception ex) {
			l.info("Out of Method addDepartement with errors" + ex);
		}

		return d_saved;
	}

	@Override
	public Departement updateDepartement(Departement d) {

		Departement departementUpdated = null;

		try {
			l.info("In Method updateDepartement :");
			departementUpdated = departmentRepository.save(d);
			l.debug("Departement :" + d.getName() + " is updated succesfully.");
			l.info("Out of Method updateDepartement with Success");
		} catch (Exception ex) {
			l.info("Out of Method updateDepartement with errors" + ex);
		}

		return departementUpdated;
	}

	@Override
	public void deleteDepartement(Long id) {

		try {
			l.info("In Method deleteDepartement :");
			departmentRepository.deleteById(id);
			l.debug("Departement with id : " + id + " is deleted succesfully.");
			l.info("Out of Method deleteDepartement with Success");

		} catch (Exception e) {
			l.info("Out of Method deleteDepartement with errors" + e);
		}

	}

	@Override
	public Departement retrieveDepartement(Long id) {
		Departement d = null;
		try {
			l.info("In Method retrieveDepartement :");
			d = departmentRepository.findById(id).get();
			l.debug("Departement with id : " + id + " exists.");
			l.info("Out of Method retrieveDepartement with Success");

		} catch (Exception ex) {
			l.info("Out of Method retrieveDepartement with errors" + ex);
		}

		return d;
	}

}
