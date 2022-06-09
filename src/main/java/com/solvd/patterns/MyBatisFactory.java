package com.solvd.patterns;

import com.solvd.mybatis.MyBatisUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class MyBatisFactory {
    private final static Logger LOGGER = LogManager.getLogger(MyBatisFactory.class);
    MyBatisUtil myBatisUtil = new MyBatisUtil();

    public void getBatis(String batis, Integer id) throws IOException {
        if(batis.equalsIgnoreCase("read band by id")){
            myBatisUtil.getMapperBand(id);
        } else if (batis.equalsIgnoreCase("read all bands"))   {
            myBatisUtil.getSelectAllBand();
        } else if (batis.equalsIgnoreCase("read concert by id")) {
            myBatisUtil.getMapperConcert(id);
        } else if (batis.equalsIgnoreCase("read all concerts")) {
            myBatisUtil.getSelectAllConcerts();
        } else if (batis.equalsIgnoreCase("insert band")) {
            myBatisUtil.insertBand(11,20,"blur");
        } else if (batis.equalsIgnoreCase("delete band")) {
            myBatisUtil.deleteBand(id);
        }
    }
}
