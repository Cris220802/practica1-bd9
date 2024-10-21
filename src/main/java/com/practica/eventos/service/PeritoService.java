package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.Perito;
import com.practica.eventos.repository.PeritoRepository;

@Service
public class PeritoService {
    @Autowired
    private PeritoRepository peritoRepository;

    public List<Perito> getAllPeritos() {
        return peritoRepository.findAll();
    }

    public Optional<Perito> getPeritoById(String id) {
        return peritoRepository.findById(id);
    }

    public Perito createPerito(Perito perito) {
        return peritoRepository.save(perito);
    }

    public void deletePerito(String id) {
        peritoRepository.deleteById(id);
    }

    public Perito updatePerito(String id, Perito perito) {
        return peritoRepository.findById(id).map(existingPerito -> {
            existingPerito.setNombre(perito.getNombre());
            existingPerito.setApellido(perito.getApellido());
            existingPerito.setEspecialidad(perito.getEspecialidad());
            return peritoRepository.save(existingPerito);
        }).orElseThrow(() -> new RuntimeException("Perito not found"));
    }
}
