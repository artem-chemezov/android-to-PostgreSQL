package com.example.host.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.example.host.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
    private JdbcTemplate jdbcTemplate;

    public Queries(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Client getData(int id) {
        Client cl = jdbcTemplate.queryForObject(
                "SELECT * FROM Users where id = ?",
                new Object[]{id},
                new RowMapper<Client>() {
                    @Override
                    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String greeting = resultSet.getString("greeting");
                        Client cl = new Client(id, name, greeting);
                        return cl;
                    }
                }
        );

        return cl;

    }

    public void putData(Client client) {
        jdbcTemplate.update(
                "INSERT INTO Users(id, name, greeting) VALUES(?, ?, ?) " +
                        "ON CONFLICT (id) " +
                        "DO UPDATE " +
                        "SET id = ?, name = ?, greeting = ?;",
                client.getId(), client.getName(), client.getGreeting(), client.getId(), client.getName(), client.getGreeting()
        );
    }
}
