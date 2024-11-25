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
                connection = DriverManager.getConnection("jdbc:mysql://nextlio.cdewku4giwiy.us-east-1.rds.amazonaws.com:3306/animalitos", "admin", "Code0crew$$");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return MySQLDBConnection.connection;
    }

}