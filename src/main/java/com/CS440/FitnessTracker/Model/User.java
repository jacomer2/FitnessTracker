package com.CS440.FitnessTracker.Model;

public class User {
    private int UserID;
    private String Username;
    private String Name;
    private int Height;
    private Float Weight;
    private float BMI;
    private String BMI_Class;
    private int Age;
    private String HashedPassword;
    private int loggedIn;

    public User(int UserID, String Username, String Name, int Height, Float Weight, Float BMI, String BMI_Class, int Age, String HashedPassword) {
        this.UserID = UserID;
        this.Username = Username;
        this.Name = Name;
        this.Height = Height;
        this.Weight = Weight;
        this.BMI = BMI;
        this.BMI_Class = BMI_Class;
        this.Age = Age;
        this.HashedPassword = HashedPassword;
        this.loggedIn = 0;
    }

    public User(String username, String password){
        this.Username = username;
        this.HashedPassword = password;
        this.loggedIn = 0;
    }
    public User(int height, float weight){
        this.Height = height;
        this.Weight = weight;
        this.loggedIn = 0;
    }
    public User() {
        this.loggedIn = 0;
    }
    public void LogInTheUser() {
        this.loggedIn = 1;
    }
    public int isUserLoggedIn(){
        return this.loggedIn;
    }
    public void LogOutTheUser() {
        this.loggedIn = 0;
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

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public Float getWeight() {
        return Weight;
    }

    public void setWeight(Float Weight) {
        this.Weight = Weight;
    }

    public Float getBMI() {
        return BMI;
    }

    public void setBMI(Float BMI) {
        this.BMI = BMI;
    }

    public String getBMI_Class() {
        return BMI_Class;
    }

    public void setBMI_Class(String BMI_Class) {
        this.BMI_Class = BMI_Class;
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
