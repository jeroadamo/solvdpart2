package com.solvd.daos;

import com.solvd.entities.Area;
import com.solvd.interfaces.IAreaDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AreaDao implements IAreaDao {
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Area getById(int idArea) throws SQLException {
        String query = "select * from Area where idArea = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idArea);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        return new Area(resultSet.getInt("idArea"), resultSet.getString("cardinal_location"));
    }
    @Override
    public void save(Area area) throws SQLException {
        String query = "INSERT INTO Area (idArea, cardinal_location) VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, area.getIdArea());
        ps.setString(2, area.getCardinalLocation());
        ps.executeUpdate();
    }
    @Override
    public void update(Area area, String[] params) {
    }
    @Override
    public void delete(Area area) throws SQLException {
        String query = "DELETE FROM Area WHERE idArea = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, area.getIdArea());
        ps.executeUpdate();
    }
    @Override
    public List<Area> selectAll() throws SQLException {
        List<Area> areas = new ArrayList<>();
        Area area;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Area");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idArea = resultSet.getInt("idArea");
            String cardinalLocation = resultSet.getString("cardinal_location");
            area = new Area(idArea, cardinalLocation);
            areas.add(area);
        }
        return areas;
    }
}
