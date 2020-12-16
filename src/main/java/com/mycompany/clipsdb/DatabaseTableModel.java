/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clipsdb;


import java.util.*;
import java.util.ArrayList;

import java.sql.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
 
public class DatabaseTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> columnNames = new ArrayList<String>();
    private ArrayList<Class> columnTypes = new ArrayList<Class>();
    private ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
    
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.h2.Driver";  
   static final String DB_URL = "jdbc:h2:./data/myclips";

   //  Database credentials
   static final String USER = "sa";
   static final String PASS = "";
 
    public int getRowCount() {
        synchronized (data) {
            return data.size();
        }
    }
 
    public int getColumnCount() {
        return columnNames.size();
    }
 
    public Object getValueAt(int row, int col) {
        synchronized (data) {
            return data.get(row).get(col);
        }
    }
 
    public String getColumnName(int col) {
        return columnNames.get(col);
    }
 
    public Class getColumnClass(int col) {
        return columnTypes.get(col);
    }
 
    public boolean isCellEditable(int row, int col) {
        return true;
    }
 
    public void setValueAt(Object obj, int row, int col) {
        synchronized (data) {
            data.get(row).set(col, obj);
        }
    }
     
    /**
     * Core of the model. Initializes column names, types, data from ResultSet.
     *
     * @param rs ResultSet from which all information for model is token.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void setDataSource(ResultSet rs) throws SQLException, ClassNotFoundException {
        ResultSetMetaData rsmd = rs.getMetaData();
        columnNames.clear();
        columnTypes.clear();
        data.clear();
 
        int columnCount = rsmd.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(rsmd.getColumnName(i + 1));
            Class type = Class.forName(rsmd.getColumnClassName(i + 1));
            columnTypes.add(type);
        }
        fireTableStructureChanged();
        while (rs.next()) {
            ArrayList rowData = new ArrayList();
            for (int i = 0; i < columnCount; i++) {
                if (columnTypes.get(i) == String.class)
                    rowData.add(rs.getString(i + 1));
                else
                    rowData.add(rs.getObject(i + 1));
            }
            synchronized (data) {
                data.add(rowData);
                this.fireTableRowsInserted(data.size() - 1, data.size() - 1);
            }
        }
    }
 
    //***TEST***
    public static void main(String[] args) {
        try {
            String s = args[0];
            System.out.println("Аргумент метода : " + s);
            String query = "select * from " + s;  //your data
            //Connection con = DriverManager.getConnection("jdbc:mysql://" + url, user, password);
            
            //String url = "jdbc:sqlite:/home/jacky/NetBeansProjects/mavenproject9/curs5_1.db";
            //String url = "jdbc:sqlite:customers";
            //Connection con = DriverManager.getConnection(url);
                        
            Class.forName(JDBC_DRIVER);      
            System.out.println("Connecting to database...");
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            
                          
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            DatabaseTableModel model = new  DatabaseTableModel();
            model.setDataSource(rs);
            JTable table = new JTable(model);
            
            JButton button3 = new JButton("Вернуться");            
            button3.setVisible(true);
            
 
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(table), BorderLayout.CENTER);
            panel.add(button3, BorderLayout.NORTH);
            
 
            JFrame frame = new JFrame("Database Table Model");
            frame.setLocationRelativeTo(null);
            frame.setSize(500, 400);
            frame.setContentPane(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
            frame.setVisible(true);
                        
            
            button3.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new NewJFrame().setVisible(true);
               }
            });
            
 
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
