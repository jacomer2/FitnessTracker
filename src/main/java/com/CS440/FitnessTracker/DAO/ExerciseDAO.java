package com.CS440.FitnessTracker.DAO;

import java.util.List;
import java.util.Map;

import com.CS440.FitnessTracker.Model.Exercise;

public interface ExerciseDAO {

    List<Exercise> getExerciseByFilter(Map<String, String> filters);

    //search bar 
     List<Exercise> getExerciseBySearch();
}
