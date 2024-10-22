package com.practica.eventos.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "eventos")
public class Evento {
    @Id
    private String id;

    @DBRef
    private Perito perito;

    @DBRef
    private Sede sede;

    @DBRef
    private Oficio oficio;

    @DBRef
    private TipoDeEventos tipoDeEvento;

    private LocalDateTime fechaEvento;
    private String status;

    public Evento( Perito perito, Sede sede, Oficio oficio, TipoDeEventos tipoDeEvento,
            LocalDateTime fechaEvento, String status) {
        this.perito = perito;
        this.sede = sede;
        this.oficio = oficio;
        this.tipoDeEvento = tipoDeEvento;
        this.fechaEvento = fechaEvento;
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Perito getPerito() {
        return perito;
    }
    public void setPerito(Perito perito) {
        this.perito = perito;
    }
    public Sede getSede() {
        return sede;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public Oficio getOficio() {
        return oficio;
    }
    public void setOficio(Oficio oficio) {
        this.oficio = oficio;
    }
    public TipoDeEventos getTipoDeEvento() {
        return tipoDeEvento;
    }
    public void setTipoDeEvento(TipoDeEventos tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }
    public LocalDateTime getFechaEvento() {
        return fechaEvento;
    }
    public void setFechaEvento(LocalDateTime fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}
