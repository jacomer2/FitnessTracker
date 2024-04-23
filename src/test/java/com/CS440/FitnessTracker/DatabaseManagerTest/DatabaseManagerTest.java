package com.CS440.FitnessTracker.DatabaseManagerTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseManagerTest {      
    
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() {
        System.out.println("\n\n***Test Connection***\n\n");

        assertNotNull(dataSource, "DataSource is null");
    }
}

