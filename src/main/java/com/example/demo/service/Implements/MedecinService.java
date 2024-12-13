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
    private MedecinRepository medecinRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    public Medecin saveMedecin(Medecin medecin) {
        // Vérifie si la spécialité existe déjà par son ID
        Speciality speciality = specialityRepository.findById(medecin.getSpecialitie().getId())
                .orElseGet(() -> {
                    // Si la spécialité n'existe pas, crée une nouvelle spécialité
                    Speciality newSpeciality = new Speciality();
                    newSpeciality.setId(medecin.getSpecialitie().getId());  // Utilise l'ID transmis par le Medecin
                    newSpeciality.setSpecialityName(medecin.getSpecialitie().getSpecialityName());  // Associe le nom
                    return specialityRepository.save(newSpeciality);  // Sauvegarde la nouvelle spécialité
                });

        // Associe la spécialité au médecin
        medecin.setSpecialitie(speciality);

        // Sauvegarde le médecin
        return medecinRepository.save(medecin);
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
