package com.solvd.entities;

import jakarta.xml.bind.annotation.XmlElement;

public class Ticket {
    private Integer idTickets;
    private String nameSurname;
    private String email;
    private int nationalId;
    public Ticket(Integer idTickets, String nameSurname, String email, int nationalId) {
        this.idTickets = idTickets;
        this.nameSurname = nameSurname;
        this.email = email;
        this.nationalId = nationalId;
    }
    public Ticket() {
    }
    public int getIdTickets() {
        return idTickets;
    }
    @XmlElement(name = "TicketId")
    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }
    public String getNameSurname() {
        return nameSurname;
    }
    @XmlElement(name = "CompleteName")
    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getNationalId() {
        return nationalId;
    }
    @XmlElement(name = "NationalIdentification")
    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }
    @Override
    public String toString() {
        return "Ticket{" + "idTickets=" + idTickets + ", nameSurname='" + nameSurname + '\n' + ", email='" + email + '\'' + ", nationalId=" + nationalId + '}';
    }
}
