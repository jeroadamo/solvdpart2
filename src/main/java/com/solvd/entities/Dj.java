package com.solvd.entities;

public class Dj {
    private int idDJ;
    private String name;
    private Concert concert;
    public Dj(int idDJ, String name, Concert concert) {
        this.idDJ = idDJ;
        this.name = name;
        this.concert = concert;
    }
    public Dj(){}
    public int getIdDJ() {
        return idDJ;
    }
    public void setIdDJ(int idDJ) {
        this.idDJ = idDJ;
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
        return "Dj{" + "idDJ=" + idDJ + ", name='" + name + '\'' + ", concert=" + concert + '}';
    }
}

