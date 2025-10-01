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
        String sql = "insert ito product (name,price,image) values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setBytes(3, p.getImage());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    public void getallProducts(JTable table) {
        String sql = "select * from product order by id desc";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tabel.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getDouble(3);
                row[3] = rs.getBytes(4);
                model.addRow(row);

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean update(Product product) {
        String sql = "update product set name = ?, price = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean delete(Product product) {
        try {
            ps = con.prepareStatement("delete from product where id = ?");
            ps.setInt(1, product.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;

        }
    }
}
