package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.Model.Class.Classification;

public class ClassDao implements BasicDAOInterface<com.CS440.FitnessTracker.Model.Class>{

    private DataSource dataSource;

    private com.CS440.FitnessTracker.Model.Class tempClass;
    
    /*
     * Creates a Class in the mySql database
     * returns 0 on success
     * returns 1 on failure
     */
    @Override
    public int create(com.CS440.FitnessTracker.Model.Class modelClass) throws SQLException {
        // Store extracted attributes from user into variables
        int ClassID = modelClass.getClassID();
        float Price = modelClass.getPrice();
        String Classification = modelClass.getClassification().toString();
        float Duration = modelClass.getDuration();
        String Date = modelClass.getDate().toString();
        int UserID = modelClass.getUserID();

        try {

            Connection connection = dataSource.getConnection();

            String insertQuery = "INSERT INTO class (classID,Price,Duration,UserID,Classification,Date) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, ClassID);
            prepStatement.setFloat(2, Price);
            prepStatement.setString(3, Classification);
            prepStatement.setFloat(4, Duration);
            prepStatement.setString(5, Date);       //might need adjusted, date is a DATETIME in sql
            prepStatement.setInt(6, UserID);

            prepStatement.executeUpdate();

            connection.close();

            return 0; //success
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        
        return 0; //fail
       
    }

    /*NEED READ CLASS BY:
         ClassID;
            Price;
                Classification;
                    Duration;
                        Date;
                            UserID; */
    /*
     * Reads a Class from the mySql database
     * returns class instance on success
     * returns NULL on failure
     */
    @Override
    public Class read(com.CS440.FitnessTracker.Model.Class retrieveClass) throws SQLException {
        //init class object to return
        Class modelClass = new Class();

        try {

            Connection connection = dataSource.getConnection();

            String getQuery = "SELECT * FROM user WHERE ClassID = ?";
            
            PreparedStatement prepStatement = connection.prepareStatement(getQuery);
            prepStatement.setInt(1, modelClass.getClassID());
           

            //execute
            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            if (resultTable.next()) {

                modelClass.setClassID(resultTable.getInt(1));
                modelClass.setPrice(resultTable.getFloat(2));
                modelClass.setDuration(resultTable.getFloat(3));
                modelClass.setUserID(resultTable.getInt(4));

                String enumString = resultTable.getString(5);
                modelClass.setClassification(Classification.valueOf(enumString));

                modelClass.setDate(resultTable.getTimestamp(6));    //need to find correct conversions
         

                return modelClass;
            }

            connection.close();

            return 0; //success
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        



        return returnClass;
    }

    @Override
    public List<Class> readAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public int update(Class t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Class t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



    
}
