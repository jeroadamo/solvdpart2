package com.solvd.daos;

import com.solvd.entities.Area;
import com.solvd.entities.Concert;
import com.solvd.interfaces.IConcertDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcertDao implements IConcertDao {
    @Override
    public Concert getById(int idConcerts) throws SQLException {
        String query = "select * from Concerts where idConcerts = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idConcerts);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return new Concert(resultSet.getInt("idConcerts"), resultSet.getString("time_play"), resultSet.getString("duration"), resultSet.getString("date"), new Area(resultSet.getInt("idArea"), null), resultSet.getInt("idTickets"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        throw new SQLException();
    }
    @Override
    public void save(Concert concert) throws SQLException {
        String query = "INSERT INTO Concerts (idConcerts,time_play,date,duration,idArea,idTickets) VALUES (?,?,?,?,?,?)";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, concert.getIdConcert());
            ps.setString(2, concert.getTimePlay());
            ps.setString(3, concert.getDate());
            ps.setString(4, concert.getDuration());
            ps.setObject(5, concert.getArea());
            ps.setInt(6, concert.getIdTicket());
            ps.executeUpdate();
            System.out.println("Concert successfully added to DB server");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public void update(Concert concert, String[] params) {
    }
    @Override
    public void delete(Concert concert) throws SQLException {
        String query = "DELETE FROM Concerts WHERE idConcerts = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, concert.getIdConcert());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    @Override
    public List<Concert> selectAll() throws SQLException {
        List<Concert> concerts = new ArrayList<>();
        Concert concert;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Concerts");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idConcerts = resultSet.getInt("idConcerts");
                String time_play = resultSet.getString("time_play");
                String date = resultSet.getString("date");
                String duration = resultSet.getString("duration");
                Area area = new Area(resultSet.getInt("idArea"), null);
                int idTickets = resultSet.getInt("idTickets");
                concert = new Concert(idConcerts, time_play, duration, date, area, idTickets);
                concerts.add(concert);
            }
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
        return concerts;
    }
}
