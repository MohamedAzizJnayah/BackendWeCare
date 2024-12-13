package com.example.demo.service.Implements;

import com.example.demo.Persistance.dao.SpecialityRepository;
import com.example.demo.Persistance.entities.Medecin;
import com.example.demo.Persistance.dao.MedecinRepository;
import com.example.demo.Persistance.entities.Speciality;
import com.example.demo.service.interfaces.IMedecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedecinService implements IMedecin {

    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public Medecin saveMedecin(Medecin medecin) {
          // Assigne la spécialité au médecin
        return medecinRepository.save(medecin);  // Sauvegarde le médecin
    }


    @Override
    public Medecin getMedecin(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinByName(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public Medecin findByEmail(String email) {
        return medecinRepository.findByEmail(email);
    }

    @Override
    public int getQuantityOfMedecin() {
        return (int) medecinRepository.count();
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

}
