package dev.jhordycg.sample.jee.tdd.ttdsample.dao;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractPersistence {
    @Resource(name = "username")
    String username;
    @Resource(name = "password")
    String password;
    @Resource(name = "database")
    String dbName;
    @Resource(name = "host")
    String host;
    @Resource(name = "port")
    int port;

    abstract Connection connect() throws SQLException;

    abstract void disconnect();
}
