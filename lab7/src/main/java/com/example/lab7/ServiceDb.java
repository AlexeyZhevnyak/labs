package com.example.lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServiceDb {
    private final String dbUrl;
    private final String user;
    private final String password;

    private static ServiceDb serviceDb = null;

    private ServiceDb(String dbUrl, String user, String password) {
        this.dbUrl = "jdbc:mysql://127.0.0.1:3306/" + dbUrl + "?serverTimezone=Europe/Minsk";
        this.user = user;
        this.password = password;
    }

    public static void init(String dbUrl, String user, String password) {
        if (serviceDb != null) {
            return;
        }
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            serviceDb = new ServiceDb(dbUrl, user, password);
        } catch (SQLException e) {

        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(serviceDb.dbUrl, serviceDb.user, serviceDb.password);
    }

}