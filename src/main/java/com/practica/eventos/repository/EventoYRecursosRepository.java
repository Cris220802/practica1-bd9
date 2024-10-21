package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.EventoYRecursos;

@Repository
public interface EventoYRecursosRepository extends MongoRepository<EventoYRecursos, String>{

}
