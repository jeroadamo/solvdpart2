package com.solvd.service;

import com.solvd.daos.DjDao;
import com.solvd.entities.Dj;
import com.solvd.interfaces.IDjDao;

import java.sql.SQLException;

public class DjDaoService {
    ConcertDaoService concertDaoService = new ConcertDaoService();
    IDjDao djDao = new DjDao();
    public Dj setConcertForDj(Dj dj) {
        dj.setConcert(concertDaoService.getByConcertId(dj.getConcert().getIdConcerts()));
        return dj;
    }
    public Dj getByDjId(int idDj) {
        Dj dj = new Dj();
        try {
            dj = djDao.getById(idDj);
            setConcertForDj(dj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dj;
    }
}
