package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.Evento;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String>{

}
