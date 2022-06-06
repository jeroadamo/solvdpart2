package com.solvd.patterns;

import com.solvd.daos.*;
import com.solvd.entities.*;
import com.solvd.interfaces.IBaseDao;
import com.solvd.interfaces.IConcertDao;
import com.solvd.service.ConcertDaoService;
import com.solvd.service.DjDaoService;
import com.solvd.staxparser.StAXParserRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DaoFactory {
    private final static Logger LOGGER = LogManager.getLogger(DaoFactory.class);
    public IBaseDao<?> getDao(String dao, Integer id) throws SQLException {
        if (dao.equalsIgnoreCase("concert by id")) {
            ConcertDaoService concertDaoService = new ConcertDaoService();
            IBaseDao<Concert> concertIBaseDao = new ConcertDao();
            LOGGER.info(concertDaoService.concertWithArea(concertIBaseDao.getById(id)));
        } else if (dao.equalsIgnoreCase("all concerts")) {
            IBaseDao<Concert> concertIBaseDao = new ConcertDao();
            System.out.println(concertIBaseDao.selectAll());
        } else if (dao.equalsIgnoreCase("area by id")) {
            IBaseDao<Area> areaIBaseDao = new AreaDao();
            LOGGER.info(areaIBaseDao.getById(id));
        } else if (dao.equalsIgnoreCase("all areas")) {
            IBaseDao<Area> areaIBaseDao = new AreaDao();
            LOGGER.info(areaIBaseDao.selectAll());
        } else if (dao.equalsIgnoreCase("dj by id")) {
            DjDaoService djDaoService = new DjDaoService();
            IBaseDao<Dj> djIBaseDao = new DjDao();
            LOGGER.info(djDaoService.setConcertForDj(djIBaseDao.getById(id)));
        } else if (dao.equalsIgnoreCase("toilet by id")) {
            IBaseDao<Toilet> toiletIBaseDao = new ToiletDao();
            LOGGER.info(toiletIBaseDao.getById(id));
        } else if (dao.equalsIgnoreCase("instrument by id")) {
            IBaseDao<Instrument> instrumentIBaseDao = new InstrumentDao();
            LOGGER.info(instrumentIBaseDao.getById(id));
        }
        return null;
    }
}
