/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clipsdb;

/**
 *
 * @author jacky
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditDataFormClips2 extends javax.swing.JFrame {

    /**
     * Creates new form EditDataFormClips2
     */
    
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DATABASE_URL = "jdbc:h2:./data/myclips";

    static final String USER = "sa";
    static final String PASSWORD = "";
    
    ResultSet resultSet;
    Connection connection;
    
    public EditDataFormClips2() {
        initComponents();
    }
    
    
    void DBconnect() throws ClassNotFoundException, SQLException {
        connection = null;
        Statement statement = null;

        Class.forName(JDBC_DRIVER);

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            String SQL = "SELECT * FROM Clips";
            resultSet = statement.executeQuery(SQL);       
            }
        catch (SQLException e) {
            /**/
        /**/        }
    
    }  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Просмотр и редактирование таблицы Clips");

        jLabel2.setText("ClipID");

        jTextField1.setText("jTextField1");

        jLabel3.setText("Название");

        jTextField2.setText("jTextField2");

        jLabel4.setText("Длительность");

        jTextField3.setText("jTextField3");

        jLabel5.setText("Тема");

        jTextField4.setText("jTextField4");

        jLabel6.setText("Стоимость");

        jTextField5.setText("jTextField5");

        jLabel7.setText("Дата");

        jTextField6.setText("jTextField6");

        jLabel8.setText("Актер (ID)");

        jTextField7.setText("jTextField7");

        jButton1.setText("Назад");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Вперед");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Очистить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Сохранить");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Показать");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton2)
                        .addGap(44, 44, 44)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {                                         
            try {
                // TODO add your handling code here:
                resultSet.previous();
            } catch (SQLException ex) {
                Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int ClipID = resultSet.getInt("ClipID");
            String ClipName = resultSet.getString("ClipName");
            int ClipDuration = resultSet.getInt("ClipDuration");
            String ClipTheme = resultSet.getString("ClipTheme");
            int ClipCost = resultSet.getInt("ClipCost");
            String ClipDate = resultSet.getString("ClipDate");
            int ClipActorID = resultSet.getInt("ClipActorID");
            
            jTextField1.setText(Integer.toString(ClipID));
            jTextField2.setText(ClipName);
            jTextField3.setText(Integer.toString(ClipDuration));
            jTextField4.setText(ClipTheme);
            jTextField5.setText(Integer.toString(ClipCost));
            jTextField6.setText(ClipDate);
            jTextField7.setText(Integer.toString(ClipActorID));
        } catch (SQLException ex) {
            Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {                                         
            try {
                // TODO add your handling code here:
                resultSet.next();
            } catch (SQLException ex) {
                Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int ClipID = resultSet.getInt("ClipID");
            String ClipName = resultSet.getString("ClipName");
            int ClipDuration = resultSet.getInt("ClipDuration");
            String ClipTheme = resultSet.getString("ClipTheme");
            int ClipCost = resultSet.getInt("ClipCost");
            String ClipDate = resultSet.getString("ClipDate");
            int ClipActorID = resultSet.getInt("ClipActorID");
            
            jTextField1.setText(Integer.toString(ClipID));
            jTextField2.setText(ClipName);
            jTextField3.setText(Integer.toString(ClipDuration));
            jTextField4.setText(ClipTheme);
            jTextField5.setText(Integer.toString(ClipCost));
            jTextField6.setText(ClipDate);
            jTextField7.setText(Integer.toString(ClipActorID));
        } catch (SQLException ex) {
            Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText(""); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {                                         
            
                       
            int ClipID = Integer.parseInt(jTextField1.getText());
            String ClipName = jTextField2.getText();
            int ClipDuration = Integer.parseInt(jTextField3.getText());
            String ClipTheme = jTextField4.getText();
            int ClipCost = Integer.parseInt(jTextField5.getText());
            String ClipDate = jTextField6.getText();  
            int ClipActorID = Integer.parseInt(jTextField7.getText());            
            
            System.out.println(ClipID+" "+ClipName+" "+ ClipDuration+" "+ ClipTheme+" "+ClipCost+" "+ ClipDate+ " "+ ClipActorID);
            
            //UpdateOneClip.update(ClipID, ClipName, ClipDuration, ClipTheme, ClipCost, ClipDate, ClipActorID); 
            String sql = "UPDATE Clips SET ClipName=?, ClipDuration=?, ClipTheme=?, ClipCost=?, "
                + "ClipDate=?, ClipActorID=? WHERE ClipID = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, ClipName);
            pstmt.setInt(2, ClipDuration);
            pstmt.setString(3, ClipTheme);
            pstmt.setInt(4, ClipCost);
            pstmt.setString(5, ClipDate);
            pstmt.setInt(6, ClipActorID);  
            pstmt.setInt(7, ClipID);
            // update 
            int row = pstmt.executeUpdate();
            System.out.println(pstmt);       
            
        } catch (SQLException ex) {
            Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            DBconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {                                         
            try {
                // TODO add your handling code here:
                resultSet.first();
            } catch (SQLException ex) {
                Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int ClipID = resultSet.getInt("ClipID");
            String ClipName = resultSet.getString("ClipName");
            int ClipDuration = resultSet.getInt("ClipDuration");
            String ClipTheme = resultSet.getString("ClipTheme");
            int ClipCost = resultSet.getInt("ClipCost");
            String ClipDate = resultSet.getString("ClipDate");
            int ClipActorID = resultSet.getInt("ClipActorID");
            
            jTextField1.setText(Integer.toString(ClipID));
            jTextField2.setText(ClipName);
            jTextField3.setText(Integer.toString(ClipDuration));
            jTextField4.setText(ClipTheme);
            jTextField5.setText(Integer.toString(ClipCost));
            jTextField6.setText(ClipDate);
            jTextField7.setText(Integer.toString(ClipActorID));
        } catch (SQLException ex) {
            Logger.getLogger(EditDataFormClips2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new NewJFrame().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditDataFormClips2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDataFormClips2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDataFormClips2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDataFormClips2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditDataFormClips2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}