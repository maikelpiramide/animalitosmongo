package com.cpifppiramide.animalitos.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {

    private static Connection connection;

    private MySQLDBConnection(){
    }

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/animalitos", "root", "root");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return MySQLDBConnection.connection;
    }

}