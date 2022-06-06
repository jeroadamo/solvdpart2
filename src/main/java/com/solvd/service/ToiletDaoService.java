package com.solvd.service;

import com.solvd.daos.AreaDao;
import com.solvd.daos.ToiletDao;
import com.solvd.entities.Area;
import com.solvd.entities.Toilet;
import com.solvd.interfaces.IAreaDao;
import com.solvd.interfaces.IToiletDao;

import java.sql.SQLException;

public class ToiletDaoService {
    IAreaDao areaDao = new AreaDao();
    IToiletDao toiletDao = new ToiletDao();
    public Toilet toiletWithArea(Toilet toilet) throws SQLException {
        Area area = areaDao.getById(toilet.getArea().getIdArea());
        toilet.setArea(area);
        return toilet;
    }
    public Toilet getByToiletId(int id) throws SQLException {
        Toilet toilet = new Toilet();
        toilet = (Toilet) toiletDao.getById(id);
        toiletWithArea(toilet);
        return toilet;
    }
}
