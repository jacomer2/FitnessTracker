package com.CS440.FitnessTracker.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.DAO.ClassDao;


@SpringBootTest
public class ClassDAOImplTest {

    @Autowired
    private ClassDao classDao;

    public static Class testClass = new Class(123, (float)20.00, "CYCLING", (float)1.0, 20240422, 1200, 123);

    @Test
    public void testCreateClass() throws SQLException {

        // .create returns 0 on success, 1 on fail
        assertEquals((long)0,(long)classDao.create(testClass));

    }

    @Test
    public void testGetClass() {

        String classID = "123";
        Class retClass = null;
        try {
            retClass = classDao.read(testClass);
            assertNotNull(retClass);
            assertEquals(classID, retClass.getClassID());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Returned user attributes from db: ");
        System.out.printf("%d %f %s %f %d %d %d", retClass.getClassID(), retClass.getPrice(), retClass.getClassification(), retClass.getDuration(), retClass.getDate(), retClass.getTime(), retClass.getUserID());

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
