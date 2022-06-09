package com.solvd.mybatis;

import com.solvd.entities.Area;
import com.solvd.entities.Band;
import com.solvd.entities.Concert;
import com.solvd.service.ConcertDaoService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisUtil {
    private final static Logger LOGGER = LogManager.getLogger(MyBatisRunner.class);
    Reader reader;
    {
        try {
            reader = Resources.getResourceAsReader("mybatis/config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    public void getMapperBand(Integer id) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        Band band = (Band) session.selectOne("getByIdBand", id);
        LOGGER.info("------BAND------");
        LOGGER.info("BAND ID: " + band.getIdBand());
        LOGGER.info("CONCERT ID: " + band.getIdConcerts());
        LOGGER.info("BAND NAME: " + band.getName());
        LOGGER.info("----------------");
        session.commit();
        session.close();
    }
    public void getSelectAllBand() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        List<Band> band = session.selectList("getAllBand");
        for (Band bnd : band) {
            LOGGER.info("--------SELECT ALL--------");
            LOGGER.info("BAND ID: " + bnd.getIdBand());
            LOGGER.info("CONCERT ID: " + bnd.getIdConcerts());
            LOGGER.info("BAND NAME: " + bnd.getName());
        }
        session.commit();
        session.close();
    }
    public void getMapperConcert(Integer id) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        ConcertForMybatis concert = session.selectOne("getByIdConcert", id);
        LOGGER.info("-----CONCERT--------");
        LOGGER.info("CONCERT ID: " + concert.getIdConcerts());
        LOGGER.info("HOUR OF THE SHOW: " + concert.getTimePlay());
        LOGGER.info("DURATION: " + concert.getDuration());
        LOGGER.info("DATE: " + concert.getDate());
        LOGGER.info("AREA ID: " + concert.getArea());
        LOGGER.info("TICKET ID: " + concert.getIdTickets());
        LOGGER.info("-----CONCERT--------");
        session.commit();
        session.close();
    }
    public void getSelectAllConcerts() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        List<ConcertForMybatis> concert = session.selectList("getAllConcerts");
        for (ConcertForMybatis concertForMybatis : concert) {
            LOGGER.info("-----CONCERT--------");
            LOGGER.info("CONCERT ID: " + concertForMybatis.getIdConcerts());
            LOGGER.info("HOUR OF THE SHOW: " + concertForMybatis.getTimePlay());
            LOGGER.info("DURATION: " + concertForMybatis.getDuration());
            LOGGER.info("DATE: " + concertForMybatis.getDate());
            LOGGER.info("AREA ID: " + concertForMybatis.getArea());
            LOGGER.info("TICKET ID: " + concertForMybatis.getIdTickets());
            LOGGER.info("-----CONCERT--------");
        }
        session.commit();
        session.close();
    }
    public void insertBand(int idBand, int idConcert, String name) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        Band band = new Band(idBand, idConcert, name);
        session.insert("insertBand", band);
        session.commit();
        session.close();
        LOGGER.info("Band successfully added to database.");
    }
    public void deleteBand(Integer id) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("deleteBandById", id);
        session.commit();
        session.close();
        LOGGER.info("Band successfully deleted from database.");
    }
}
