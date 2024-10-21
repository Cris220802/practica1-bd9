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

import com.practica.eventos.model.Sede;
import com.practica.eventos.service.SedeService;

@RestController
@RequestMapping("/api/v1/sedes")
public class SedeController {
@Autowired
    private SedeService sedeService;

    @GetMapping
    public List<Sede> getAllSedes() {
        return sedeService.getAllSedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> getSedeById(@PathVariable String id) {
        Optional<Sede> sede = sedeService.getSedeById(id);
        return sede.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sede createSede(@RequestBody Sede sede) {
        return sedeService.createSede(sede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> updateSede(@PathVariable String id, @RequestBody Sede sede) {
        Sede updatedSede = sedeService.updateSede(id, sede);
        if (updatedSede != null) {
            return ResponseEntity.ok(updatedSede);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable String id) {
        sedeService.deleteSede(id);
        return ResponseEntity.noContent().build();
    }
}
