package com.CS440.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.CS440.FitnessTracker.Model.User;

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
        String height;
        String weight;
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
                height = resultTable.getString(2);
                weight = resultTable.getString(2);
                age = resultTable.getInt(2);
                name = resultTable.getString(2);
                userName = resultTable.getString(2);
                userID = resultTable.getInt(2);

               retrievedUser = new User(userID, userName, name, height, weight, age, hashedPassword);
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
        String height = user.getHeight();
        String weight = user.getWeight();
        int age = user.getAge();
        String name = user.getName();
        String userName = user.getUsername();
        int userID = user.getUserID();

        try {

            Connection connection = dataSource.getConnection();

            // return if user is already in the system
            if(getUser(userName) != null) {
                System.out.println("insertUser message: User already in system.");
                return;
            }
            
            String insertQuery = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setString(1, hashedPassword);
            prepStatement.setString(2, height);
            prepStatement.setString(3, weight);
            prepStatement.setInt(4, age);
            prepStatement.setString(5, name);
            prepStatement.setString(6, userName);
            prepStatement.setInt(7, userID);
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

    /**
     * @brief updates user attributes in database
     * @param user that will have attributes updated
     * @param params the list of attributes to update
     */
    @Override
    public void updateUser(User user, String[] params) {

        // Store updated attributes in variables
        String hashedPassword = params[0];
        String height = params[1];
        String weight = params[2];
        int age = Integer.valueOf(params[3]);
        String name = params[4];
        String userName = params[5];
        int userID = Integer.valueOf(params[6]); // TODO: update after auto increment
        try {
            Connection connection = dataSource.getConnection();

            String updateQuery = "UPDATE users SET HashedPassword = ?, Height = ?, Weight = ?, Age = ?, Name = ?, UserName = ?, UserID = ? WHERE UserName = ?";

            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
            prepStatement.setString(1, hashedPassword);
            prepStatement.setString(2, height);
            prepStatement.setString(3, weight);
            prepStatement.setInt(4, age);
            prepStatement.setString(5, name);
            prepStatement.setString(6, userName);
            prepStatement.setInt(7, userID);
            prepStatement.setString(8, user.getUsername());

            prepStatement.executeUpdate();

            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
