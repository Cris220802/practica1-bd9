package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.dto.EventoYRecursosDTO;
import com.practica.eventos.model.Especialidad;
import com.practica.eventos.model.Evento;
import com.practica.eventos.model.EventoYRecursos;
import com.practica.eventos.model.Perito;
import com.practica.eventos.repository.EventoRepository;
import com.practica.eventos.repository.EventoYRecursosRepository;

@Service
public class EventoYRecursosService {
    @Autowired
    private EventoYRecursosRepository eventoYRecursosRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoYRecursos> getAllEventoYRecursos() {
        return eventoYRecursosRepository.findAll();
    }

    public Optional<EventoYRecursos> getEventoYRecursosById(String id) {
        return eventoYRecursosRepository.findById(id);
    }

    public EventoYRecursos createEventoYRecursos(EventoYRecursosDTO eventoYRecursosDTO) {
        if (eventoYRecursosDTO == null) {
            throw new RuntimeException("El objeto oficioDTO no debe ser nulo");
        }

        if (eventoYRecursosDTO.getEvento() == null) {
            throw new RuntimeException("El ID del tipo de evento no debe ser nulo");
        }

        // Buscar TipoDeEventos por ID
        Evento evento = eventoRepository.findById(eventoYRecursosDTO.getEvento())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

        EventoYRecursos eventoYRecursos = new EventoYRecursos(evento, eventoYRecursosDTO.getTransporte(),
                eventoYRecursosDTO.getDineroPeajes(), eventoYRecursosDTO.getDineroPeajes());

        return eventoYRecursosRepository.save(eventoYRecursos);
    }

    public EventoYRecursos updateEventoYRecursos(String id, EventoYRecursosDTO eventoYRecursosDTO) {
        if (eventoYRecursosDTO == null) {
            throw new RuntimeException("El objeto oficioDTO no debe ser nulo");
        }

        if (eventoYRecursosDTO.getEvento() == null) {
            throw new RuntimeException("El ID del tipo de evento no debe ser nulo");
        }

        // Buscar TipoDeEventos por ID
        Evento evento = eventoRepository.findById(eventoYRecursosDTO.getEvento())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

        EventoYRecursos eventoYRecursosExistente = eventoYRecursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

        eventoYRecursosExistente.setEvento(evento);
        eventoYRecursosExistente.setDineroPeajes(eventoYRecursosDTO.getDineroPeajes());
        eventoYRecursosExistente.setDineroViaticos(eventoYRecursosDTO.getDineroViaticos());
        eventoYRecursosExistente.setTransporte(eventoYRecursosDTO.getTransporte());

        return eventoYRecursosRepository.save(eventoYRecursosExistente);
    }

    public void deleteEventoYRecursos(String id) {
        eventoYRecursosRepository.deleteById(id);
    }
}
