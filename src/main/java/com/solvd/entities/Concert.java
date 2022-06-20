package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Concerts")
public class Concert {
    private int idConcert;
    private String timePlay;
    private String duration;
    private String date;
    private Area area;
    private List<Ticket> tickets;
    private ArrayList<Concert> concerts;
    public Concert(int idConcert, String time_play, String duration, String date, Area area, List<Ticket> tickets) {
        this.idConcert = idConcert;
        this.timePlay = time_play;
        this.duration = duration;
        this.date = date;
        this.area = area;
        this.tickets = tickets;
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
    public String getTimePlay() {
        return timePlay;
    }
    @XmlElement(name = "Time")
    public void setTimePlay(String timePlay) {
        this.timePlay = timePlay;
    }
    public String getDuration() {
        return duration;
    }
    @XmlElement(name = "Duration")
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
    @XmlElement(name = "Area")
    public void setArea(Area area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return "Concert{" + "idConcerts=" + idConcert + ", time_Play='" + timePlay + '\n' + "duration='" + duration + '\'' + ", date='" + date + '\'' + "area=" + area + ", TicketsAllowed=" + tickets + '\n';
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    @XmlElement(name = "Tickets")
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    public ArrayList<Concert> getConcerts() {
        return concerts;
    }
    @XmlElement(name = "Concert")
    public void setConcerts(ArrayList<Concert> concerts) {
        this.concerts = concerts;
    }
}
