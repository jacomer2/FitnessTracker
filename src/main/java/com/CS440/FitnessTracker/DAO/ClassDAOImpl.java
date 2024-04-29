package com.CS440.FitnessTracker.DAO;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.Database.DatabaseManager;

@Component
public class ClassDAOImpl implements ClassDaoInterface{

    @Autowired
    private DataSource dataSource;    
    /*
     * Creates a Class in the mySql database
     * returns 0 on success
     * returns 1 on failure
     */
    @Override
    public int create(Class modelClass) throws SQLException {
        // Store extracted attributes from user into variables
        int ClassID = modelClass.getClassID();
        float Price = modelClass.getPrice();
        String Classification = modelClass.getClassification();
        float Duration = modelClass.getDuration();
        Date Date = modelClass.getDate();
        int Time = modelClass.getTime();
        int UserID = modelClass.getUserID();

        try {

            Connection connection = dataSource.getConnection();

            String insertQuery = "INSERT INTO class (classID,Price,Duration,UserID,Classification,Date,Time) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, ClassID);
            prepStatement.setFloat(2, Price);
            prepStatement.setFloat(4, Duration);
            prepStatement.setInt(6, UserID);
            prepStatement.setString(3, Classification);
            prepStatement.setDate(5, Date);    
            prepStatement.setInt(7, Time);            

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
    public Class read(Class retrieveClass) throws SQLException {
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
                modelClass.setClassification(resultTable.getString(5));
                modelClass.setDate(resultTable.getDate(6));
                modelClass.setTime(resultTable.getInt(7));
         
                connection.close();

                System.out.println("Class found in db: " + modelClass.getClassID());
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
        //init class list obj to return
        List<Class> classList = new ArrayList<Class>();
        try {

            Connection connection = dataSource.getConnection();

            System.out.println("test1");

            String getQuery = "SELECT * FROM class";
            
            PreparedStatement prepStatement = connection.prepareStatement(getQuery);

            System.out.println("test2");

        
            //execute
            ResultSet resultTable = prepStatement.executeQuery();
            System.out.println("test3");


            // store values returned from db into user object
            if (resultTable.next()) {
                Class modelClass = new Class();
                modelClass.setClassID(resultTable.getInt(1));
                modelClass.setPrice(resultTable.getFloat(2));
                modelClass.setDuration(resultTable.getFloat(3));
                modelClass.setClassification(resultTable.getString(4));

                String dateStr = "05-02-2024";
                SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy");      
                long dateLong = obj.parse(dateStr).getTime(); 

                Date date = new Date(dateLong);
                modelClass.setDate(date);    //need to find correct conversions

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

    /*
     * Finds user by classID in param class and updates mysql class according to given param class
     * returns 0 on success
     * returns 1 on failure
     */
    @Override
    public int update(Class modelClass) throws SQLException {
        // find class by userid
        int userID = modelClass.getUserID();
        int classID = modelClass.getClassID();
        float price = modelClass.getPrice();
        float duration = modelClass.getDuration();
        String classification = modelClass.getClassification(); 
        String classificationStr = classification.toString();

        Date date = modelClass.getDate();


        /*
         * validate attributes
         */
        if(price < 0 || duration < 0 || userID < 0 || classID < 0){
            throw new IllegalArgumentException("Invalid attribute value in one of the following attributes: " + price + " " + duration + " " + userID + " " + classID);
        }
        if(classificationStr != "YOGA" && classificationStr != "DANCE" && classificationStr != "CYCLING")
        {
            throw new IllegalArgumentException("Invalid classification: " + classificationStr + "\nMust be 'YOGA', 'DANCE', or 'CYCLING'");
        }
        if(date.toString().length() != 8)
        {
            throw new IllegalArgumentException("Invalid date: " + date + "\nMust be in format 'YYYYMMDD'");
        }

        try {

            Connection connection = dataSource.getConnection();

            String updateQuery = "UPDATE class SET Price = ?, Duration = ?, Classification = ?, Date = ? WHERE UserID = ? AND ClassID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
            prepStatement.setFloat(1, price);
            prepStatement.setFloat(2, duration);
            prepStatement.setString(3, classification.toString());
            prepStatement.setString(4, date.toString());
            prepStatement.setInt(5, userID);
            prepStatement.setInt(6, classID);

            prepStatement.executeUpdate();

            connection.close();

            return 0; //success
        }
        catch(Exception e)
        {
            System.out.println("ERROR UPDATING CLASS IN classDao.update()");
            System.out.println(e);
        }
        
        return 1; //fail
    }

    @Override
    public int delete(Class c) throws SQLException {
        //get user id
        int classID = c.getClassID();
        int userID = c.getUserID();

        try {

            Connection connection = dataSource.getConnection();

            String deleteQuery = "DELETE FROM class WHERE UserID = ? AND ClassID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, userID);
            prepStatement.setInt(2, classID);

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
     * Reads all Classes from the mySql database with a specific attribute
     * PARAM: attribute_name - attribute to search for (ENTER: "date", "classification", "userID", "classID", "price", "duration")
     * PARAM: value - value to search for - (use int for date)
     * returns list of class instances on success
     */
    public ArrayList<Class> readByAttribute(String attribute_name, Object value) throws SQLException {
        //init class object to return
        ArrayList<com.CS440.FitnessTracker.Model.Class> classList = new ArrayList<com.CS440.FitnessTracker.Model.Class>();
        String formattedStr = " ";
        int formattedValue = 0;
        double formattedDouble = 0.0;
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

    //validate value and format value before prepared statement:
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
        else if(attribute_name == "userID" || attribute_name == "classID" )
        {
            if(! (value instanceof Integer))
            {
                throw new IllegalArgumentException("Invalid value type for userID, must be of class Integer. Value received: " + value);
            }
            formattedValue = (Integer)value;

        }
        else if(attribute_name == "price" || attribute_name == "duration")
        {
            if(value instanceof Float)
            {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(java.math.RoundingMode.DOWN); // Set rounding mode to DOWN
                formattedStr = df.format(value);
                formattedDouble = Double.parseDouble(formattedStr);
                System.out.println("FORMATTED NUMBER: " + value + " to: " + formattedDouble); 
            }
            else
            {
                throw new IllegalArgumentException("Invalid value for price: " + value);
            }
        }


        try {
            /*
             * Create sql query based on attribute_name
             */

             Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = null;
            //special cases: date
            if(attribute_name.equals("date"))
            {
                int parseInt = Integer.parseInt(value.toString());
                int nextDay = parseInt + 1;
                String nextDayString = Integer.toString(nextDay);

                String getQuery = "Select * from test where date >= '?' and date < '?'";
                
                prepStatement = connection.prepareStatement(getQuery);
                prepStatement.setString(1, value.toString());
                prepStatement.setString(2, nextDayString);
            }
            else
            {
                String getQuery = "Select * from test where ? = '?'";
                prepStatement = connection.prepareStatement(getQuery);

                prepStatement.setString(1, attribute_name);

                /*
                 * set value type based on attribute_name
                 */
                if(attribute_name == "price" || attribute_name == "duration")
                {
                    prepStatement.setDouble(2, formattedDouble);
                }
                else if(attribute_name == "userID" || attribute_name == "classID")
                {
                    prepStatement.setInt(2, formattedValue);
                }
                else    //case : value object is a classification
                {
                    prepStatement.setString(2, value.toString());
                }
            }

            //execute
            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            while (resultTable.next()) {

                Class modelClass = new Class();

                modelClass.setClassID(resultTable.getInt(1));
                modelClass.setPrice(resultTable.getFloat(2));
                modelClass.setDuration(resultTable.getFloat(3));
                modelClass.setUserID(resultTable.getInt(4));

                String enumString = resultTable.getString(5);
                modelClass.setClassification(enumString);

                String dateStr = "05-02-2024";
                SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy");      
                long dateLong = obj.parse(dateStr).getTime(); 

                Date date = new Date(dateLong);
                modelClass.setDate(date);    //need to find correct conversions
         

                classList.add(modelClass);
            }                
            
            connection.close();
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
                modelClass.setClassification(enumString);

                String dateStr = "05-02-2024";
                SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy");      
                long dateLong = obj.parse(dateStr).getTime(); 

                Date date = new Date(dateLong);
                modelClass.setDate(date);    //need to find correct conversions
         

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
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByClassification(String classification) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByClassification'");
    }


    @Override
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByUserID(int userID) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByUserID'");
    }


    @Override
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByClassID(int classID) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByClassID'");
    }


    @Override
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByPrice(float price) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByPrice'");
    }


    @Override
    public ArrayList<com.CS440.FitnessTracker.Model.Class> readByDuration(float duration) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByDuration'");
    }



    
}
