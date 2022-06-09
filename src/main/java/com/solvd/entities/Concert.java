package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "Concert")
public class Concert {
    private int idConcert;
    private String timePlay;
    private String duration;
    private String date;
    private Area area;
    private int idTicket;
    public Concert(int idConcert, String time_play, String duration, String date, Area area, int idTicket) {
        this.idConcert = idConcert;
        this.timePlay = time_play;
        this.duration = duration;
        this.date = date;
        this.area = area;
        this.idTicket = idTicket;
    }
    public Concert() {
    }
    public int getIdConcert() {
        return idConcert;
    }
    @XmlAttribute(name = "idConcerts")
    public void setIdConcert(int idConcert) {
        this.idConcert = idConcert;
    }
    public int getIdTicket() {
        return idTicket;
    }
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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
    @XmlElement(name = "duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getDate() {
        return date;
    }
    @XmlElement(name = "Date")
    public void setDate(String date) {
        this.date = date;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return "Concert{" + "idConcerts=" + idConcert + ", time_Play='" + timePlay + '\n' + "duration='" + duration + '\'' + ", date='" + date + '\'' + "area=" + area + ", idTickets=" + idTicket + '\n';
    }
}
