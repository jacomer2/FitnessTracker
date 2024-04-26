package com.CS440.FitnessTracker.DAO;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.DAO.*;

@SpringBootTest
public class ClassDAOimplTest {

    // @Autowired
    // private ClassDAOimpl classDAO;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Test
    public void testInsert() throws SQLException {

        ClassDAOimpl classDAO = new ClassDAOimpl();

        //create model class to insert into db
        Class class1 = new Class();

        //should convert java.util.Date to java.sql.Date here
        java.sql.Date now = new java.sql.Date(0);
        
        

        class1.setClassID(0);
        class1.setPrice(10);
        class1.setClassification("YOGA");
        class1.setDuration(60);
        class1.setUserID(1);
        class1.setDate(now);
        class1.setTime(0000);

    
// .insert returns 0 if successful
        assertEquals(0, classDAO.insert(class1));


        
    }
    
}