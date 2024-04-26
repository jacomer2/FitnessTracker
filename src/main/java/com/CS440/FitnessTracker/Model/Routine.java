package com.CS440.FitnessTracker.Model;

import java.sql.Time;

public class Routine {
    private int RoutineID;
    private Time StartTime;
    private Time EndTime;


    public int getRoutineID() {
        return RoutineID;
    }

    public void setRoutineID(int routineID) {
        this.RoutineID = routineID;
    }

    public Time getStartTime() {
        return StartTime;
    }

    public void setStartTime(Time starTime) {
        this.StartTime = starTime;
    }

    public Time getEndTime() {
        return EndTime;
    }

    public void setEndTime(Time endTime) {
        this.EndTime = endTime;
    }

}
