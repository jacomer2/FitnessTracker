package com.CS440.FitnessTracker.DatabaseManagerTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Database.DatabaseManager;

@SpringBootTest
public class DatabaseManagerTest {      
    
    @Autowired
    private DataSource dataSource;

    /*
     * test will tell you if you have stored credentials in your dataSource
     */
    @Test
    public void testConnection() {
        System.out.println("\n\n***Test Connection***\n\n");

        assertNotNull(dataSource, "DataSource is null");
        
        // Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword();
            //need to establish connection to know if db is accessible
    }

    
    /*
     * test will tell you if your datasource credentials can access your local mysql db
     */
    @Test
    public void accessDatabaseTest() throws SQLException{      
        
        DatabaseManager dbms = new DatabaseManager();

        
        assertNotNull(dbms.connection());

        
    }
}

