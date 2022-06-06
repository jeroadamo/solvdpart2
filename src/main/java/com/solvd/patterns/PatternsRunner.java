package com.solvd.patterns;

import java.sql.SQLException;

public class PatternsRunner {
    public static void main(String[] args) throws SQLException {
//      Commands to type:
//      -entity + by id  (for example: area by id + id number of preference)
//      -select all + entity (set integer to null)

        DaoFactory daoFactory = new DaoFactory();
        daoFactory.getDao("concert by id", 2);
    }
}
