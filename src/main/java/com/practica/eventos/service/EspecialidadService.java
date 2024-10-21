package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.Especialidad;
import com.practica.eventos.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Optional<Especialidad> getEspecialidadById(String id) {
        return especialidadRepository.findById(id);
    }

    public Especialidad createEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Especialidad updateEspecialidad(String id, Especialidad especialidad) {
        especialidad.setId(id);
        return especialidadRepository.save(especialidad);
    }

    public void deleteEspecialidad(String id) {
        especialidadRepository.deleteById(id);
    }
}
