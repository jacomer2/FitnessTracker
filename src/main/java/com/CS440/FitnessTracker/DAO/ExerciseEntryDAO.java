package com.CS440.FitnessTracker.DAO;

import java.util.List;

import com.CS440.FitnessTracker.Model.Entry;

public interface ExerciseEntryDAO {
    
    List<Entry> getEntriesByUserID(int userID);

}
