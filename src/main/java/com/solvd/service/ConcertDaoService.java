package com.solvd.service;

import com.solvd.daos.AreaDao;
import com.solvd.daos.ConcertDao;
import com.solvd.daos.TicketsDao;
import com.solvd.entities.Area;
import com.solvd.entities.Concert;
import com.solvd.entities.Ticket;
import com.solvd.interfaces.IAreaDao;
import com.solvd.interfaces.IConcertDao;
import com.solvd.interfaces.ITicketsDao;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConcertDaoService {
    IAreaDao areaDao = new AreaDao();
    IConcertDao concertDao = new ConcertDao();
    ITicketsDao ticketsDao = new TicketsDao();
    public Concert concertWithArea(Concert concert) {
        try {
            Area area = areaDao.getById(concert.getArea().getIdArea());
            concert.setArea(area);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return concert;
    }
    public Concert getByConcertId(int idConcerts) {
        Concert concert = new Concert();
        List<Ticket> tickets = new ArrayList<Ticket>();
        try {
            concert = concertDao.getById(idConcerts);
            concertWithArea(concert);
            tickets = ticketsDao.selectAll();
            concert.setTickets(tickets);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return concert;
    }


}




