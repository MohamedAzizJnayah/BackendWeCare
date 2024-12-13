package com.example.demo.service.Implements;
import com.example.demo.Persistance.dao.RendezvousRepository;
import com.example.demo.Persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService implements IRendezVous {

    @Autowired
    private RendezvousRepository rendezvousRepository;

    @Override
    public Rendezvous saveRendezvous(Rendezvous rendezvous) {
        return rendezvousRepository.save(rendezvous);
    }

    @Override
    public Rendezvous getRendezvousById(Long id) {
        return rendezvousRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rendezvous> getAllRendezvous() {
        return rendezvousRepository.findAll();
    }

    @Override
    public void deleteRendezvous(Long id) {
        rendezvousRepository.deleteById(id);
    }
}
