package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.Sede;
import com.practica.eventos.repository.SedeRepository;

@Service
public class SedeService {
    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    public Optional<Sede> getSedeById(String id) {
        return sedeRepository.findById(id);
    }

    public Sede createSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public Sede updateSede(String id, Sede sede) {
        Optional<Sede> existingSede = sedeRepository.findById(id);
        if (existingSede.isPresent()) {
            sede.setId(id);
            return sedeRepository.save(sede);
        }
        return null;
    }

    public void deleteSede(String id) {
        sedeRepository.deleteById(id);
    }
}
