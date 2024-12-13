package com.example.demo.service.controller;


import com.example.demo.Persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	IPatient patientservice;

	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Patient save(@RequestBody Patient patient) {
		  System.out.println("*******save ***********");
		  Patient p=patientservice.savePatient(patient);
		  System.out.println("*******"+p.getEmail());
        return p ;
    }
	
	
	@GetMapping("/{id}")
    Patient getPatientById(@PathVariable Long id) {
        return patientservice.getPatient(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityPatient() {
        return patientservice.getQuantityOfPatient();
    }
	
	@GetMapping("/patientByName/{name}")
    Patient getPatientByName(@PathVariable String name) {
        return patientservice.findPatientByName(name);
    }
    @GetMapping("/patientByEmail/{email}")
    Patient findByEmail(@PathVariable String email) {
        return patientservice.findPatientByEmail(email);
    }
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        patientservice.deletePatient(id);
        return true;
    }
	
	
	
}
