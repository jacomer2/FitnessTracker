package com.CS440.FitnessTracker.Model;
import java.sql.Date;
import java.sql.Time;



public class Entry {
    private int EntryID;
    private int Sets;
    private int Repetitions;
    private float Weight;
    private int Time;
    private int UserID;
    private int ExerciseID;
    private int RoutineID;

    public Entry(int EntryID, int Sets, int Repetitions, float Weight, int Time, int UserID, int ExerciseID, int RoutineID){


        this.EntryID = EntryID;
        this.Sets = Sets;
        this.Repetitions = Repetitions;
        this.Weight = Weight;
        this.Time = Time;
        this.UserID = UserID;
        this.ExerciseID = ExerciseID;
        this.RoutineID = RoutineID;
    }

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


    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        this.Time = time;
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
