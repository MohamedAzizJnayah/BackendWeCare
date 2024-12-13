package com.example.demo.Persistance.entities;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data

public class Speciality implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialityName;



    @OneToMany(mappedBy = "specialitie")
    private List<Medecin> medecins;
    public Long getId() {
        return id;
    }
    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}
