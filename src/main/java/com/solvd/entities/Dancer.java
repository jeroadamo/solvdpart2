package com.solvd.entities;
public class Dancer {
    private int idDancers;
    private Concert concert;
    private String studio;
    public Dancer(int idDancers, Concert concert, String studio) {
        this.idDancers = idDancers;
        this.concert = concert;
        this.studio = studio;
    }
    public int getIdDancers() {
        return idDancers;
    }
    public void setIdDancers(int idDancers) {
        this.idDancers = idDancers;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public Concert getConcert() {
        return concert;
    }
    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}