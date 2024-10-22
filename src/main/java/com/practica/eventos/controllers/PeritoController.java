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

import com.practica.eventos.dto.PeritoDTO;
import com.practica.eventos.model.Perito;
import com.practica.eventos.service.PeritoService;

@RestController
@RequestMapping("/api/v1/peritos")
public class PeritoController {

    @Autowired
    private PeritoService peritoService;

    @GetMapping
    public List<Perito> getAllPeritos() {
        return peritoService.getAllPeritos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perito> getPeritoById(@PathVariable String id) {
        Optional<Perito> perito = peritoService.getPeritoById(id);
        return perito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Perito createPerito(@RequestBody PeritoDTO peritoDTO) {
        return peritoService.createPerito(peritoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perito> updatePerito(@PathVariable String id, @RequestBody PeritoDTO perito) {
        Perito updatedPerito = peritoService.updatePerito(id, perito);
        if (updatedPerito != null) {
            return ResponseEntity.ok(updatedPerito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerito(@PathVariable String id) {
        peritoService.deletePerito(id);
        return ResponseEntity.noContent().build();
    }
}
