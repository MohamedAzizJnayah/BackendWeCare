package com.example.demo.service.controller;
import com.example.demo.Persistance.entities.Speciality;
import com.example.demo.service.interfaces.ISpeciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/speciality")
public class SpecialityController {

    @Autowired
    private ISpeciality specialityService;

    @PostMapping
    public Speciality saveSpeciality(@RequestBody Speciality speciality) {
        return specialityService.saveSpeciality(speciality);
    }

    @GetMapping("/{id}")
    public Speciality getSpecialityById(@PathVariable Long id) {
        return specialityService.getSpecialityById(id);
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
