package com.practica.eventos.dto;

import java.time.LocalDateTime;

public class OficioDto {

    private String noControl;
    private String noOficio;
    private LocalDateTime fechaOficio;
    private String tipoDeEventoId;
    private String sedeId;
    
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
    public String getTipoDeEventoId() {
        return tipoDeEventoId;
    }
    public void setTipoDeEventoId(String tipoDeEventoId) {
        this.tipoDeEventoId = tipoDeEventoId;
    }
    public String getSedeId() {
        return sedeId;
    }
    public void setSedeId(String sedeId) {
        this.sedeId = sedeId;
    }

    
}
