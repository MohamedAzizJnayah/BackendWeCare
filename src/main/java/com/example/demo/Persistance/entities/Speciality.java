package com.example.demo.Persistance.entities;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data

public class Speciality implements Serializable {


    @Id
    private Long id;
    private String specialityName;


    public Long getId() {
        return id;
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
