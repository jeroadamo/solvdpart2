package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.List;

@XmlRootElement(name = "Dancer")
public class Dancer {

    private int idDancer;
    private List<Concert> concerts;
    private String studio;
    private List<Dancer> dancers;
    public Dancer(int idDancer, List<Concert> concerts, String studio) {
        this.idDancer = idDancer;
        this.concerts = concerts;
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
    }
    @XmlElement(name = "Studio")
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public List<Concert> getConcerts() {
        return concerts;
    }
    @XmlElement(name = "Concert")
    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
    @Override
    public String toString() {
        return "Dancer{" + "idDancer=" + idDancer + ", concert=" + concerts + ", studio='" + studio + '\'' + "dancers" +dancers;
    }
    public List<Dancer> getDancers() {
        return dancers;
    }
    @XmlTransient
    public void setDancers(List<Dancer> dancers) {
        this.dancers = dancers;
    }

}