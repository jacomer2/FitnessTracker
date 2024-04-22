package com.CS440.FitnessTracker.DAO;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.Model.Class.Classification;
import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;

public class ClassDao implements ClassDaoInterface{

    private DataSource dataSource;

    
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

        
        return 1; //fail
       
    }


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
            prepStatement.setInt(1, retrieveClass.getClassID());
           

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

                java.sql.Timestamp DateTimeObj = resultTable.getTimestamp(6);
                LocalDateTime Date = DateTimeObj.toLocalDateTime();
                modelClass.setDate(Date);    //need to find correct conversions
         
                connection.close();

                return modelClass;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return null;

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


    /*
     * Reads all Classes from the mySql database with a specific attribute
     * PARAM: attribute_name - attribute to search for (ENTER: "date", "classification", "userID", "classID", "price", "duration")
     * PARAM: value - value to search for - (use int for date)
     * returns list of class instances on success
     */
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByAttribute(String attribute_name, Object value) throws SQLException {
        //init class object to return
        Class modelClass = new Class();
        ArrayList<com.CS440.FitnessTracker.Model.Class> classList = new ArrayList<com.CS440.FitnessTracker.Model.Class>();
        int parameters_are_verified = 0;
        String formattedValue = " ";
        //validate attribute_name
        if(attribute_name != "date"
            && attribute_name != "classification" 
                && attribute_name != "userID" 
                    && attribute_name != "classID" 
                        && attribute_name != "price" 
                            && attribute_name != "duration")
                                {
                                    throw new IllegalArgumentException("Invalid attribute_name: " + attribute_name);
                                }

    //validate value and format for prepared statement:
        if(attribute_name == "date")
        {
            if(value.toString().length() != 8 )
            {
                throw new IllegalArgumentException("Invalid value for date: " + value);
            }
        }
        else if(attribute_name == "classification")
        {
            if(!(value.equals("YOGA") || value.equals("DANCE") || value.equals("CYCLING")))
            {
                throw new IllegalArgumentException("Invalid value for classification: " + value + "\nMust be 'YOGA', 'DANCE', or 'CYCLING'");
            }
        }
        else if(attribute_name == "userID" || attribute_name == "classID" || attribute_name == "duration")
        {
            if(! (value instanceof Integer))
            {
                throw new IllegalArgumentException("Invalid value for userID: " + value);
            }
            formattedValue = value.toString();

        }
        else if(attribute_name == "price")
        {
            if(value instanceof Float)
            {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(java.math.RoundingMode.DOWN); // Set rounding mode to DOWN
                formattedValue = df.format(value);
                System.out.println("FORMATTED NUMBER: " + value + " to: " + formattedNumber); 
            }
            else
            {
                throw new IllegalArgumentException("Invalid value for price: " + value);
            }
        }


        try {

            Connection connection = dataSource.getConnection();

            //special cases: date
            if(attribute_name.equals("date"))
            {
                int parseInt = Integer.parseInt(value.toString());
                int nextDay = parseInt + 1;
                String nextDayString = Integer.toString(nextDay);

                String getQuery = "Select * from test where date >= '?' and date < '?'";
                
                PreparedStatement prepStatement = connection.prepareStatement(getQuery);
                prepStatement.setString(1, value.toString());
                prepStatement.setString(2, nextDayString);
            }
            else
            {
                String getQuery = "Select * from test where ? = '?'";
                
                PreparedStatement prepStatement = connection.prepareStatement(getQuery);
                prepStatement.setString(1, attribute_name);
                prepStatement.setString(2, value.toString());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


        return classList;

    }
        /*
     * Reads all Classes from the mySql database with a specific date
     * PARAM: dateString - date to search for:: format:"YYYYMMDD"
     * returns class instance on success
     * returns NULL on failure
     */
    @Override
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByDate(String dateString) throws SQLException {
        //init class object to return
        Class modelClass = new Class();
        ArrayList<com.CS440.FitnessTracker.Model.Class> classList = new ArrayList<com.CS440.FitnessTracker.Model.Class>();
      
        try {

            Connection connection = dataSource.getConnection();

            int parseInt = Integer.parseInt(dateString);
            int nextDay = parseInt + 1;
            String nextDayString = Integer.toString(nextDay);

            String getQuery = "Select * from test where date >= '?' and date < '?'";
            
            PreparedStatement prepStatement = connection.prepareStatement(getQuery);
            prepStatement.setString(1, dateString);
            prepStatement.setString(2, nextDayString);

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

                java.sql.Timestamp DateTimeObj = resultTable.getTimestamp(6);
                LocalDateTime Date = DateTimeObj.toLocalDateTime();
                modelClass.setDate(Date);    //need to find correct conversions
         

                classList.add(modelClass);
            }
            connection.close();
            return classList;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return null;

    }


    @Override
    public ArrayList<java.lang.Class> readByClassification(String classification) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByClassification'");
    }


    @Override
    public ArrayList<java.lang.Class> readByUserID(int userID) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByUserID'");
    }


    @Override
    public ArrayList<java.lang.Class> readByClassID(int classID) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByClassID'");
    }


    @Override
    public ArrayList<java.lang.Class> readByPrice(float price) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByPrice'");
    }


    @Override
    public ArrayList<java.lang.Class> readByDuration(float duration) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByDuration'");
    }



    
}
