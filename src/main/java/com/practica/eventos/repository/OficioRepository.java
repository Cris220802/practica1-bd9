package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.Oficio;

@Repository
public interface OficioRepository extends MongoRepository<Oficio, String>{

}
