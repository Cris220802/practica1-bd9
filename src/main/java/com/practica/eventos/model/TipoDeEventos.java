package com.practica.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipo_de_eventos")
public class TipoDeEventos {

    @Id
    private String id;

    private String tipoDeEvento;

    public TipoDeEventos(String id, String tipoDeEvento) {
        this.id = id;
        this.tipoDeEvento = tipoDeEvento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(String tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    
}
