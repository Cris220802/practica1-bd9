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

import com.practica.eventos.model.Oficio;
import com.practica.eventos.service.OficioService;

@RestController
@RequestMapping("/api/v1/oficios")
public class OficioController {
    @Autowired
    private OficioService oficioService;

    @GetMapping
    public List<Oficio> getAllOficios() {
        return oficioService.getAllOficios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficio> getOficioById(@PathVariable String id) {
        Optional<Oficio> oficio = oficioService.getOficioById(id);
        return oficio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Oficio createOficio(@RequestBody Oficio oficio) {
        return oficioService.createOficio(oficio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oficio> updateOficio(@PathVariable String id, @RequestBody Oficio oficio) {
        Oficio updatedOficio = oficioService.updateOficio(id, oficio);
        if (updatedOficio != null) {
            return ResponseEntity.ok(updatedOficio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOficio(@PathVariable String id) {
        oficioService.deleteOficio(id);
        return ResponseEntity.noContent().build();
    }
}
