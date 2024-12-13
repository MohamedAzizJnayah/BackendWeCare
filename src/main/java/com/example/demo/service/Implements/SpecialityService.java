package com.example.demo.service.Implements;

import com.example.demo.Persistance.entities.Speciality;
import com.example.demo.Persistance.dao.SpecialityRepository;
import com.example.demo.service.interfaces.ISpeciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService implements ISpeciality {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Speciality saveSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality); // Utilisation correcte
    }

    @Override
    public Optional<Speciality> getSpecialityByName(String specialityName) {
        return specialityRepository.findBySpecialityName(specialityName);
    }

    @Override
    public Speciality getSpecialityById(Long id) {
        return specialityRepository.findById(id).orElse(null); // Utilisation correcte
    }




    @Override
    public List<Speciality> getAllSpecialities() {
        return specialityRepository.findAll(); // Utilisation correcte
    }

    @Override
    public void deleteSpeciality(Long id) {
        specialityRepository.deleteById(id); // Utilisation correcte
    }
}
