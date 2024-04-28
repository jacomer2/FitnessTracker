package com.CS440.FitnessTracker.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.Model.Routine;
import com.CS440.FitnessTracker.DAO.*;


@SpringBootTest
public class routineDAOImplTest {
    


    // @Autowired
    // private ClassDAOimpl classDAO;

    //create model class 
    Routine model = new Routine();     
    
    //create date varible to input into class

    /*
     * set model attributes
     */
    public void setModelAttributes(Routine model){
        
        model.setRoutineID(123);
        model.setStartTime(null);
        model.setEndTime(null);
    }


    @Test
    public void testInsert() throws SQLException {

        setModelAttributes(model);
        RoutineDAOImpl dao = new RoutineDAOImpl();

    
// .create returns 0 if successful
        assertEquals(0, dao.create(model));
    }
    
    @Test
    public void testRead() throws SQLException {
        RoutineDAOImpl dao = new RoutineDAOImpl();
        Routine retModel = dao.read(123);
        assertNotNull(retModel);
        assertEquals(123, retModel.getRoutineID());
    }

    @Test
    public void testUpdate() throws SQLException {
        Date date = new Date(0L);
        RoutineDAOImpl dao = new RoutineDAOImpl();
        setModelAttributes(model);
        Time updatedTime = new Time(date.getTime());
        model.setStartTime(updatedTime);   
        assertEquals(0, dao.update(model));
        assertEquals(updatedTime,dao.read(123).getStartTime());
    }

    @Test
    public void testDelete() throws SQLException {
        RoutineDAOImpl dao = new RoutineDAOImpl();
        assertEquals(0, dao.delete(123));
        
    }

}