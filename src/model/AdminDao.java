/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDao {
    
    Connection con = MyConnection.getConnection();  // ✅ make sure it's MyConnection (not Myconnection)
    Statement st;
    ResultSet rs;
    
    public int getMaxRowAdminTable() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT MAX(id) FROM admin");  // ✅ correct SQL
            if (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (Exception ex) {   // ✅ Exception spelling
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;   // ✅ always return result
    }
}
