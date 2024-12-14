package com.example.demo.Persistance.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String password;
    
    @ManyToOne
    private Speciality specialitie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Speciality getSpecialitie() {
        return specialitie;
    }

    public void setSpecialitie(Speciality specialitie) {
        this.specialitie = specialitie;
    }
}