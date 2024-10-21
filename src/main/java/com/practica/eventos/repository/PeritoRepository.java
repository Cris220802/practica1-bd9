package com.practica.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practica.eventos.model.Perito;

@Repository
public interface PeritoRepository extends MongoRepository<Perito, String>{

}
