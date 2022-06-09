package com.solvd.patterns;

import com.solvd.entities.Ticket;

public class TicketBuilder {
    private int idTickets;
    private String nameSurname;
    private String email;
    private int nationalId;
    public TicketBuilder(int idTickets, String nameSurname, String email, int nationalId) {
        this.idTickets = idTickets;
        this.nameSurname = nameSurname;
        this.email = email;
        this.nationalId = nationalId;
    }
    public TicketBuilder() {
    }
    public TicketBuilder setIdTickets(int idTickets) {
        this.idTickets = idTickets;
        return this;
    }
    public TicketBuilder setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
        return this;
    }
    public TicketBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    public TicketBuilder setNationalId(int nationalId) {
        this.nationalId = nationalId;
        return this;
    }
    public Ticket build(){
        return new Ticket(idTickets,nameSurname,email,nationalId);
    }
}

