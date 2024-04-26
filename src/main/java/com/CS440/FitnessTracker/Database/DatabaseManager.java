package com.CS440.FitnessTracker.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseManager {
    @Bean
    public DataSource connect() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cs440");
        dataSource.setUsername("guest_user");
        dataSource.setPassword("guest_password");

        return dataSource;
    }

    public static Connection connection() throws SQLException
    {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cs440");             //db to connect to
        dataSource.setUsername("guest_user");                            //set credentials         
        dataSource.setPassword("Guest_password!1");            

    try{
         
        @SuppressWarnings("unused")
        Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
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


