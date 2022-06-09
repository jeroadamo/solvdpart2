package com.solvd.entities;

public class Instrument {
    private int idInstruments;
    private String kind;
    public Instrument(int idInstruments, String kind) {
        this.idInstruments = idInstruments;
        this.kind = kind;
    }
    public int getIdInstruments() {
        return idInstruments;
    }
    public void setIdInstruments(int idInstruments) {
        this.idInstruments = idInstruments;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    @Override
    public String toString() {
        return "Instrument{" + "idInstruments=" + idInstruments + ", kind='" + kind + '\'' + '}';
    }
}
