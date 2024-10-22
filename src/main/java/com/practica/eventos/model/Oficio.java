package com.practica.eventos.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "oficios")
public class Oficio {
    @Id
    private String id;

    private String noControl;
    private String noOficio;
    private LocalDateTime fechaOficio;

    @DBRef
    private TipoDeEventos tipoDeEvento;

    @DBRef
    private Sede sede;

    public Oficio(String id, String noControl, String noOficio, LocalDateTime fechaOficio, TipoDeEventos tipoDeEvento,
            Sede sede) {
        this.id = id;
        this.noControl = noControl;
        this.noOficio = noOficio;
        this.fechaOficio = fechaOficio;
        this.tipoDeEvento = tipoDeEvento;
        this.sede = sede;
    }

    public Oficio() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    public String getNoOficio() {
        return noOficio;
    }

    public void setNoOficio(String noOficio) {
        this.noOficio = noOficio;
    }

    public LocalDateTime getFechaOficio() {
        return fechaOficio;
    }

    public void setFechaOficio(LocalDateTime fechaOficio) {
        this.fechaOficio = fechaOficio;
    }

    public TipoDeEventos getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(TipoDeEventos tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

}
