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

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        // Recherche de la spécialité par son nom
        Speciality speciality = specialityRepository.findBySpecialityName(medecin.getSpecialitie().getSpecialityName())
                .orElseGet(() -> {
                    // Création et sauvegarde d'une nouvelle spécialité
                    Speciality newSpeciality = new Speciality();
                    newSpeciality.setSpecialityName(medecin.getSpecialitie().getSpecialityName());
                    return specialityRepository.save(newSpeciality);
                });

        // Associe la spécialité trouvée ou créée au médecin
        medecin.setSpecialitie(speciality);

        // Sauvegarde du médecin
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
