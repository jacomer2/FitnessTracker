package com.CS440.FitnessTracker.DAO;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExerciseEntryDAOImplTest {

   // @Autowired
    //private ExerciseEntryDAO entryDAO;

    ExerciseEntryDAO entryDAO = new ExerciseEntryDAOImpl();

    @Test
    public void testInsert() {
        int exerciseID = 1;
        int sets = 3;
        int reps = 10;
        int weight = 45;

        System.out.println("inside test before setEntry");

        entryDAO.setEntry(exerciseID, sets, reps, weight);

    }

    @Test
    public void testGet() {
        
    }
    
}
