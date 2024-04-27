package com.CS440.FitnessTracker.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.CS440.FitnessTracker.Model.Class;
import com.CS440.FitnessTracker.Database.DatabaseManager;

public class ClassDAOimpl implements ClassDaoInterface{

    @Autowired
    private static DataSource dataSource;    
    /*
     * Creates a Class in the mySql database
     * returns 0 on success
     * returns 1 on failure
     * Finally works, please lmk if you change anything
     */
    @Override
    public int insert(Class modelClass) throws SQLException {
        // Store extracted attributes from user into variables
        int ClassID = modelClass.getClassID();
        float Price = modelClass.getPrice();
        String Classification = modelClass.getClassification();
        float Duration = modelClass.getDuration();
        int UserID = modelClass.getUserID();
        java.sql.Date Date = modelClass.getDate();
        int Time = modelClass.getTime();

        try {

            // Connection connection = dataSource.getConnection();    //alternate datasource connection
            Connection connection = DatabaseManager.connection();



            String insertQuery = "INSERT INTO class (ClassID,Price,Classification,Duration,UserID,ClassDate,ClassTime) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
            prepStatement.setInt(1, ClassID);
            prepStatement.setFloat(2, Price);
            prepStatement.setString(3, Classification);
            prepStatement.setFloat(4, Duration);
            prepStatement.setInt(5, UserID);
            prepStatement.setDate(6, Date);    
            prepStatement.setInt(7, Time);        

            prepStatement.executeUpdate();

            connection.close();

            return 0; //success
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 1; //fail
        }   
       
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
        System.out.println("Searching for class with ID: " + retrieveClass.getClassID() );

        try {

            // Connection connection = dataSource.getConnection();    //alternate datasource connection
            Connection connection = DatabaseManager.connection();

            String getQuery = "SELECT ClassID,Price,Classification,Duration,UserID,ClassDate,ClassTime FROM Class WHERE ClassID = ?";
            
            PreparedStatement prepStatement = connection.prepareStatement(getQuery);
            prepStatement.setInt(1, retrieveClass.getClassID() );
            System.out.println("[In try/catch]Searching for class with ID: " + retrieveClass.getClassID() );

            //execute
            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            while (resultTable.next()) {

                int id = resultTable.getInt(1);
                System.out.println("...\n" + "...\n" + "RECEIVED FROM RESULT TABLE : " + id  + "...\n" + "...\n");

                modelClass.setClassID(id);

                System.out.println("...\n" + "...\n" + "RECEIVED FROM RESULT TABLE : " + id  + "...\n" + "...\n");


                modelClass.setPrice(resultTable.getFloat(2));
                modelClass.setClassification(resultTable.getString(3));
                modelClass.setDuration(resultTable.getFloat(4));
                modelClass.setUserID(resultTable.getInt(5));
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
            System.out.println("ClassID not found in db: " + retrieveClass.getClassID());
            
            return null;
        }

        System.out.println("ClassID not found in db: " + retrieveClass.getClassID());

        return null;

    }


    @Override
    public List<Class> readAll() throws SQLException {
        //init class list obj to return
        List<Class> classList = new ArrayList<Class>();
        
        try {

 //           Connection connection = dataSource.getConnection();      //alternate datasource connection
            Connection connection = DatabaseManager.connection();

            String getQuery = "SELECT * FROM class";
            
            PreparedStatement prepStatement = connection.prepareStatement(getQuery);
        
            //execute
            ResultSet resultTable = prepStatement.executeQuery();

            // store values returned from db into user object
            while (resultTable.next()) {
                Class modelClass = new Class();

                modelClass.setClassID(resultTable.getInt(1));
                modelClass.setPrice(resultTable.getFloat(2));
                modelClass.setClassification(resultTable.getString(3));
                modelClass.setDuration(resultTable.getFloat(4));
                modelClass.setUserID(resultTable.getInt(5));
                modelClass.setDate(resultTable.getDate(6));
                modelClass.setTime(resultTable.getInt(7));

                System.out.println(".\n.\n.\n About to add class to list: " + modelClass.getClassID() + "\n.\n.\n.");
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
        Date date = modelClass.getDate();
        int time = modelClass.getTime();


        /*
         * validate attributes
         */
        /*
        if(price < 0 || duration < 0 || userID < 0 || classID < 0){
            throw new IllegalArgumentException("Invalid attribute value in one of the following attributes: " + price + " " + duration + " " + userID + " " + classID);
        }
        if(classification != "YOGA" && classification != "DANCE" && classification != "CYCLING")
        {
            throw new IllegalArgumentException("Invalid classification: " + classification + "\nMust be 'YOGA', 'DANCE', or 'CYCLING'");
        }
        if(date.toString().length() != 8)
        {
            throw new IllegalArgumentException("Invalid date: " + date + "\nMust be in format 'YYYYMMDD'");
        }
        */

        try {
                
                Connection connection = DatabaseManager.connection();
//            Connection connection = dataSource.getConnection();  //alternate datasource connection

            String updateQuery = "UPDATE class SET Price = ?, Duration = ?, Classification = ?, ClassDate = ?, ClassTime = ? WHERE UserID = ? AND ClassID = ?";

            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
            prepStatement.setFloat(1, price);
            prepStatement.setFloat(2, duration);
            prepStatement.setString(3, classification.toString());
            prepStatement.setDate(4, date);
            prepStatement.setInt(5, time);
            prepStatement.setInt(6, userID);
            prepStatement.setInt(7, classID);


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

//            Connection connection = dataSource.getConnection(); //alternate datasource connection
            Connection connection = DatabaseManager.connection();

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

    public int delete(int classID, int userID) throws SQLException {
        //get user id

        try {
            Connection connection = DatabaseManager.connection();
//            Connection connection = dataSource.getConnection(); //alternate datasource connection

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
            return 1; //fail

        }

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
        String formattedStr;
        int formattedInt;
        double formattedDouble;
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
    if(attribute_name == "userID" || attribute_name == "classID" )
        {
            if(! (value instanceof Integer))
            {
                throw new IllegalArgumentException("Invalid value type for userID, must be of class Integer. Value received: " + value);
            }
            formattedInt = Integer.parseInt(value.toString());

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
            else if( value instanceof String){
                formattedStr = value.toString();
            }
            else if(value instanceof Date){
                continue;
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

                String getQuery = "Select * from test where date >= '?'";
                
                prepStatement = connection.prepareStatement(getQuery);
                prepStatement.setDate(1, (Date)value);
            }
            else
            {
                String getQuery = "Select * from test where ? = '?'";
                prepStatement = connection.prepareStatement(getQuery);

                prepStatement.setString(1, attribute_name);

                /*
                 * set value type based on attribute_name
                 */
                if(attribute_name == "price" ||| attribute_name == "duration")
                {
                    prepStatement.setDouble(2, formattedDouble);
                }
                else if(attribute_name == "userID" || attribute_name == "classID")
                {
                    prepStatement.setInt(2, formattedInt);
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
                modelClass.setClassification(resultTable.getString(5));
                modelClass.setTime(resultTable.getTime(6));
                modelClass.setDate(resultTable.getDate(7));
               
         

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


    @Override
    public ArrayList<Class> readByDate(String date) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByDate'");
    }



    
}
