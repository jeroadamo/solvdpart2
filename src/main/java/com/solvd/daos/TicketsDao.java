package com.solvd.daos;

import com.solvd.entities.Ticket;
import com.solvd.interfaces.ITicketsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsDao implements ITicketsDao {
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/jeronimo_adamo", "root", "devintern");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Ticket getById(int id) throws SQLException {
        String query = "select * from Tickets where idTickets = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        return new Ticket(resultSet.getInt("idTickets"), resultSet.getString("name_surname"), resultSet.getString("email"), resultSet.getInt("national_lid"));
    }
    @Override
    public void save(Ticket ticket) throws SQLException {
    }
    @Override
    public void update(Ticket ticket, String[] params) {
    }
    @Override
    public void delete(Ticket ticket) throws SQLException {
    }
    @Override
    public List<Ticket> selectAll() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Tickets");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("idTickets");
            String ns = resultSet.getString("name_surname");
            String email = resultSet.getString("email");
            int nationalId =  resultSet.getInt("national_id");
            ticket = new Ticket(id,ns,email,nationalId);
            tickets.add(ticket);
        }
        return tickets;
    }
}
