package com.example.demo.service.interfaces;


import com.example.demo.Persistance.entities.Patient;

import java.util.List;

public interface IPatient {

		Patient savePatient(Patient patient);
	     Patient updatePatient(Patient patient);
	     boolean deletePatient(Long id);
	     List<Patient> getListPatient();
	     Patient getPatient(Long id);
	     Patient findPatientByName(String name);
		 Patient findPatientByEmail(String Email);
	     int getQuantityOfPatient();
	     Patient getPatientByIdPatient(Long id);
	
	
}
