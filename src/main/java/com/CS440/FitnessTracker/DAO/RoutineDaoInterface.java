package com.CS440.FitnessTracker.DAO;

import com.CS440.FitnessTracker.Model.Routine;

public interface RoutineDaoInterface {

    int createRoutine(Routine routine);
    Routine readRoutine(int routineID);
    int updateRoutine(Routine routine);
    int deleteRoutine(int routineID);

}
