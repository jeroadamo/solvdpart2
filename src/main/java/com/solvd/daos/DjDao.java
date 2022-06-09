package com.solvd.daos;

import com.solvd.entities.Concert;
import com.solvd.entities.Dj;
import com.solvd.interfaces.IDjDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DjDao implements IDjDao {
    @Override
    public Dj getById(int idDj) throws SQLException {
        String query = "SELECT `DJ's`.`idDJ's`,\n" + "    `DJ's`.`name`,\n" + "    `DJ's`.`idConcerts`\n" + "FROM `jeronimo_adamo`.`DJ's` WHERE `idDJ's` = ?;";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idDj);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return new Dj(resultSet.getInt("idDj's"), resultSet.getString("name"), new Concert(resultSet.getInt("idConcerts"), null, null, null, null, 1));
        } catch (SQLException e) {
            System.out.println(e);
        }
        throw new SQLException();
    }
    @Override
    public void save(Dj dj) throws SQLException {
        String query = "INSERT INTO `DJ's` (idDJ's,idConcerts,name) VALUES (?,?,?)";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, dj.getIdDJ());
            ps.setString(2, dj.getName());
            ps.setInt(3, dj.getConcert().getIdConcert());
            ps.executeUpdate();
            System.out.println("Concert successfully added to DB server");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Dj dj, String[] params) {
    }
    @Override
    public void delete(Dj dj) throws SQLException {
        String query = "DELETE FROM `DJ's` WHERE `idDJ's` = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, dj.getIdDJ());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    @Override
    public List<Dj> selectAll() throws SQLException {
        List<Dj> djs = new ArrayList<>();
        Dj dj;
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `DJ's`");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int idDj = resultSet.getInt("idDJ's");
            String name = resultSet.getString("name");
            Concert concert = new Concert(resultSet.getInt("idConcerts"), null,null,null,null,10);
            dj = new Dj(idDj,name,concert);
            djs.add(dj);
        } return djs;
    }
}
