package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.Oficio;
import com.practica.eventos.repository.OficioRepository;

@Service
public class OficioService {
    @Autowired
    private OficioRepository oficioRepository;

    public List<Oficio> getAllOficios() {
        return oficioRepository.findAll();
    }

    public Optional<Oficio> getOficioById(String id) {
        return oficioRepository.findById(id);
    }

    public Oficio createOficio(Oficio oficio) {
        return oficioRepository.save(oficio);
    }

    public Oficio updateOficio(String id, Oficio oficio) {
        Optional<Oficio> existingOficio = oficioRepository.findById(id);
        if (existingOficio.isPresent()) {
            oficio.setId(id);
            return oficioRepository.save(oficio);
        }
        return null;
    }

    public void deleteOficio(String id) {
        oficioRepository.deleteById(id);
    }
}
