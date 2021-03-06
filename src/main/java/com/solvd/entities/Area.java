package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlElement;

public class Area {
    private int idArea;
    private String cardinalLocation;
    public Area(int idArea, String cardinalLocation) {
        this.idArea = idArea;
        this.cardinalLocation = cardinalLocation;
    }
    public Area(Object area) {
    }
    public Area(){}
    public int getIdArea() {
        return idArea;
    }
    @XmlElement
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    public String getCardinalLocation() {
        return cardinalLocation;
    }
    @XmlElement(name = "CardinalLocation")
    public void setCardinalLocation(String cardinalLocation) {
        this.cardinalLocation = cardinalLocation;
    }
    @Override
    public String toString() {
        return "Area{" + "idArea=" + idArea + ", cardinalLocation='" + cardinalLocation + '\'' + '}';
    }
}