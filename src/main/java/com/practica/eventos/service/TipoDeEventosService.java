package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.model.TipoDeEventos;
import com.practica.eventos.repository.TipoDeEventosRepository;

@Service
public class TipoDeEventosService {
    @Autowired
    private TipoDeEventosRepository tipoDeEventosRepository;

    public List<TipoDeEventos> getAllTipoDeEventos() {
        return tipoDeEventosRepository.findAll();
    }

    public Optional<TipoDeEventos> getTipoDeEventoById(String id) {
        return tipoDeEventosRepository.findById(id);
    }

    public TipoDeEventos createTipoDeEvento(TipoDeEventos tipoDeEvento) {
        return tipoDeEventosRepository.save(tipoDeEvento);
    }

    public TipoDeEventos updateTipoDeEvento(String id, TipoDeEventos tipoDeEvento) {
        Optional<TipoDeEventos> existingTipoDeEvento = tipoDeEventosRepository.findById(id);
        if (existingTipoDeEvento.isPresent()) {
            tipoDeEvento.setId(id);
            return tipoDeEventosRepository.save(tipoDeEvento);
        }
        return null;
    }

    public void deleteTipoDeEvento(String id) {
        tipoDeEventosRepository.deleteById(id);
    }
}
