package com.solvd.entities;
public class Ticket {
    private int idTickets;
    private String nameSurname;
    private String email;
    private int nationalId;
    public Ticket(int idTickets, String nameSurname, String email, int nationalId) {
        this.idTickets = idTickets;
        this.nameSurname = nameSurname;
        this.email = email;
        this.nationalId = nationalId;
    }
    public int getIdTickets() {
        return idTickets;
    }
    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }
    public String getNameSurname() {
        return nameSurname;
    }
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
    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }
    @Override
    public String toString() {
        return "Ticket{" + "idTickets=" + idTickets + ", nameSurname='" + nameSurname + '\'' + ", email='" + email + '\'' + ", nationalId=" + nationalId + '}';
    }
}
