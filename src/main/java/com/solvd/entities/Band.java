package com.solvd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Band {
    @JsonProperty
    private int idBand;
    @JsonProperty
    private Concert concert;
    @JsonProperty
    private String name;
    public Band(int idBand, Concert concert, String name) {
        this.idBand = idBand;
        this.concert = concert;
        this.name = name;
    }
    public Band(){}
    public int getIdBand() {
        return idBand;
    }
    public void setIdBand(int idBand) {
        this.idBand = idBand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Concert getConcert() {
        return concert;
    }
    public void setConcert(Concert concert) {
        this.concert = concert;
    }
    @Override
    public String toString() {
        return "Band{" + "idBand=" + idBand + ", concert=" + concert + ", name='" + name + '\'' + '}';
    }
}