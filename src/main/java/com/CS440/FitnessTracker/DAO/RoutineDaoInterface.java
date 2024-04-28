package com.CS440.FitnessTracker.DAO;

import com.CS440.FitnessTracker.Model.Routine;

public interface RoutineDaoInterface {

    int create(Routine routine);
    Routine read(int routineID);
    int update(Routine routine);
    int delete(int routineID);

}
