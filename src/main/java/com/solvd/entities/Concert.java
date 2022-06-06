package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "Concert")
public class Concert {
    private int idConcerts;
    private String timePlay;
    private String duration;
    private String date;
    private Area area;
    private int idTickets;
    public Concert(int idConcerts, String time_play, String duration, String date, Area area, int idTickets) {
        this.idConcerts = idConcerts;
        this.timePlay = time_play;
        this.duration = duration;
        this.date = date;
        this.area = area;
        this.idTickets = idTickets;
    }
    public Concert() {
    }
    public int getIdConcerts() {
        return idConcerts;
    }
    @XmlAttribute(name = "idConcerts")
    public void setIdConcerts(int idConcerts) {
        this.idConcerts = idConcerts;
    }
    public int getIdTickets() {
        return idTickets;
    }
    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
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
        return "Concert{" + "idConcerts=" + idConcerts + ", time_Play='" + timePlay + '\n' + "duration='" + duration + '\'' + ", date='" + date + '\'' + "area=" + area + ", idTickets=" + idTickets + '\n';
    }
}
