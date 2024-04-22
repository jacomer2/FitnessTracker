package com.CS440.FitnessTracker.DAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.Model.Class.Classification;


@SpringBootTest
public class ClassDAOImplTest {

    @Autowired
    private ClassDao classDao;

    Class testClass = new Class(123, (float)20.00, Classification.CYCLING, (float)1.0, 1);

    @Test
    public void testCreateClass() throws SQLException {

/* private int ClassID;
    private float Price;
    private Classification Classification;
    private float Duration;
    private LocalDateTime Date;
    private int UserID; */


        System.out.println(testClass.getUserID());
        System.out.println(testClass.getClassification());
        System.out.println(testClass.getClassID());
        System.out.println(testClass.getPrice());
        System.out.println(testClass.getDuration());


        assertNotNull(classDao.create(testClass));

    }

    @Test
    public void testGetClass() {

        String userID = "123";

        Class retClass = classDao.read(testClass);
        assertNotNull(retClass);

        System.out.println("Returned user attributes: ");
        System.out.printf("%d %d %s %f %s %f", retClass.getUserID(), retClass.getClassID(), String.valueOf(retClass.getClassification()), retClass.getDuration(), String.valueOf(retClass.getDate()), retClass.getPrice());

    }

    @Test
    public void testUpdateClass() {
        int classID = 123;

        Class retUser = classDao.getClass();

        String params[] = {"123", "john24", "John", "5\'7", "163", "46", "updatedFakeHash"};

        userDAO.updateUser(retUser, params);
    }

    @Test
    public void testDeleteUser() {

        String userName = "john24";

        User retUser = userDAO.getUser(userName);

        assertNotNull(retUser);

        userDAO.deleteUser(retUser);

        assertNull(userDAO.getUser(userName));
    }


    
}
