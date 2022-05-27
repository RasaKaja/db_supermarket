package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// creating a connection to the SQL database
public class DBHandler {
    String connectionUrl = "jdbc:mysql://localhost:3306/shop";
    String user = "root";
    String password = "MySQL55";

    // make connection variable static
    private static Connection connection; // because it is private, we need get method

    public DBHandler(){
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("Connection to the database successful.");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
