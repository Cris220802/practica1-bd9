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

import com.practica.eventos.dto.EventoYRecursosDTO;
import com.practica.eventos.model.EventoYRecursos;
import com.practica.eventos.repository.EventoYRecursosRepository;
import com.practica.eventos.service.EventoYRecursosService;
import com.practica.eventos.service.UserService;

@RestController
@RequestMapping("/api/v1/eventos_y_recursos")
public class EventoYRecursosController {

    @Autowired
    private EventoYRecursosService eventoYRecursosService;

    @GetMapping
    public List<EventoYRecursos> getAllUsers() {
        return eventoYRecursosService.getAllEventoYRecursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoYRecursos> getEventoYRecursosById(@PathVariable String id) {
        Optional<EventoYRecursos> user = eventoYRecursosService.getEventoYRecursosById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventoYRecursos createUser(@RequestBody EventoYRecursosDTO eventoYRecursosDTO) {
        return eventoYRecursosService.createEventoYRecursos(eventoYRecursosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoYRecursos> updateEventoYRecursos(@PathVariable String id, @RequestBody EventoYRecursosDTO eventoYRecursosDTO) {
        EventoYRecursos updatedEventoYRecursos = eventoYRecursosService.updateEventoYRecursos(id, eventoYRecursosDTO);
        if (updatedEventoYRecursos != null) {
            return ResponseEntity.ok(updatedEventoYRecursos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventoYRecursos(@PathVariable String id) {
        eventoYRecursosService.deleteEventoYRecursos(id);
        return ResponseEntity.noContent().build();
    }
}
