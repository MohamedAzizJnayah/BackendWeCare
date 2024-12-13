package com.example.demo.Persistance.dao;

import com.example.demo.Persistance.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
    Medecin findByEmail(String email);
}
