package ua.aleksandr.ciklumwebhw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCManager implements DataBaseManager {

    private Connection connection;

    @Override
    public boolean connect(String database, String user, String password) {
        try {
            if (connection != null) {
                connection.close();
            }
            connection = DriverManager.getConnection(database, user, password);
        } catch (SQLException e) {
            connection = null;
            throw new RuntimeException("Can't get connection to database '" + database + "', with the user: '" + user + "'", e);
        }
        return connection != null;
    }

    @Override
    public boolean isConnected() {
        return connection != null;
    }

    @Override
    public void insertData(String... input) {
        String query = "insert into web values(";
        for (String s : input) {
            query += "'" + s + "',";
        }
        query  = query.substring(0,query.length()-1) + ");" ;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert: " + e.getMessage());
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        connection = null;
    }

    @Override
    public List<List<String>> getTableData() {
        String query = "select * from web";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            List<List<String>> list = new ArrayList<>();
            ResultSet set = statement.executeQuery(query);
            while(set.next()) {
                List<String> row = new ArrayList<>();
                row.add(set.getString("action"));
                row.add(set.getString("data"));
                list.add(row);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert: " + e.getMessage());
        }
    }
}
