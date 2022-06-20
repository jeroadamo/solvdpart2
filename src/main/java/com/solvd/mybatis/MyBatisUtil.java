package com.solvd.mybatis;

import com.solvd.entities.Band;
import com.solvd.entities.Concert;
import com.solvd.entities.Ticket;
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
        LOGGER.info("CONCERT ID: " + band.getConcert());
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
            LOGGER.info("CONCERT ID: " + bnd.getConcert());
            LOGGER.info("BAND NAME: " + bnd.getName());
        }
        session.commit();
        session.close();
    }
    public void insertTicket(String name, String email, int personId) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        Ticket ticket = new Ticket(null,name, email,personId);
        session.insert("insertTicket", ticket);
        session.commit();
        session.close();
        LOGGER.info("Ticket successfully added to database.");
    }
    public void deleteBand(Integer id) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("deleteBandById", id);
        session.commit();
        session.close();
        LOGGER.info("Band successfully deleted from database.");
    }
}
