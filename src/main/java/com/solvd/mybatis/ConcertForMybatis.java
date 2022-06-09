package com.solvd.mybatis;

public class ConcertForMybatis {
    private int idConcerts;
    private String timePlay;
    private String duration;
    private String date;
    private int idArea;
    private int idTickets;
    public ConcertForMybatis(int idConcerts, String timePlay, String duration, String date, int idArea, int idTickets) {
        this.idConcerts = idConcerts;
        this.timePlay = timePlay;
        this.duration = duration;
        this.date = date;
        this.idArea = idArea;
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getArea() {
        return idArea;
    }
    public void setArea(int idArea) {
        this.idArea = idArea;
    }
    public int getIdTickets() {
        return idTickets;
    }
    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }
    public ConcertForMybatis() {
    }
    @Override
    public String toString() {
        return "ConcertForMybatis{" + "idConcerts=" + idConcerts + ", timePlay='" + timePlay + '\'' + ", duration='" + duration + '\'' + ", date='" + date + '\'' + ", idArea=" + idArea + ", idTickets=" + idTickets + '}';
    }
}
