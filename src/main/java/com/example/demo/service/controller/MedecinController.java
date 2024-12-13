package com.example.demo.service.controller;

import com.example.demo.Persistance.entities.Medecin;
import com.example.demo.service.interfaces.IMedecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/medecin")
public class MedecinController {

    @Autowired
    private IMedecin medecinService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Medecin save(@RequestBody Medecin medecin) {

        Medecin m = medecinService.saveMedecin(medecin);

        return m;
    }

    @GetMapping("/{id}")
    public Medecin getMedecinById(@PathVariable Long id) {
        return medecinService.getMedecin(id);
    }

    @GetMapping("/quantity")
    public int getQuantityMedecin() {
        return medecinService.getQuantityOfMedecin();
    }

    @GetMapping("/medecinByName/{name}")
    public Medecin getMedecinByName(@PathVariable String name) {
        return medecinService.findMedecinByName(name);
    }

    @GetMapping("/findByEmail/{email}")
    public Medecin findByEmail(@PathVariable String email) {
        return medecinService.findByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        medecinService.deleteMedecin(id);
        return true;
    }

    // Nouvel endpoint pour le login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Medecin medecin) {
        Medecin existingMedecin = medecinService.findByEmail(medecin.getEmail());

        if (existingMedecin != null && existingMedecin.getPassword().equals(medecin.getPassword())) {
            return ResponseEntity.ok(existingMedecin); // Retourne les informations du médecin en cas de succès
        }

        return ResponseEntity.status(401).body("Email ou mot de passe incorrect."); // Erreur d'authentification
    }
}
