package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Dancer {

    private int idDancer;
    private Concert concert;
    private String studio;
    public Dancer(int idDancer, Concert concert, String studio) {
        this.idDancer = idDancer;
        this.concert = concert;
        this.studio = studio;
    }
    public Dancer(){}
    public int getIdDancer() {
        return idDancer;
    }
    @XmlAttribute(name = "idDancer")
    public void setIdDancer(int idDancer) {
        this.idDancer = idDancer;
    }
    public String getStudio() {
        return studio;
    }@XmlElement(name = "Studio")
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public Concert getConcert() {
        return concert;
    }
    public void setConcert(Concert concert) {
        this.concert = concert;
    }
    @Override
    public String toString() {
        return "Dancer{" + "idDancer=" + idDancer + ", concert=" + concert + ", studio='" + studio + '\'' + '}';
    }
}