package ua.aleksandr.ciklumwebhw.service;


import java.sql.Connection;

public interface Service {

    boolean connect();

    Connection getConnection();

    void insert(String... input);
}
