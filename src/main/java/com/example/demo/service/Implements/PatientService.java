package com.example.demo.service.Implements;


import com.example.demo.Persistance.dao.PatientRepository;
import com.example.demo.Persistance.entities.Medecin;
import com.example.demo.Persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatient {

	@Autowired
	PatientRepository patientrepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepository.saveAndFlush(patient);
	}

	@Override
	public boolean deletePatient(Long id) {
		// TODO Auto-generated method stub
		 patientrepository.deleteById(id);
		return true;
	}

	@Override
	public List<Patient> getListPatient() {
		// TODO Auto-generated method stub
		return  patientrepository.findAll();
	}

	@Override
	public Patient getPatient(Long id) {
		// TODO Auto-generated method stub
		return  patientrepository.findById(id).get();
	}

	@Override
	public Patient findPatientByName(String name) {
		// TODO Auto-generated method stub
		return  patientrepository.findByNom(name);
	}

	@Override
	public Patient findPatientByEmail(String Email) {
		return patientrepository.findByEmail(Email);
	}

	@Override
	public int getQuantityOfPatient() {
		// TODO Auto-generated method stub
		return  patientrepository.getQuantityOfPatient();
	}

	@Override
	public Patient getPatientByIdPatient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
