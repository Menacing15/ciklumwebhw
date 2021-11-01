package ua.aleksandr.ciklumwebhw.dao;

public interface DataBaseManager {
    boolean  connect(String database, String user, String password);
    boolean isConnected();
    void insertData(String... input);
}
