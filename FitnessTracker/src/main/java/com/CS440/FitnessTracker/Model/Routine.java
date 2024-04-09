package com.CS440.FitnessTracker.Model;

import java.time.LocalDateTime;

public class Routine {
    private int RoutineID;
    private LocalDateTime StartTime;
    private LocalDateTime EndTime;

    public int getRoutineID() {
        return RoutineID;
    }

    public void setRoutineID(int routineID) {
        this.RoutineID = routineID;
    }

    public LocalDateTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalDateTime starTime) {
        this.StartTime = starTime;
    }

    public LocalDateTime getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.EndTime = endTime;
    }

}
