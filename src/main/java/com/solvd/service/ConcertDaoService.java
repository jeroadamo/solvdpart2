package com.solvd.service;

import com.solvd.daos.AreaDao;
import com.solvd.daos.ConcertDao;
import com.solvd.entities.Area;
import com.solvd.entities.Concert;
import com.solvd.interfaces.IAreaDao;
import com.solvd.interfaces.IConcertDao;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ConcertsList")
public class ConcertDaoService {
    private ArrayList<Concert> concerts;
    IAreaDao areaDao = new AreaDao();
    IConcertDao concertDao = new ConcertDao();
    public ArrayList<Concert> getConcerts() {
        return concerts;
    }
    @XmlElement
    public void setConcerts(ArrayList<Concert> concerts) {
        this.concerts = concerts;
    }
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
        try {
            concert = concertDao.getById(idConcerts);
            concertWithArea(concert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return concert;
    }
    @Override
    public String toString() {
        return "Concerts=" + concerts + '}';
    }
}




