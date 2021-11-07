package ua.aleksandr.ciklumwebhw.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;

public interface DataBaseManager {
    boolean  connect(String database, String user, String password);
    boolean isConnected();
    void insertData(String... input);
    Connection getConnection();
    void closeConnection();
}
