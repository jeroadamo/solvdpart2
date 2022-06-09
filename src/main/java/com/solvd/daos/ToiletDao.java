package com.solvd.daos;

import com.solvd.entities.Area;
import com.solvd.entities.Toilet;
import com.solvd.interfaces.IToiletDao;

import java.sql.*;
import java.util.List;

public class ToiletDao implements IToiletDao {
    @Override
    public Object getById(int id) throws SQLException {
        String query = "select * from Toilets where idToilets = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return new Toilet(resultSet.getInt("idToilets"), new Area(resultSet.getInt("idArea"), null), resultSet.getBoolean("usable"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        throw new SQLException();
    }
    @Override
    public void save(Object o) throws SQLException {
    }
    @Override
    public void update(Object o, String[] params) {
    }
    @Override
    public void delete(Object o) throws SQLException {
    }
    @Override
    public List<Toilet> selectAll() throws SQLException {
        return null;
    }
}
