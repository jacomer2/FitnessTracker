package com.CS440.FitnessTracker.Model;

public class User {
    private int UserID;
    private String Username;
    private String Name;
    private String Height;
    private float Weight;
    private int Age;
    private String HashedPassword;

    public User(int UserID, String Username, String Name, String Height, int Weight, int Age, String HashedPassword) {
        this.UserID = UserID;
        this.Username = Username;
        this.Name = Name;
        this.Height = Height;
        this.Weight = Weight;
        this.Age = Age;
        this.HashedPassword = HashedPassword;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String Height) {
        this.Height = Height;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getHashedPassword() {
        return HashedPassword;
    }

    public void setHashedPassword(String HashedPassword) {
        this.HashedPassword = HashedPassword;
    }
}
