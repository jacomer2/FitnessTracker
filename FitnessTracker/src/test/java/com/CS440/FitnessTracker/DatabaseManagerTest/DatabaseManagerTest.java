package com.CS440.FitnessTracker.DatabaseManagerTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

import java.sql.SQLException;
import org.junit.platform.commons.annotation.Testable;

import com.CS440.FitnessTracker.Database.DatabaseManager;

public class DatabaseManagerTest {      
    
    DatabaseManager dbms = new DatabaseManager();

    @org.junit.jupiter.api.Test
    public void databaseTest() throws SQLException
    {
        assertNotNull(dbms.connection());

    }
}

