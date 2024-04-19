package com.CS440.FitnessTracker.DatabaseManagerTest;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;


import com.CS440.FitnessTracker.Database.DatabaseManager;

public class DatabaseManagerTest {      
    
    DatabaseManager dbms = new DatabaseManager();

    @org.junit.jupiter.api.Test
    public void databaseTest() throws SQLException
    {
        assertNotNull(dbms.connect());

    }
}

