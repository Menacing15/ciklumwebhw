package ua.aleksandr.ciklumwebhw.service;

import java.sql.Connection;
import java.util.List;

public interface Service {

    boolean connect();

    Connection getConnection();

    void insert(String... input);

    void closeConnection();

    List<List<String>> getTableData();
}
