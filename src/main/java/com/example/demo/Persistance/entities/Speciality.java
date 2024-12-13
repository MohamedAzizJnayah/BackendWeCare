package com.example.demo.Persistance.entities;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Speciality implements Serializable {


    @Id
    private Long id;
    private String specialityName;








}
