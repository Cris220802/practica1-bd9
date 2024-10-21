package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.TipoDeEventos;

@Repository
public interface TipoDeEventosRepository extends MongoRepository<TipoDeEventos, String>{

}
