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

import com.practica.eventos.model.Especialidad;
import com.practica.eventos.service.EspecialidadService;

@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadController {

    @Autowired(required = true)
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> getAllEspecialidades() {
        return especialidadService.getAllEspecialidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable String id) {
        Optional<Especialidad> especialidad = especialidadService.getEspecialidadById(id);
        return especialidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidad createEspecialidad(@RequestBody Especialidad especialidad) {
        return especialidadService.createEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable String id,
            @RequestBody Especialidad especialidad) {
        Especialidad updatedEspecialidad = especialidadService.updateEspecialidad(id, especialidad);
        if (updatedEspecialidad != null) {
            return ResponseEntity.ok(updatedEspecialidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable String id) {
        especialidadService.deleteEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}
