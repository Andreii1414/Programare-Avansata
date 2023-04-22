package org.example.Compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private Singleton singletonInstance = new Singleton();
    private static Connection connection = null;
    public Singleton(){
    }

    public Singleton getSingletonInstance() {
        return singletonInstance;
    }

    public void setSingletonInstance(Singleton singletonInstance) {
        this.singletonInstance = singletonInstance;
    }

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static Connection createConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","student", "student");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection(){
        if(connection != null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
