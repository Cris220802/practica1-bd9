package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.EventoYRecursos;
import com.practica.eventos.repository.EventoYRecursosRepository;

@Service
public class EventoYRecursosService {
    @Autowired
    private EventoYRecursosRepository eventoYRecursosRepository;

    public List<EventoYRecursos> getAllEventoYRecursos() {
        return eventoYRecursosRepository.findAll();
    }

    public Optional<EventoYRecursos> getEventoYRecursosById(String id) {
        return eventoYRecursosRepository.findById(id);
    }

    public EventoYRecursos createEventoYRecursos(EventoYRecursos eventoYRecursos) {
        return eventoYRecursosRepository.save(eventoYRecursos);
    }

    public EventoYRecursos updateEventoYRecursos(String id, EventoYRecursos eventoYRecursos) {
        Optional<EventoYRecursos> existingEventoYRecursos = eventoYRecursosRepository.findById(id);
        if (existingEventoYRecursos.isPresent()) {
            eventoYRecursos.setId(id);
            return eventoYRecursosRepository.save(eventoYRecursos);
        }
        return null;
    }

    public void deleteEventoYRecursos(String id) {
        eventoYRecursosRepository.deleteById(id);
    }
}
