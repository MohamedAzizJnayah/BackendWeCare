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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String password;
    @OneToMany(mappedBy = "medecin")
    private List<Rendezvous> Listrdv;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Speciality> specialities;

}