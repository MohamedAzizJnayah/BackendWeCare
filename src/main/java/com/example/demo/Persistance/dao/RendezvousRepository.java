package com.example.demo.Persistance.dao;

import com.example.demo.Persistance.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
}
