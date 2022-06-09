package com.solvd.patterns;

import com.solvd.entities.Ticket;
import com.solvd.mybatis.MyBatisRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class PatternsRunner {
    private final static Logger LOGGER = LogManager.getLogger(PatternsRunner.class);
    public static void main(String[] args) throws SQLException, IOException {
//      Commands to type for DaoFactory:
//      -entity + by id  (for example: area by id + id number of preference)
//      -select all + entity (set integer to null)

        DaoFactory daoFactory = new DaoFactory();
        daoFactory.getDao("concert by id", 2);

//      Commands: "read band by id","read all bands","read concert by id",
//      "read all concerts", "insert band","delete band".
//      set integer to null if select all.

        MyBatisFactory batisFactory = new MyBatisFactory();
        batisFactory.getBatis("read band by id", 2);
//  -----------------------------------------------------------------------------------------------------------------------
        Ticket ticket = new TicketBuilder().setIdTickets(500).setEmail("bobodenkirk@gmail.com").setNameSurname("Bob Odenkirk").setNationalId(112548976).build();
        LOGGER.info(ticket);

    }
}
