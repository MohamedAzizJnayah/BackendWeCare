package com.example.demo.service.controller;
import com.example.demo.Persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rendezvous")
public class RendezvousController {

    @Autowired
    IRendezVous RendezVousService;

    @PostMapping
    public Rendezvous saveRendezvous(@RequestBody Rendezvous rendezvous) {
        return RendezVousService.saveRendezvous(rendezvous);
    }

    @GetMapping("/{id}")
    public Rendezvous getRendezvousById(@PathVariable Long id) {
        return RendezVousService.getRendezvousById(id);
    }

    @GetMapping
    public List<Rendezvous> getAllRendezvous() {
        return RendezVousService.getAllRendezvous();
    }

    @DeleteMapping("/{id}")
    public void deleteRendezvous(@PathVariable Long id) {
        RendezVousService.deleteRendezvous(id);
    }
}
