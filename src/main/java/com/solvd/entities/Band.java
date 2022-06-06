package com.solvd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Band {
    @JsonProperty
    private int idBand;
    @JsonProperty
    private int idConcerts;
    @JsonProperty
    private String name;
    public Band(int idBand, int idConcerts, String name) {
        this.idBand = idBand;
        this.idConcerts = idConcerts;
        this.name = name;
    }
    public Band(){}
    public int getIdBand() {
        return idBand;
    }
    public void setIdBand(int idBand) {
        this.idBand = idBand;
    }
    public int getIdConcerts() {
        return idConcerts;
    }
    public void setIdConcerts(int idConcerts) {
        this.idConcerts = idConcerts;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Band{" + "idBand=" + idBand + ", idConcerts=" + idConcerts + ", name='" + name + '\'' + '}';
    }
}