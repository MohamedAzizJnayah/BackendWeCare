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

    // Nouvelle méthode pour gérer la connexion
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient patient) {
        Patient existingPatient = patientservice.findPatientByEmail(patient.getEmail());

        if (existingPatient != null && existingPatient.getPassword().equals(patient.getPassword())) {
            // Si le patient existe et que le mot de passe est correct
            return ResponseEntity.ok(existingPatient); // Retourne les informations du patient
        } else {
            // Si les informations sont incorrectes
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect."); // Erreur d'authentification
        }
    }
}
