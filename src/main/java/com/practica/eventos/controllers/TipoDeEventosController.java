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

import com.practica.eventos.model.TipoDeEventos;
import com.practica.eventos.service.TipoDeEventosService;

@RestController
@RequestMapping("/api/v1/tipoDeEventos")
public class TipoDeEventosController {
    @Autowired
    private TipoDeEventosService tipoDeEventosService;

    @GetMapping
    public List<TipoDeEventos> getAllTipoDeEventos() {
        return tipoDeEventosService.getAllTipoDeEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeEventos> getTipoDeEventoById(@PathVariable String id) {
        Optional<TipoDeEventos> tipoDeEvento = tipoDeEventosService.getTipoDeEventoById(id);
        return tipoDeEvento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoDeEventos createTipoDeEvento(@RequestBody TipoDeEventos tipoDeEvento) {
        return tipoDeEventosService.createTipoDeEvento(tipoDeEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeEventos> updateTipoDeEvento(@PathVariable String id,
            @RequestBody TipoDeEventos tipoDeEvento) {
        TipoDeEventos updatedTipoDeEvento = tipoDeEventosService.updateTipoDeEvento(id, tipoDeEvento);
        if (updatedTipoDeEvento != null) {
            return ResponseEntity.ok(updatedTipoDeEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDeEvento(@PathVariable String id) {
        tipoDeEventosService.deleteTipoDeEvento(id);
        return ResponseEntity.noContent().build();
    }
}
