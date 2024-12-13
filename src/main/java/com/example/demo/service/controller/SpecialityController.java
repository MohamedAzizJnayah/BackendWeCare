package com.example.demo.service.controller;
import com.example.demo.Persistance.dao.SpecialityRepository;
import com.example.demo.Persistance.entities.Speciality;
import com.example.demo.service.interfaces.ISpeciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/speciality")
public class SpecialityController {

    @Autowired
    private ISpeciality specialityService;
    @Autowired
    private SpecialityRepository specialityRepository;

    @PostMapping
    public Speciality saveSpeciality(@RequestBody Speciality speciality) {
        return specialityService.saveSpeciality(speciality);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> getSpecialityById(@PathVariable Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        if (speciality.isPresent()) {
            return ResponseEntity.ok(speciality.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public List<Speciality> getAllSpecialities() {
        return specialityService.getAllSpecialities();
    }

    @DeleteMapping("/{id}")
    public void deleteSpeciality(@PathVariable Long id) {
        specialityService.deleteSpeciality(id);
    }
}
