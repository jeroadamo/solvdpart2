package com.solvd;

import com.solvd.daos.ConcertDao;
import com.solvd.daos.DjDao;
import com.solvd.service.ConcertDaoService;
import com.solvd.service.DjDaoService;
import com.solvd.service.ToiletDaoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.sql.SQLException;

public class DaoRunner {
    private final static Logger LOGGER = LogManager.getLogger(DaoRunner.class);
    public static void main(String[] args) throws SQLException {
        ConcertDaoService concertDaoService = new ConcertDaoService();

//        LOGGER.info(concertDaoService.getByConcertId(4));
//        //---------------------------------------------------------------
//        DjDaoService djDaoService = new DjDaoService();
//        LOGGER.info(djDaoService.getByDjId(3));
//        //--------------------------------------------------------------
//        ToiletDaoService toiletDaoService = new ToiletDaoService();
//        LOGGER.info(toiletDaoService.getByToiletId(1));
//        //-------------------------------------------------------------
//        ConcertDao concertDao = new ConcertDao();
//        LOGGER.info(concertDao.selectAll());


    }
}
