package com.example.demo.service.interfaces;

import com.example.demo.Persistance.entities.Medecin;

public interface IMedecin {

    // Sauvegarder un médecin
    Medecin saveMedecin(Medecin medecin);

    // Récupérer un médecin par ID
    Medecin getMedecin(Long id);

    // Récupérer un médecin par nom
    Medecin findMedecinByName(String name);
    Medecin findByEmail(String email);
    // Récupérer la quantité totale de médecins
    int getQuantityOfMedecin();

    // Supprimer un médecin par ID
    void deleteMedecin(Long id);
}
