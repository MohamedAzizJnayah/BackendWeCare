package com.example.demo.service.interfaces;

import com.example.demo.Persistance.entities.Speciality;

import java.util.List;
import java.util.Optional;

public interface ISpeciality {

    // Créer ou enregistrer une spécialité
    Speciality saveSpeciality(Speciality speciality);
Optional<Speciality> getSpecialityByName(String specialite);
    // Récupérer une spécialité par ID
    Speciality getSpecialityById(Long id);

    // Récupérer toutes les spécialités
    List<Speciality> getAllSpecialities();

    // Supprimer une spécialité par ID
    void deleteSpeciality(Long id);
}
