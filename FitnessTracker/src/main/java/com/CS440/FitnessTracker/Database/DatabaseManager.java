package com.CS440.FitnessTracker.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class DatabaseManager {

    public static Connection connection() throws SQLException
    {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        //attempt at connection to db
        String url = "jdbc:mysql://localhost:3306/fitnessapp[440]";
        String username = "root";
        String password = "Skywalker2001!";

    try{
         
        @SuppressWarnings("unused")
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to server");
        return connection;

     }
     catch(SQLException e)
     {
         System.out.println("Error connecting to server");
         e.printStackTrace();
         return null;
     }
 
    }

}


