package com.example.demo.service.controller;

import com.example.demo.Persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private IPatient patientservice;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Patient save(@RequestBody Patient patient) {
        System.out.println("*******save ***********");
        Patient p = patientservice.savePatient(patient);
        System.out.println("*******" + p.getEmail());
        return p;
    }
    // Nouvelle méthode pour gérer la connexion
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient patient) {
        System.out.println("Patient email: " + patient.getEmail());
        System.out.println("Patient password: " + patient.getPassword());

        Patient existingPatient = patientservice.findPatientByEmail(patient.getEmail());

        if (existingPatient == null) {
            return ResponseEntity.status(401).body("Email incorrect.");
        }

        if (existingPatient.getPassword() != null && existingPatient.getPassword().equals(patient.getPassword())) {
            return ResponseEntity.ok(existingPatient);
        } else {
            return ResponseEntity.status(401).body("Mot de passe incorrect.");
        }
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




        // Si le patient n'existe pas ou le mot de passe est incorrect




}
