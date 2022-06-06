package com.solvd.entities;

public class SoundEngenieer {
    private int idSoundEngenieer;
    private String name;
    private Concert concert;
    public SoundEngenieer(int idSound_engenieer, String name, Concert concert) {
        idSoundEngenieer = idSound_engenieer;
        this.name = name;
        this.concert = concert;
    }
    public int getIdSoundEngenieer() {
        return idSoundEngenieer;
    }
    public void setIdSoundEngenieer(int idSoundEngenieer) {
        this.idSoundEngenieer = idSoundEngenieer;
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
}
