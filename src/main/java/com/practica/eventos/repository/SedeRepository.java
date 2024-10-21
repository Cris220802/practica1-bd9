package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.Sede;

@Repository
public interface SedeRepository extends MongoRepository<Sede, String>{

}
