/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Dao {

    Connection con = MyConnection.getConnection();
    Statement st;
    PreparedStatement ps;
    ResultSet rs;

    
    public boolean insertProduct(Product p) {
        String sql="insert ito product (name,price,image) values(?,?,?)";
        try{
        ps=con.prepareStatement(sql);
        ps.setString(1,p.getName());
        ps.setDouble(2,p.getPrice());
        ps.setBytes(3,p.getImage());
        return ps.executeUpdate() > 0;
    }catch (Exception ex){
        return false;
}
}
}

