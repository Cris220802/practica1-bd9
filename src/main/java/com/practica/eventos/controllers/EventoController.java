package com.practica.eventos.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.eventos.dto.EventoDTO;
import com.practica.eventos.model.Evento;
import com.practica.eventos.service.EventoService;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable String id) {
        Optional<Evento> evento = eventoService.getEventoById(id);
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Evento createPerito(@RequestBody EventoDTO eventoDTO) {
        return eventoService.createEvento(eventoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable String id, @RequestBody EventoDTO eventoDTO) {
        Evento updatedEvento = eventoService.updateEvento(id, eventoDTO);
        if (updatedEvento != null) {
            return ResponseEntity.ok(updatedEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable String id) {
        eventoService.deleteEvento(id);;
        return ResponseEntity.noContent().build();
    }
}
