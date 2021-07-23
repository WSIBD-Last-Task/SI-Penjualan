/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author ibnnu
 */
public class MyQueryMenu {

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/app_penjualan", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public ArrayList<Menu> BindTable() {

        ArrayList<Menu> list = new ArrayList<Menu>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id_menu`, `id_toko`, `nama_menu`, `kategori`, `harga`, `foto_menu` FROM `menu`");

            Menu p;
            while (rs.next()) {
                p = new Menu(
                        rs.getString("id_menu"),
                        rs.getString("id_toko"),
                        rs.getString("nama_menu"),
                        rs.getString("kategori"),
                        rs.getString("harga"),
                        rs.getBytes("foto_menu")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQueryMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
