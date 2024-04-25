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
    private String Category;
    private String Description;
    private String MuscleGroup;
    private String Difficulty;

    public Exercise(int ExerciseID, String Title, String Category, String Description, String MuscleGroup, String Difficulty) {
        this.ExerciseID = ExerciseID;
        this.Title = Title;
        this.Category = Category;
        this.Description = Description;
        this.MuscleGroup = MuscleGroup;
        this.Difficulty = Difficulty;
    }

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

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getMuscleGroup() {
        return MuscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.MuscleGroup = muscleGroup;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.Difficulty = difficulty;
    }
}
