package com.example.demo.service.interfaces;

import com.example.demo.Persistance.entities.Rendezvous;

import java.util.List;

public interface IRendezVous {

    // Créer ou enregistrer un rendez-vous
    Rendezvous saveRendezvous(Rendezvous rendezvous);

    // Récupérer un rendez-vous par ID
    Rendezvous getRendezvousById(Long id);

    // Récupérer tous les rendez-vous
    List<Rendezvous> getAllRendezvous();

    // Supprimer un rendez-vous par ID
    void deleteRendezvous(Long id);
}
