package com.practica.eventos.dto;

import java.math.BigDecimal;

public class EventoYRecursosDTO {

    private String transporte;
    private BigDecimal dineroPeajes;
    private BigDecimal dineroViaticos;
    private String evento;

    public String getTransporte() {
        return transporte;
    }
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
    public BigDecimal getDineroPeajes() {
        return dineroPeajes;
    }
    public void setDineroPeajes(BigDecimal dineroPeajes) {
        this.dineroPeajes = dineroPeajes;
    }
    public BigDecimal getDineroViaticos() {
        return dineroViaticos;
    }
    public void setDineroViaticos(BigDecimal dineroViaticos) {
        this.dineroViaticos = dineroViaticos;
    }
    public String getEvento() {
        return evento;
    }
    public void setEvento(String evento) {
        this.evento = evento;
    }
}
