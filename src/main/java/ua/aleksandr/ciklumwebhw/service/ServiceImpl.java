package ua.aleksandr.ciklumwebhw.service;

import ua.aleksandr.ciklumwebhw.dao.DataBaseManager;

import java.sql.Connection;

public class ServiceImpl implements Service {

    private DataBaseManager manager;

    private String database;
    private String user;
    private String password;

    public ServiceImpl(DataBaseManager manager, String database, String user, String password) {
        this.manager = manager;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean connect() {
        return manager.connect(database, user, password);
    }

    @Override
    public Connection getConnection() {
        return manager.getConnection();
    }

    @Override
    public void insert(String... input) {
        manager.insertData(input);
    }

    @Override
    public void closeConnection() {
        manager.closeConnection();
    }
}
