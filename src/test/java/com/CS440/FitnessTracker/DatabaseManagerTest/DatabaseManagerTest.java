package com.CS440.FitnessTracker.DatabaseManagerTest;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Database.DatabaseManager;

@SpringBootTest
public class DatabaseManagerTest {      
    
    DatabaseManager dbms = new DatabaseManager();

    @Test
    public void databaseTest() throws SQLException
    {
        assertNotNull(dbms.connect());

    }
}

