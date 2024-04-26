package com.CS440.FitnessTracker.DAO;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExerciseDAOImplTest {

    @Autowired
    private ExerciseDAO exerciseDAO;

    @Test
    public void testInsert() {
        Map<String, String> mapInsert = new HashMap<>();
        mapInsert.put("Muscle Groups", "back");
        mapInsert.put("Difficulty", "hard");


        exerciseDAO.getExerciseByFilter(mapInsert);
        
    }
    
}
