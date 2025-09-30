/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyConnection {
    public static final String username = "root";
    public static final String password = "parvathi";
    public static final String url = "jdbc:mysql://localhost:3306/cafe2"; //
    public static Connection con = null;
    
    public static Connection getConnection() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found: " + ex, "Error", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex, "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        return con;
    }
}
