package com.practica.eventos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sedes")
public class Sede {
    @Id
    private String id;

    private String nombreSede;
    private String sedeCol;
    private String calle;
    private Integer numero;
    private String colonia;
    private String ciudad;
    private String municipio;
    private String entidadFed;
    
    public Sede(String id, String nombreSede, String sedeCol, String calle, Integer numero, String colonia,
            String ciudad, String municipio, String entidadFed) {
        this.id = id;
        this.nombreSede = nombreSede;
        this.sedeCol = sedeCol;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.entidadFed = entidadFed;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombreSede() {
        return nombreSede;
    }
    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }
    public String getSedeCol() {
        return sedeCol;
    }
    public void setSedeCol(String sedeCol) {
        this.sedeCol = sedeCol;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getEntidadFed() {
        return entidadFed;
    }
    public void setEntidadFed(String entidadFed) {
        this.entidadFed = entidadFed;
    }

    
}
