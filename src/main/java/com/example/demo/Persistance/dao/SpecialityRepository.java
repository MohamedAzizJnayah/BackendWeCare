package com.example.demo.Persistance.dao;

import com.example.demo.Persistance.entities.Medecin;
import com.example.demo.Persistance.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
