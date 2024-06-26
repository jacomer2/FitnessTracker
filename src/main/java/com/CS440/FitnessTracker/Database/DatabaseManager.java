package com.CS440.FitnessTracker.Database;


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

/* 
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
    */

}


