package com.CS440.FitnessTracker.DAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CS440.FitnessTracker.Model.User;


@SpringBootTest
public class UserDAOImplTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testInsert() {


        User testUser = new User(123, "john24", "John", "5\'7", "150", 45, "fakeHash");

        System.out.printf("%d\n", testUser.getUserID());

        System.out.println(userDAO);

        userDAO.insertUser(testUser);

    }

    @Test
    public void testGetUser() {

        String userName = "john24";

        User retUser = userDAO.getUser(userName);

        System.out.println("Returned user: " + retUser);
        System.out.printf("%d %s %s %s %s %d %s", retUser.getUserID(), retUser.getUsername(), retUser.getName(), retUser.getHeight(), retUser.getWeight(), retUser.getAge(), retUser.getHashedPassword());
    
        assertNotNull(retUser);
    
    }

    @Test
    public void testUpdateUser() {
        String userName = "john24";

        User retUser = userDAO.getUser(userName);

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