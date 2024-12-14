package com.example.demo.Persistance.dao;

import com.example.demo.Persistance.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
    Medecin findByEmail(String email);
    // Méthode pour récupérer les médecins par ID de spécialité
    @Query("SELECT m FROM Medecin m WHERE m.specialitie.id = :specialiteId")
    List<Medecin> findMedecinsBySpecialiteId(Long specialiteId);
}
