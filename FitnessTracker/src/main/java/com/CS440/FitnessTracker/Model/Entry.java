package com.CS440.FitnessTracker.Model;

import java.time.LocalDateTime;

public class Entry {
    private int EntryID;
    private int Sets;
    private int Repetitions;
    private float Weight;
    private LocalDateTime DateTime;
    private int UserID;
    private int ExerciseID;
    private int RoutineID;

    public int getEntryID() {
        return EntryID;
    }

    public void setEntryID(int entryID) {
        this.EntryID = entryID;
    }

    public int getSets() {
        return Sets;
    }

    public void setSets(int sets) {
        this.Sets = sets;
    }

    public int getRepetitions() {
        return Repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.Repetitions = repetitions;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        this.Weight = weight;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.DateTime = dateTime;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    public int getExerciseID() {
        return ExerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.ExerciseID = exerciseID;
    }

    public int getRoutineID() {
        return RoutineID;
    }

    public void setRoutineID(int routineID) {
        this.RoutineID = routineID;
    }
}
