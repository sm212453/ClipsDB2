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

public class UpdateTableActors {
    
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
     * Update data of a persons table specified by the id
     *
     * @param ActorID
     * @param ActorFamily
     * @param ActorName
     * @param ActorSoname
     * @param ActorRole
     */
    public static void update(int ActorID, String ActorFamily, String ActorName, String ActorSoname, String ActorRole) {
        String sql = "INSERT INTO Actors (ActorID, ActorFamily, ActorName, ActorSoname, ActorRole)" + 
                " VALUES(?,?,?,?,?) ";  
        
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, ActorID);
            pstmt.setString(2, ActorFamily);
            pstmt.setString(3, ActorName);
            pstmt.setString(4, ActorSoname);
            pstmt.setString(5, ActorRole);
            
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
        
        UpdateTableActors app = new UpdateTableActors();
        // update the warehouse with id 3
        app.update(12345, "Тестов", "Тест", "Тестович", "Любое");
    }

}
