package ua.aleksandr.ciklumwebhw.service;

import org.springframework.stereotype.Component;
import ua.aleksandr.ciklumwebhw.dao.DataBaseManager;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ServiceImpl implements Service {

    private DataBaseManager manager;

    private Properties properties;

    public ServiceImpl(DataBaseManager manager) {
        this.manager = manager;
        properties = new Properties();
    }

    @Override
    public boolean connect() {
        String database;
        String user;
        String password;
        try (FileReader fileReader = new FileReader("src\\main\\resources\\properties.properties")) {
            properties.load(fileReader);
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException("Can't get property!", e);
        }
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
