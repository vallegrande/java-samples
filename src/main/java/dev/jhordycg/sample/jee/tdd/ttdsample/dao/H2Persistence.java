package dev.jhordycg.sample.jee.tdd.ttdsample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Persistence extends AbstractPersistence {

    @Override
    public Connection connect() throws SQLException {
        var jdbcUrl = String.format("jdbc:h2:mem:%s", dbName);
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    @Override
    public void disconnect() {
        // TODO document why this method is empty
    }
}
