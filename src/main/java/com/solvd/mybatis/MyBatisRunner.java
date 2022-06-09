package com.solvd.mybatis;

import com.solvd.entities.Band;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.IOException;
import java.io.Reader;

public class MyBatisRunner {

    public static void main(String[] args) throws IOException {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
//        myBatisUtil.getMapperBand(2);
//        myBatisUtil.getSelectAllBand();
//        myBatisUtil.getMapperConcert(1);
//        myBatisUtil.getSelectAllConcerts();
//        myBatisUtil.insertBand(10,2,"Charly García");
//        myBatisUtil.deleteBand(10);
    }
}
