/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Toko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author ibnnu
 */
public class MyQuery {

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/app_penjualan", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public ArrayList<Toko> BindTable() {

        ArrayList<Toko> list = new ArrayList<Toko>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id_toko`, `nama_toko`, `kategori`, `foto_toko` FROM `toko`");

            Toko p;
            while (rs.next()) {
                p = new Toko(
                        rs.getString("id_toko"),
                        rs.getString("nama_toko"),
                        rs.getString("kategori"),
                        rs.getBytes("foto_toko")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
