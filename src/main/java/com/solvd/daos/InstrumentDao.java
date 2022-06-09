package com.solvd.daos;

import com.solvd.entities.Area;
import com.solvd.entities.Instrument;
import com.solvd.interfaces.IInstrumentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDao implements IInstrumentDao {
    @Override
    public Instrument getById(int id) throws SQLException {
        String query = "select * from Instruments where idInstruments= ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return new Instrument(resultSet.getInt("idInstruments"), resultSet.getString("kind"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        throw new SQLException();
    }
    @Override
    public void save(Instrument instrument) throws SQLException {
        String query = "INSERT INTO Instruments (idInstruments , kind) VALUES (?,?)";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, instrument.getIdInstruments());
            ps.setString(2, instrument.getKind());
            ps.executeUpdate();
            System.out.println("Instrument successfully added to DB server");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public void update(Instrument instrument, String[] params) {
    }
    @Override
    public void delete(Instrument instrument) throws SQLException {
        String query = "DELETE FROM Instruments WHERE idInstruments = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, instrument.getIdInstruments());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    @Override
    public List<Instrument> selectAll() throws SQLException {
        List<Instrument> instruments = new ArrayList<>();
        Instrument instrument;
        Connection connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Instruments");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idInstruments = resultSet.getInt("idInstruments");
            String kind = resultSet.getString("kind");
            instrument = new Instrument(idInstruments,kind);
            instruments.add(instrument);
        }
        return instruments;
    }
}
