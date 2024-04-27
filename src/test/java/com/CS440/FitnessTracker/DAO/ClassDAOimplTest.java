package com.CS440.FitnessTracker.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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

    //create model class 
    Class model = new Class();     
    
    //create date varible to input into class
    java.sql.Date now = new java.sql.Date(0);

    /*
     * set model attributes
     */
    public void setModelAttributes(Class model){
        
        model.setClassID(123);
        model.setPrice(10);
        model.setClassification("YOGA");
        model.setDuration(60);
        model.setUserID(1);
        model.setDate(now);
        model.setTime(0000);
    }


    @Test
    public void testInsert() throws SQLException {

        setModelAttributes(model);
        ClassDAOimpl classDAO = new ClassDAOimpl();

    
// .insert returns 0 if successful
        assertEquals(0, classDAO.insert(model));
    }


    @Test
    public void testRead() throws SQLException {

        setModelAttributes(model);

        ClassDAOimpl classDAO = new ClassDAOimpl();

        //call read
        Class retrievedClass = classDAO.read(model);
        
        assertNotNull(retrievedClass);
        //check if the class retrieved is the same as the class inserted
        assertEquals(retrievedClass.getClassID(), retrievedClass.getClassID());
        assertEquals(retrievedClass.getClassification(), retrievedClass.getClassification());
        assertEquals(retrievedClass.getDate(), retrievedClass.getDate());
        assertEquals(retrievedClass.getUserID(), retrievedClass.getUserID());
    }

    @Test
    public void testReadAll() throws SQLException {

        ClassDAOimpl classDAO = new ClassDAOimpl();

        //call readAll
        List<Class> retrievedClasses = classDAO.readAll();
        
        assertNotNull(retrievedClasses);
        //check if the class retrieved is the same as the class inserted

    }

    @Test
    public void testUpdate() throws SQLException {

        setModelAttributes(model);
        model.setClassification("CYCLING");
        int classChanged = model.getClassID();

        ClassDAOimpl classDAO = new ClassDAOimpl();

        //call update
        assertEquals(0, classDAO.update(model));
        assertEquals("CYCLING", classDAO.read(model).getClassification());
    }

    @Test
    public void testDelete() throws SQLException {

        ClassDAOimpl classDAO = new ClassDAOimpl();

        //call delete
        assertEquals(0, classDAO.delete(0,1));
    }
}