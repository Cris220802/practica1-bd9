package com.practica.eventos.dto;

import java.time.LocalDateTime;

public class EventoDTO {

    private String peritoId;
    private String sedeId;
    private String oficioId;
    private String tipoDeEventosId;
    private LocalDateTime fechaEvento;
    private String status;

    public String getPeritoId() {
        return peritoId;
    }
    public void setPeritoId(String peritoId) {
        this.peritoId = peritoId;
    }
    public String getSedeId() {
        return sedeId;
    }
    public void setSedeId(String sedeId) {
        this.sedeId = sedeId;
    }
    public String getOficioId() {
        return oficioId;
    }
    public void setOficioId(String oficioId) {
        this.oficioId = oficioId;
    }
    public String getTipoDeEventosId() {
        return tipoDeEventosId;
    }
    public void setTipoDeEventosId(String tipoDeEventosId) {
        this.tipoDeEventosId = tipoDeEventosId;
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
