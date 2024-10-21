package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.Especialidad;

@Repository
public interface EspecialidadRepository extends MongoRepository<Especialidad, String>{

}
