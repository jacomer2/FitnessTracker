package com.CS440.FitnessTracker.DAO;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.CS440.FitnessTracker.Model.Entry;

public interface ExerciseEntryDAO {
    
    List<Entry> getEntriesByUserID(int userID);

    void setEntry(@RequestParam int sets, @RequestParam int reps, @RequestParam int weight);
}
