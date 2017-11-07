/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author dab18
 */
public class DBConnection {
    private static Connection databaseConnection;
    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private static final String jdbcURL = "jdbc:sqlserver://localhost:1433;databasename=MSSQLSERVER;";
    private static final String jdbcURL =
            "jdbc:sqlserver://CASA-PC\\SQLFULL:1433;databaseName=DB_CORP;integratedSecurity=true";
            //"jdbc:sqlserver://CASA-PC/inst01;databaseName=LOCALHOST;integratedSecurity=true";
    private static boolean dbConnected;
    public static DBConnection dbConnection;
    
    
    public static DBConnection getInstance() {
        if (dbConnection == null) dbConnection = new DBConnection();
        return dbConnection;
    }
  
    public Connection connect(){
        try {
            Class.forName(jdbcDriver).newInstance();
            System.out.println("JDBC driver loaded");
            
            databaseConnection = DriverManager.getConnection(jdbcURL);
            System.out.println("Connected to the database");
            dbConnected = true;
            return databaseConnection;
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("Can't connect to DB");
            
        } catch (Exception err) {
            System.err.println("Error loading JDBC driver");
            err.printStackTrace(System.err);
            System.exit(0);
        }
        
        return null;
    }
    
    public void disconnect() {
        try {
            if (databaseConnection != null) {
                if (!databaseConnection.isClosed()) {
                    dbConnected = false;
                    databaseConnection.close();
                }
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isConnected() {
        return dbConnected;
    }
}


    

