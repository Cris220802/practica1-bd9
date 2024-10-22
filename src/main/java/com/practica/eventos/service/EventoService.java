package com.practica.eventos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.dto.EventoDTO;
import com.practica.eventos.model.Evento;
import com.practica.eventos.model.Oficio;
import com.practica.eventos.model.Perito;
import com.practica.eventos.model.Sede;
import com.practica.eventos.model.TipoDeEventos;
import com.practica.eventos.repository.EventoRepository;
import com.practica.eventos.repository.OficioRepository;
import com.practica.eventos.repository.PeritoRepository;
import com.practica.eventos.repository.SedeRepository;
import com.practica.eventos.repository.TipoDeEventosRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private TipoDeEventosRepository tipoDeEventosRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private PeritoRepository peritoRepository;

    @Autowired
    private OficioRepository oficioRepository;


    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEventoById(String id) {
        return eventoRepository.findById(id);
    }

    public Evento createEvento(EventoDTO eventoDTO) {
        if (eventoDTO == null) {
            throw new RuntimeException("El objeto oficioDTO no debe ser nulo");
        }
    
        if (eventoDTO.getOficioId() == null) {
            throw new RuntimeException("El ID del tipo de oficio no debe ser nulo");
        }

        if (eventoDTO.getPeritoId() == null) {
            throw new RuntimeException("El ID del tipo de perito no debe ser nulo");
        }

        if (eventoDTO.getSedeId() == null) {
            throw new RuntimeException("El ID del tipo de sede no debe ser nulo");
        }

        if (eventoDTO.getTipoDeEventosId() == null) {
            throw new RuntimeException("El ID del tipo de tipo de evento no debe ser nulo");
        }
        
        // Buscar TipoDeEventos por ID
        TipoDeEventos tipoDeEvento = tipoDeEventosRepository.findById(eventoDTO.getTipoDeEventosId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Buscar oficio por ID
        Oficio oficio = oficioRepository.findById(eventoDTO.getOficioId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Buscar perito por ID
        Perito perito = peritoRepository.findById(eventoDTO.getPeritoId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Buscar Sede por ID
        Sede sede = sedeRepository.findById(eventoDTO.getSedeId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Crear Evento
        Evento evento = new Evento(perito, sede, oficio, tipoDeEvento, eventoDTO.getFechaEvento(), eventoDTO.getStatus());

        // Guardar el Oficio
        return eventoRepository.save(evento);
    }

    public Evento updateEvento(String id, EventoDTO eventoDTO) {
        if (eventoDTO == null) {
            throw new RuntimeException("El objeto oficioDTO no debe ser nulo");
        }
    
        if (eventoDTO.getOficioId() == null) {
            throw new RuntimeException("El ID del tipo de oficio no debe ser nulo");
        }

        if (eventoDTO.getPeritoId() == null) {
            throw new RuntimeException("El ID del tipo de perito no debe ser nulo");
        }

        if (eventoDTO.getSedeId() == null) {
            throw new RuntimeException("El ID del tipo de sede no debe ser nulo");
        }

        if (eventoDTO.getTipoDeEventosId() == null) {
            throw new RuntimeException("El ID del tipo de tipo de evento no debe ser nulo");
        }
        
        // Buscar TipoDeEventos por ID
        TipoDeEventos tipoDeEvento = tipoDeEventosRepository.findById(eventoDTO.getTipoDeEventosId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Buscar oficio por ID
        Oficio oficio = oficioRepository.findById(eventoDTO.getOficioId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Buscar perito por ID
        Perito perito = peritoRepository.findById(eventoDTO.getPeritoId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Buscar Sede por ID
        Sede sede = sedeRepository.findById(eventoDTO.getSedeId()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Obtener Evento
        Evento eventoExistente = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        eventoExistente.setOficio(oficio);
        eventoExistente.setPerito(perito);
        eventoExistente.setSede(sede);
        eventoExistente.setTipoDeEvento(tipoDeEvento);
        eventoExistente.setStatus(eventoDTO.getStatus());
        eventoExistente.setFechaEvento(eventoDTO.getFechaEvento());
        // Guardar el Oficio
        return eventoRepository.save(eventoExistente);
    }

    public void deleteEvento(String id) {
        eventoRepository.deleteById(id);
    }
}
