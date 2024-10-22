package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.dto.PeritoDTO;
import com.practica.eventos.model.Especialidad;
import com.practica.eventos.model.Oficio;
import com.practica.eventos.model.Perito;
import com.practica.eventos.model.Sede;
import com.practica.eventos.model.TipoDeEventos;
import com.practica.eventos.repository.EspecialidadRepository;
import com.practica.eventos.repository.PeritoRepository;

@Service
public class PeritoService {
    @Autowired
    private PeritoRepository peritoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Perito> getAllPeritos() {
        return peritoRepository.findAll();
    }

    public Optional<Perito> getPeritoById(String id) {
        return peritoRepository.findById(id);
    }

    public Perito createPerito(PeritoDTO peritoDTO) {
        if (peritoDTO == null) {
            throw new RuntimeException("El objeto oficioDTO no debe ser nulo");
        }

        if (peritoDTO.getEspecialidad() == null) {
            throw new RuntimeException("El ID del tipo de evento no debe ser nulo");
        }

        // Buscar TipoDeEventos por ID
        Especialidad especialidad = especialidadRepository.findById(peritoDTO.getEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

        Perito perito = new Perito(peritoDTO.getNombre(), peritoDTO.getApellido(), especialidad);

        return peritoRepository.save(perito);
    }

    public void deletePerito(String id) {
        peritoRepository.deleteById(id);
    }

    public Perito updatePerito(String id, PeritoDTO peritoDTO) {
        if (peritoDTO == null) {
            throw new RuntimeException("El objeto oficioDTO no debe ser nulo");
        }

        if (peritoDTO.getEspecialidad() == null) {
            throw new RuntimeException("El ID del tipo de evento no debe ser nulo");
        }

        Perito peritoExistente = peritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perito no encontrado"));

        Especialidad especialidad = especialidadRepository.findById(peritoDTO.getEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

        peritoExistente.setNombre(peritoDTO.getNombre());
        peritoExistente.setApellido(peritoDTO.getApellido());
        peritoExistente.setEspecialidad(especialidad);
        
        return peritoRepository.save(peritoExistente);
    }
}
