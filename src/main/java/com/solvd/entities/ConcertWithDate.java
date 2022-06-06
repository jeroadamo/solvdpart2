package com.solvd.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ConcertWithDate {
    private int idConcerts;
    private String timePlay;
    private String duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
    private Area area;
    private int idTickets;
    public ConcertWithDate(int idConcerts, String timePlay, String duration, Date date, Area area, int idTickets) {
        this.idConcerts = idConcerts;
        this.timePlay = timePlay;
        this.duration = duration;
        this.date = date;
        this.area = area;
        this.idTickets = idTickets;
    }
    public int getIdConcerts() {
        return idConcerts;
    }
    public void setIdConcerts(int idConcerts) {
        this.idConcerts = idConcerts;
    }
    public String getTimePlay() {
        return timePlay;
    }
    public void setTimePlay(String timePlay) {
        this.timePlay = timePlay;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    public int getIdTickets() {
        return idTickets;
    }
    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }
}
