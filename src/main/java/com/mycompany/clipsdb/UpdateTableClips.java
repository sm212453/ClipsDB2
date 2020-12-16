/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clipsdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jacky
 */
public class UpdateTableClips {
    
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.h2.Driver";  
   static final String DB_URL = "jdbc:h2:./data/myclips";

   //  Database credentials
   static final String USER = "sa";
   static final String PASS = "";
      
    private static Connection connect() {
              
        
        // SQLite connection string
        Connection conn = null;
        try {
            //Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Update data of a Clips table specified by the id
     * 
     * @param ClipID 
     * @param ClipName
     * @param ClipDuration
     * @param ClipTheme
     * @param ClipCost
     * @param ClipDate
     * @param ClipActorID
     */
      
    
    // int person_code, String address_city, String address_street, String address_corp, String address_house, String address_flat, String tel_number      
            
    public static void update( int ClipID, String ClipName, int ClipDuration, String ClipTheme, int ClipCost, String ClipDate, int ClipActorID) {
        String sql = "INSERT INTO Clips(ClipID, ClipName, ClipDuration, ClipTheme, ClipCost, ClipDate, ClipActorID)" + 
                " VALUES(?,?,?,?,?,?,?) ";  
        
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, ClipID);
            pstmt.setString(2, ClipName);
            pstmt.setInt(3, ClipDuration);
            pstmt.setString(4, ClipTheme);
            pstmt.setInt(5, ClipCost);
            pstmt.setString(6, ClipDate);
            pstmt.setInt(7, ClipActorID);          
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UpdateTableClips app = new UpdateTableClips();
        // update the warehouse with id 3
        app.update(12, "Фильм о любви", 120, "Мелодрама", 100, "18-11-2020", 1);
    }

}
