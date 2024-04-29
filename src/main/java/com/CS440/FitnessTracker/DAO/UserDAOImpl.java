package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CS440.FitnessTracker.Model.User;

@Component
public class UserDAOImpl implements UserDAO{

    @Autowired
    private DataSource dataSource;

    /**
     * @brief eetrieves the specified user from the database
     * @param email - email address used to find user in database
     * @return a user returned from database, stored as a User object
     */
    @Override
    public User getUser(String userName) {

        // Variables to store user class attributes
        int userID;
        String name;
        String hashedPassword;
        int height;
        float weight;
        float BMI;
        String BMI_Class;
        int age;

        // User object to later store user retrieved from db
        User retrievedUser = null;

        try {
            Connection connection = dataSource.getConnection();

            String getQuery = "SELECT * FROM user WHERE UserName = ?";

            PreparedStatement prepStatement = connection.prepareStatement(getQuery);
            prepStatement.setString(1, userName);

            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            if (resultTable.next()) {

                hashedPassword = resultTable.getString(1);
                height = resultTable.getInt(2);
                weight = resultTable.getInt(3);
                BMI = resultTable.getFloat(4);
                BMI_Class = resultTable.getString(5);
                age = resultTable.getInt(6);
                name = resultTable.getString(7);
                userName = resultTable.getString(8);
                userID = resultTable.getInt(9);

               retrievedUser = new User(userName, name,(int) height, weight, BMI, BMI_Class, age, hashedPassword);
            }

            connection.close();

            // notify if user wasn't found
            if (retrievedUser == null) {
                System.out.println("getUser message: User not found");
            }

            return retrievedUser;
        }
        catch(Exception e)
        {

            System.out.println(e);
        }

        return null;

    }


    
    
    /**
     * @brief deletes specified user from database
     * @param user to be deleted from database
     * */
    @Override
    public void deleteUser(User user) {
        try {
            Connection connection = dataSource.getConnection();

            String deleteQuery = "DELETE FROM user WHERE Username = ?";
            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setString(1, user.getUsername());

            prepStatement.executeUpdate();

            connection.close();

        }
        catch(Exception e) {
            System.out.println(e);
        }

        return;
    }


    /**
     * @brief inserts user into database
     * @param user to be inserted in database
     */
    @Override
    public void insertUser(User user) {

        // Store extracted attributes from user into variables
        String hashedPassword = user.getHashedPassword();
        int height = user.getHeight();
        if (height == 0) {
            height = 10;
        }
        System.out.println("Height: " + height);
        float weight = user.getWeight();
        if (weight == 0) {
            weight = 1;
        }
        System.out.println("Weight: " + weight);
        float BMI = user.getBMI();
        String BMI_Class = user.getBMI_Class();
        int age = user.getAge();
        String name = user.getName();
        String userName = user.getUsername();
        int userID = user.getUserID();

        try {

            Connection connection = dataSource.getConnection();

            System.out.println("****INSIDE INSERT****");

            // return if user is already in the system
            if(getUser(userName) != null) {
                System.out.println("insertUser message: User already in system.");
                return;
            }
            
            String insertQuery = "INSERT INTO user (HashedPassword, Height, Weight, BMI, BMIClass, Age, Name, Username) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setString(1, hashedPassword);
            System.out.println("insert: after password");
            prepStatement.setInt(2, height);
            System.out.println("insert: after height");
            prepStatement.setFloat(3, weight);
            System.out.println("insert: after weight");
            prepStatement.setFloat(4, BMI);
            prepStatement.setString(5, BMI_Class);
            prepStatement.setInt(6, age);
            prepStatement.setString(7, name);
            prepStatement.setString(8, userName);
            System.out.println("insert: after username");

            prepStatement.executeUpdate();


            System.out.println("insert: after execute update");
            connection.close();

            return;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return;
    }

    /**
     * @brief updates user attributes in database
     * @param user that will have attributes updated
     * @param params the list of attributes to update
     */
    @Override
    public void updateUser(User user, String[] params) {

        // Store updated attributes in variables
        int userID = Integer.valueOf(params[0]); // TODO: update after auto increment
        String userName = params[1];
        String name = params[2];
        int height = Integer.valueOf(params[3]);
        float weight = Float.valueOf(params[4]);
        float BMI = Float.valueOf(params[5]);
        String BMI_Class = params[6];
        int age = Integer.valueOf(params[7]);
        String hashedPassword = params[8];
        try {
            Connection connection = dataSource.getConnection();

            String updateQuery = "UPDATE user SET HashedPassword = ?, Height = ?, Weight = ?, BMI = ?, BMIClass = ?, Age = ?, Name = ?, UserName = ?, UserID = ? WHERE UserName = ?";

            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
            prepStatement.setString(1, hashedPassword);
            prepStatement.setInt(2, height);
            prepStatement.setFloat(3, weight);
            prepStatement.setFloat(4, BMI);
            prepStatement.setString(5, BMI_Class);
            prepStatement.setInt(6, age);
            prepStatement.setString(7, name);
            prepStatement.setString(8, userName);
            prepStatement.setInt(9, userID);
            prepStatement.setString(10, user.getUsername());

            prepStatement.executeUpdate();

            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    


    /**
     * @brief inserts user into database
     * @param user to be inserted in database
     */
    public void insertUserByRegister(String username, String password) {

        Random rand = new Random();
        int userid = rand.nextInt(1000);

        // Store extracted attributes from user into variables
        String hashedPassword = password;
        String userName = username;
        int userID = userid;

        try {

            Connection connection = dataSource.getConnection();

            System.out.println("****INSIDE INSERT****");

            // return if user is already in the system
            if(getUser(userName) != null) {
                System.out.println("insertUser message: User already in system.");
                return;
            }
            
            String insertQuery = "INSERT INTO user VALUES (?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setString(1, hashedPassword);
            prepStatement.setString(2, userName);
            prepStatement.setInt(3, userID);
            prepStatement.executeUpdate();

            connection.close();

            return;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return;
    }
}
