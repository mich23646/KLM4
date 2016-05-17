/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klm4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jelle
 */

public class Database {
    
    private static Connection connection;
    private final static String DATABASE = "jdbc:mysql://localhost:3306/klm";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "jvdlee";
    public static boolean authenticate;
    public static String authUsername;
    
    /**
     * 
     * @throws SQLException 
     */
    public static void openConnection() throws SQLException {
        connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        System.out.println("Connected with database: (" + DATABASE + ").");
    }
    
    /**
     * 
     * @throws SQLException 
     */
    public static void closeConnection() throws SQLException {
        connection.close();
        System.out.println("Connection with database: (" + DATABASE + ") closed.");
    }
    
    /**
     * 
     * @param query
     * @return 
     * @throws java.sql.SQLException 
     */
    public static ResultSet selectQuery(String query) throws SQLException {        
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);        
    }
   
    /**
     * 
     * @param query
     * @return
     * @throws SQLException 
     */
    public static ResultSet insertQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        return statement.getGeneratedKeys(); //returns new key (id)
    }
    
    /**
     * 
     * @param query
     * @throws SQLException 
     */
    public static void updateQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
    
    /**
     * 
     * @param username
     * @param password
     * @return
     * @throws SQLException 
     */
    public static boolean getAuthentication(String username, String password)
            throws SQLException {
        ResultSet result; //Resultholder of executed query
        authenticate = false;
        
        //Check if credentials are correct in DB
        result = Database.selectQuery("SELECT * FROM login WHERE "
                + "username = '" + username + "' AND "
                + "password = '" + password + "' LIMIT 1");

        //Check if query has result
        if (result.isBeforeFirst()) {
            authenticate = true;
            while(result.next()) {
                authUsername = result.getString("username") + " " + result.getString("password");
            }
        }

        return authenticate;
    }
}
