package com.CS440.FitnessTracker.Model;

enum Categories {
    BODYWEIGHT,
    RESISTANCE,
    CARDIO,
    STRETCH,
}

enum MuscleGroups {
    CHEST,
    BACK,
    LEGS,
    BICEPS,
    TRICEPS,
    CORE,
    SHOULDERS
}

public class Exercise {
    private int ExerciseID;
    private String Title;
    private Categories Category;
    private String Description;
    private MuscleGroups MuscleGroup;
    private int Difficulty;

    public int getExerciseID() {
        return ExerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.ExerciseID = exerciseID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public Categories getCategory() {
        return Category;
    }

    public void setCategory(Categories category) {
        this.Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public MuscleGroups getMuscleGroup() {
        return MuscleGroup;
    }

    public void setMuscleGroup(MuscleGroups muscleGroup) {
        this.MuscleGroup = muscleGroup;
    }

    public int getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.Difficulty = difficulty;
    }
}
