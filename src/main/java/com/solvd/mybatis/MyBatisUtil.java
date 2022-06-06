package com.solvd.mybatis;

import com.solvd.entities.Band;
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
    public void getMapperBand() {
        int i = 1;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis/config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        Band band = (Band) session.selectOne("getByIdBand", 1);
        LOGGER.info("------BAND------");
        LOGGER.info("BAND ID: " + band.getIdBand());
        LOGGER.info("CONCERT ID: " + band.getIdConcerts());
        LOGGER.info("BAND NAME: " + band.getName());
        LOGGER.info("----------------");
        session.commit();
        session.close();
    }
    public void getSelectAll() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
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
}
