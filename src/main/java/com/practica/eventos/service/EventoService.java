package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.Evento;
import com.practica.eventos.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEventoById(String id) {
        return eventoRepository.findById(id);
    }

    public Evento createEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento updateEvento(String id, Evento evento) {
        Optional<Evento> existingEvento = eventoRepository.findById(id);
        if (existingEvento.isPresent()) {
            evento.setId(id);
            return eventoRepository.save(evento);
        }
        return null;
    }

    public void deleteEvento(String id) {
        eventoRepository.deleteById(id);
    }
}
