/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import _Menu.Menu;
import _Menu.MenuUser;
import _Menu.MyQueryMenuUser;
import _Menu.TheModelMenu;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ibnnu
 */
public final class User extends javax.swing.JFrame {

    private final Connection conn;
    private Statement stat;
    private ResultSet res;
    private TheModelMenu modelMenu;
    public DefaultTableModel modelPesanan;
    public DefaultTableModel modelKonfirmasiPemesanan;
    private String id_toko;

    public User() {
        initComponents();
        // koneksi
        conn = koneksi.Koneksi.cekKoneksi();

        modelPesanan = new DefaultTableModel();
        modelPesanan.addColumn("TOKO");
        modelPesanan.addColumn("MENU");
        modelPesanan.addColumn("HARGA");
        modelPesanan.addColumn("JUMLAH");
        modelPesanan.addColumn("TOTAL");
        tbl_pesanan.setModel(modelPesanan);

        modelKonfirmasiPemesanan = new DefaultTableModel();
        modelKonfirmasiPemesanan.addColumn("TOKO");
        modelKonfirmasiPemesanan.addColumn("MENU");
        modelKonfirmasiPemesanan.addColumn("HARGA");
        modelKonfirmasiPemesanan.addColumn("JUMLAH");
        modelKonfirmasiPemesanan.addColumn("TOTAL");
        tbl_konfirmasi_pemesanan.setModel(modelKonfirmasiPemesanan);

        // get Data table meja
        loadDataMeja();
        // load data nama toko untuk combo box
        loadDataNamaToko();
        // kode transaksi otomatis
        kodeTransaksiOtomatis();
    }

    public User(String no_data, String[] data) {
        initComponents();
        conn = koneksi.Koneksi.cekKoneksi();

        modelPesanan = new DefaultTableModel();
        modelPesanan.addColumn("TOKO");
        modelPesanan.addColumn("MENU");
        modelPesanan.addColumn("HARGA");
        modelPesanan.addColumn("JUMLAH");
        modelPesanan.addColumn("TOTAL");
        tbl_pesanan.setModel(modelPesanan);

        // get Data table meja
        loadDataMeja();
        // load data nama toko untuk combo box
        loadDataNamaToko();
        // kode transaksi otomatis
        kodeTransaksiOtomatis();
    }

    private String kode, kodeTransaksi;

    private void kodeTransaksiOtomatis() {
        String sql = "select * from transaksi order by id_transaksi desc";
        try {
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                kode = res.getString("id_transaksi").substring(1);
                String autoNumber = "" + (Integer.parseInt(kode) + 1);
                String nol = "";

                switch (autoNumber.length()) {
                    case 1:
                        nol = "00";
                        break;
                    case 2:
                        nol = "0";
                        break;
                    case 3:
                        nol = "";
                        break;
                    default:
                        break;
                }

                kodeTransaksi = "T" + nol + autoNumber;
                System.out.println(kodeTransaksi);
            } else {
                kodeTransaksi = "T001";
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("tidak ada data yang masuk");
            System.out.println(e.getMessage());
        }
    }

    private void loadDataMeja() {
        Color textWhite = new Color(255, 255, 255);
        Color avColor = new Color(235, 235, 235);
        Color notavColor = new Color(54, 33, 89);

        try {
            String sql = "select * from meja";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);

            if (res.next() && res.getString("status").equals("available")) {
                pn1.setBackground(avColor);
            } else {
                pn1.setBackground(notavColor);
                lbl1.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn2.setBackground(avColor);
            } else {
                pn2.setBackground(notavColor);
                lbl2.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn3.setBackground(avColor);
            } else {
                pn3.setBackground(notavColor);
                lbl3.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn4.setBackground(avColor);
            } else {
                pn4.setBackground(notavColor);
                lbl4.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn5.setBackground(avColor);
            } else {
                pn5.setBackground(notavColor);
                lbl5.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn6.setBackground(avColor);
            } else {
                pn6.setBackground(notavColor);
                lbl6.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn7.setBackground(avColor);
            } else {
                pn7.setBackground(notavColor);
                lbl7.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn8.setBackground(avColor);
            } else {
                pn8.setBackground(notavColor);
                lbl8.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn9.setBackground(avColor);
            } else {
                pn9.setBackground(notavColor);
                lbl9.setForeground(textWhite);
            }
            if (res.next() && res.getString("status").equals("available")) {
                pn10.setBackground(avColor);
            } else {
                pn10.setBackground(notavColor);
                lbl10.setForeground(textWhite);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            String sql = "select * from meja where status='available'";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            cb_no_meja.removeAllItems();
            while (res.next()) {
                cb_no_meja.addItem(res.getString("meja"));
            }
        } catch (SQLException e) {
        }
        try {
            String sql = "select count(*) as 'total' from meja";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                lbl_jumlah_meja.setText(res.getString("total"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_dahsboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_pembayaran = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_pemesanan = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_data_menu1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bodypane = new javax.swing.JPanel();
        bg_dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_jumlah_meja = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pn1 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        pn3 = new javax.swing.JPanel();
        lbl3 = new javax.swing.JLabel();
        pn4 = new javax.swing.JPanel();
        lbl4 = new javax.swing.JLabel();
        pn5 = new javax.swing.JPanel();
        lbl5 = new javax.swing.JLabel();
        pn7 = new javax.swing.JPanel();
        lbl7 = new javax.swing.JLabel();
        pn9 = new javax.swing.JPanel();
        lbl9 = new javax.swing.JLabel();
        pn6 = new javax.swing.JPanel();
        lbl6 = new javax.swing.JLabel();
        pn8 = new javax.swing.JPanel();
        lbl8 = new javax.swing.JLabel();
        pn10 = new javax.swing.JPanel();
        lbl10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bg_pemesanan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cb_nama_toko = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_pesanan = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_data_menu = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btn_konfirmasi = new javax.swing.JButton();
        btn_hapus_list = new javax.swing.JButton();
        bg_pembayaran = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_konfirmasi_pemesanan = new javax.swing.JTable();
        btn_hapus_konfirmasi_pemesanan = new javax.swing.JButton();
        btn_konfirmasi_pemesanan = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cb_no_meja = new javax.swing.JComboBox<>();
        lbl_total_bayar = new javax.swing.JLabel();
        txt_nama_pembeli = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(54, 33, 89));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_dahsboard.setBackground(new java.awt.Color(85, 65, 118));
        btn_dahsboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dahsboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_dahsboardMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_25px_1.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dashboard");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_dahsboardLayout = new javax.swing.GroupLayout(btn_dahsboard);
        btn_dahsboard.setLayout(btn_dahsboardLayout);
        btn_dahsboardLayout.setHorizontalGroup(
            btn_dahsboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dahsboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        btn_dahsboardLayout.setVerticalGroup(
            btn_dahsboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dahsboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_dahsboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        btn_pembayaran.setBackground(new java.awt.Color(64, 43, 100));
        btn_pembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_pembayaranMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_checkout_25px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pembayaran");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_pembayaranLayout = new javax.swing.GroupLayout(btn_pembayaran);
        btn_pembayaran.setLayout(btn_pembayaranLayout);
        btn_pembayaranLayout.setHorizontalGroup(
            btn_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pembayaranLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_pembayaranLayout.setVerticalGroup(
            btn_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pembayaranLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        btn_pemesanan.setBackground(new java.awt.Color(64, 43, 100));
        btn_pemesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_pemesananMousePressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_25px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pemesanan");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_pemesananLayout = new javax.swing.GroupLayout(btn_pemesanan);
        btn_pemesanan.setLayout(btn_pemesananLayout);
        btn_pemesananLayout.setHorizontalGroup(
            btn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_pemesananLayout.setVerticalGroup(
            btn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_pemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        btn_data_menu1.setBackground(new java.awt.Color(64, 43, 100));
        btn_data_menu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_data_menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_data_menu1MousePressed(evt);
            }
        });

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_logout_rounded_left_25px.png"))); // NOI18N

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Logout");

        javax.swing.GroupLayout btn_data_menu1Layout = new javax.swing.GroupLayout(btn_data_menu1);
        btn_data_menu1.setLayout(btn_data_menu1Layout);
        btn_data_menu1Layout.setHorizontalGroup(
            btn_data_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_data_menu1Layout.setVerticalGroup(
            btn_data_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_data_menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_baru-removebg-preview.png"))); // NOI18N
        sidepane.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 70));

        main.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 630));

        bodypane.setBackground(new java.awt.Color(255, 255, 255));
        bodypane.setLayout(new java.awt.CardLayout());

        bg_dashboard.setBackground(new java.awt.Color(255, 255, 255));
        bg_dashboard.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(64, 43, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Meja_____________________________");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Dashboard");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_dashboard.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 810, 127));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(64, 43, 100));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Jl. Kalimantan No.64, Krajan Timur, A");
        bg_dashboard.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(64, 43, 100));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("KALIMANTAN MEETING POINT");
        bg_dashboard.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 780, -1));

        lbl_jumlah_meja.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_jumlah_meja.setText("Jumlah Meja :");
        bg_dashboard.add(lbl_jumlah_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Jumlah Meja :");
        bg_dashboard.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(64, 43, 100));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("\"FOOD IS CULTURE, CRAVING AND IDENTITY\"");
        bg_dashboard.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 780, -1));

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("1");

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 70, 70));

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("2");

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        lbl3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("3");

        javax.swing.GroupLayout pn3Layout = new javax.swing.GroupLayout(pn3);
        pn3.setLayout(pn3Layout);
        pn3Layout.setHorizontalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn3Layout.setVerticalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("4");

        javax.swing.GroupLayout pn4Layout = new javax.swing.GroupLayout(pn4);
        pn4.setLayout(pn4Layout);
        pn4Layout.setHorizontalGroup(
            pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn4Layout.setVerticalGroup(
            pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        lbl5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("5");

        javax.swing.GroupLayout pn5Layout = new javax.swing.GroupLayout(pn5);
        pn5.setLayout(pn5Layout);
        pn5Layout.setHorizontalGroup(
            pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn5Layout.setVerticalGroup(
            pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 70, -1));

        lbl7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setText("7");

        javax.swing.GroupLayout pn7Layout = new javax.swing.GroupLayout(pn7);
        pn7.setLayout(pn7Layout);
        pn7Layout.setHorizontalGroup(
            pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn7Layout.setVerticalGroup(
            pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        lbl9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setText("9");

        javax.swing.GroupLayout pn9Layout = new javax.swing.GroupLayout(pn9);
        pn9.setLayout(pn9Layout);
        pn9Layout.setHorizontalGroup(
            pn9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn9Layout.setVerticalGroup(
            pn9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        lbl6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setText("6");

        javax.swing.GroupLayout pn6Layout = new javax.swing.GroupLayout(pn6);
        pn6.setLayout(pn6Layout);
        pn6Layout.setHorizontalGroup(
            pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn6Layout.setVerticalGroup(
            pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        lbl8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setText("8");

        javax.swing.GroupLayout pn8Layout = new javax.swing.GroupLayout(pn8);
        pn8.setLayout(pn8Layout);
        pn8Layout.setHorizontalGroup(
            pn8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn8Layout.setVerticalGroup(
            pn8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        lbl10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setText("10");

        javax.swing.GroupLayout pn10Layout = new javax.swing.GroupLayout(pn10);
        pn10.setLayout(pn10Layout);
        pn10Layout.setHorizontalGroup(
            pn10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn10Layout.setVerticalGroup(
            pn10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg_dashboard.add(pn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_filled_circle_25px_2.png"))); // NOI18N
        jLabel2.setText("Available");
        jLabel2.setIconTextGap(9);
        bg_dashboard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 170, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_filled_circle_25px_1.png"))); // NOI18N
        jLabel15.setText("Not Available");
        jLabel15.setIconTextGap(9);
        bg_dashboard.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 170, -1));

        bodypane.add(bg_dashboard, "card2");

        bg_pemesanan.setBackground(new java.awt.Color(255, 255, 255));
        bg_pemesanan.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_pemesanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(64, 43, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Silahkan Pesan__________________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Pemesanan");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_pemesanan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

        cb_nama_toko.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_nama_toko.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb_nama_tokoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        bg_pemesanan.add(cb_nama_toko, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Nama Toko");
        bg_pemesanan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_pesanan.setAutoCreateRowSorter(true);
        tbl_pesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAMA TOKO", "FOTO"
            }
        ));
        tbl_pesanan.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_pesanan.setRowHeight(25);
        tbl_pesanan.setRowMargin(5);
        tbl_pesanan.setSelectionBackground(new java.awt.Color(64, 43, 100));
        tbl_pesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pesananMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_pesanan);

        bg_pemesanan.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 740, 180));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_data_menu.setAutoCreateRowSorter(true);
        tbl_data_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAMA TOKO", "FOTO"
            }
        ));
        tbl_data_menu.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_data_menu.setRowHeight(25);
        tbl_data_menu.setRowMargin(5);
        tbl_data_menu.setSelectionBackground(new java.awt.Color(64, 43, 100));
        tbl_data_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data_menuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_data_menu);

        bg_pemesanan.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 740, 180));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Pesanan");
        bg_pemesanan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        btn_konfirmasi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_konfirmasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_wallet_25px.png"))); // NOI18N
        btn_konfirmasi.setText("Konfirmasi Pemesanan");
        btn_konfirmasi.setToolTipText("hapus list pesanan");
        btn_konfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_konfirmasiActionPerformed(evt);
            }
        });
        bg_pemesanan.add(btn_konfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 240, -1));

        btn_hapus_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_bin_25px.png"))); // NOI18N
        btn_hapus_list.setToolTipText("hapus list pesanan");
        btn_hapus_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_listActionPerformed(evt);
            }
        });
        bg_pemesanan.add(btn_hapus_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, -1, -1));

        bodypane.add(bg_pemesanan, "card2");

        bg_pembayaran.setBackground(new java.awt.Color(255, 255, 255));
        bg_pembayaran.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_pembayaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(64, 43, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Konfirmasi Pembayaran____________________");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Pembayaran");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_pembayaran.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

        jScrollPane7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_konfirmasi_pemesanan.setAutoCreateRowSorter(true);
        tbl_konfirmasi_pemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAMA TOKO", "FOTO"
            }
        ));
        tbl_konfirmasi_pemesanan.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_konfirmasi_pemesanan.setRowHeight(25);
        tbl_konfirmasi_pemesanan.setRowMargin(5);
        tbl_konfirmasi_pemesanan.setSelectionBackground(new java.awt.Color(64, 43, 100));
        jScrollPane7.setViewportView(tbl_konfirmasi_pemesanan);

        bg_pembayaran.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 740, 300));

        btn_hapus_konfirmasi_pemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_bin_25px.png"))); // NOI18N
        btn_hapus_konfirmasi_pemesanan.setText("Hapus");
        btn_hapus_konfirmasi_pemesanan.setToolTipText("hapus list pesanan");
        btn_hapus_konfirmasi_pemesanan.setAlignmentY(0.0F);
        btn_hapus_konfirmasi_pemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_konfirmasi_pemesananActionPerformed(evt);
            }
        });
        bg_pembayaran.add(btn_hapus_konfirmasi_pemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 110, 40));

        btn_konfirmasi_pemesanan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_konfirmasi_pemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_refund_25px_1.png"))); // NOI18N
        btn_konfirmasi_pemesanan.setText("Lakukan Pembayaran");
        btn_konfirmasi_pemesanan.setToolTipText("bayar");
        btn_konfirmasi_pemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_konfirmasi_pemesananActionPerformed(evt);
            }
        });
        bg_pembayaran.add(btn_konfirmasi_pemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 270, 90));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Pembeli");
        bg_pembayaran.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        bg_pembayaran.add(cb_no_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 40));

        lbl_total_bayar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total_bayar.setText("0");
        bg_pembayaran.add(lbl_total_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, -1));
        bg_pembayaran.add(txt_nama_pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, 40));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("No. Meja");
        bg_pembayaran.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setText("TOTAL BAYAR : ");
        bg_pembayaran.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        bodypane.add(bg_pembayaran, "card2");

        main.add(bodypane, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dahsboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dahsboardMousePressed
        // TODO add your handling code here:
        setColor(btn_dahsboard);
        resetColor(btn_pemesanan);
        resetColor(btn_pembayaran);

        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_dashboard);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_dahsboardMousePressed

    private void btn_pembayaranMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pembayaranMousePressed
        // TODO add your handling code here:
        setColor(btn_pembayaran);
        resetColor(btn_pemesanan);
        resetColor(btn_dahsboard);

        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_pembayaran);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_pembayaranMousePressed

    private void btn_pemesananMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pemesananMousePressed
        loadDataMeja();
        setColor(btn_pemesanan);
        resetColor(btn_dahsboard);
        resetColor(btn_pembayaran);

        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_pemesanan);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_pemesananMousePressed

    private void cb_nama_tokoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_nama_tokoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try {
            String sql = "select id_toko from toko where nama_toko='" + cb_nama_toko.getSelectedItem().toString() + "'";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                id_toko = res.getString("id_toko");
                System.out.println(id_toko);
            }
        } catch (Exception e) {
        }
        loadDataMenu();
    }//GEN-LAST:event_cb_nama_tokoPopupMenuWillBecomeInvisible

    private void tbl_data_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_menuMouseClicked
        // TODO add your handling code here:
        int i = tbl_data_menu.getSelectedRow();
        String toko = modelMenu.getValueAt(i, 0).toString();
        String menu = modelMenu.getValueAt(i, 1).toString();
        String harga = modelMenu.getValueAt(i, 3).toString();
        String jumlah = "";
        String total = "";

        String[] data = {
            toko, menu, harga, jumlah, total
        };

        modelPesanan.addRow(data);

    }//GEN-LAST:event_tbl_data_menuMouseClicked

    // cek data pesanan
    private boolean cekDataPesanan() {
        boolean status = false;
        for (int j = 0; j < tbl_pesanan.getRowCount(); j++) {
            if (tbl_pesanan.getValueAt(j, 3).toString().equals("") || Integer.parseInt(tbl_pesanan.getValueAt(j, 3).toString()) == 0) {
                status = true;
            }
        }
        return status;
    }

    private void btn_konfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_konfirmasiActionPerformed
        // TODO add your handling code here:
        loadDataMeja();
        if (cekDataPesanan() == true) {
            JOptionPane.showMessageDialog(this, "Isi jumlah dulu");
        } else {
            if (tbl_pesanan.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Lakukan pemesanan terlebih dahulu");
            } else {
                int conf = JOptionPane.showConfirmDialog(this, "Apakah kamu yakin ? ", "Perhatikan!", JOptionPane.YES_NO_OPTION);
                if (conf == 0) {
                    int rows = tbl_pesanan.getRowCount();
                    Object[] os = new Object[5];
                    for (int i = 0; i < rows; i++) {
                        os[0] = modelPesanan.getValueAt(i, 0);
                        os[1] = modelPesanan.getValueAt(i, 1);
                        os[2] = modelPesanan.getValueAt(i, 2);
                        os[3] = modelPesanan.getValueAt(i, 3);
                        os[4] = modelPesanan.getValueAt(i, 4);
                        modelKonfirmasiPemesanan.addRow(os);
                    }
                    setColor(btn_pembayaran);
                    resetColor(btn_pemesanan);
                    resetColor(btn_dahsboard);

                    // panel
                    bodypane.removeAll();
                    bodypane.repaint();
                    bodypane.revalidate();

                    bodypane.add(bg_pembayaran);
                    bodypane.repaint();
                    bodypane.revalidate();
                }
            }
        }
    }//GEN-LAST:event_btn_konfirmasiActionPerformed

    private void tbl_pesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pesananMouseClicked
        // TODO add your handling code here:  

        int i = tbl_pesanan.getSelectedRow();
        String toko = modelPesanan.getValueAt(i, 0).toString();
        String menu = modelPesanan.getValueAt(i, 1).toString();
        String harga = modelPesanan.getValueAt(i, 2).toString();
        String jumlah = modelPesanan.getValueAt(i, 3).toString();

        String newJumlah = JOptionPane.showInputDialog(null, "Menu : " + menu + "\nHarga : " + harga + "\nMasukan jumlah : " + jumlah);
        if (newJumlah.matches("[A-Za-z]*")) {
            JOptionPane.showMessageDialog(this, "Jumlah harus angka");
            newJumlah = "";
            newJumlah = JOptionPane.showInputDialog(null, "Menu : " + menu + "\nHarga : " + harga + "\nMasukan jumlah : " + jumlah);
        }
        if (Integer.parseInt(newJumlah) == 0) {
            newJumlah = "0";
        }

        int totalBayar = Integer.parseInt(newJumlah) * Integer.parseInt(harga);

        if (newJumlah.length() == 0) {
            modelPesanan.setValueAt(0, i, 4);
        } else {
            modelPesanan.setValueAt(newJumlah, i, 3);
            modelPesanan.setValueAt(String.valueOf(totalBayar), i, 4);
        }
        int total_bayarFix = Integer.parseInt(lbl_total_bayar.getText()) + totalBayar;
        lbl_total_bayar.setText(String.valueOf(total_bayarFix));

    }//GEN-LAST:event_tbl_pesananMouseClicked

    private void btn_hapus_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_listActionPerformed
        // TODO add your handling code here:
        if (tbl_pesanan.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tabel pesanan kosong!");
        } else {
            int conf = JOptionPane.showConfirmDialog(this, "Apakah kamu yakin ? ", "Perhatikan!", JOptionPane.YES_NO_OPTION);
            if (conf == 0) {
                int i = tbl_pesanan.getSelectedRow();
                modelPesanan.removeRow(i);
                JOptionPane.showMessageDialog(this, "Pesanan dihapus");
            }
        }
    }//GEN-LAST:event_btn_hapus_listActionPerformed

    private void btn_hapus_konfirmasi_pemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_konfirmasi_pemesananActionPerformed
        // TODO add your handling code here:
        int i = tbl_konfirmasi_pemesanan.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Pilih pesanan yang ingin dihapus!");
        } else {
            int conf = JOptionPane.showConfirmDialog(this, "Apakah kamu yakin ? ", "Perhatikan!", JOptionPane.YES_NO_OPTION);
            if (conf == 0) {

                modelKonfirmasiPemesanan.removeRow(i);
                JOptionPane.showMessageDialog(this, "Pesanan dihapus");
            }
        }
        int total = 0;
        for (int k = 0; k < tbl_konfirmasi_pemesanan.getRowCount(); k++) {
            int harga = Integer.parseInt((String) modelKonfirmasiPemesanan.getValueAt(k, 4));
            total += harga;
        }
        lbl_total_bayar.setText(String.valueOf(total));
    }//GEN-LAST:event_btn_hapus_konfirmasi_pemesananActionPerformed

    static int no_meja_rev;
    private void btn_konfirmasi_pemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_konfirmasi_pemesananActionPerformed
        // TODO add your handling code here:
        if (txt_nama_pembeli.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Isi nama pembeli terlebih dahulu");
        } else {
            try {
                int rows = modelKonfirmasiPemesanan.getRowCount();
                String sql = "insert into detailtransaksi(id_detailTransaksi, id_meja, id_toko, id_menu,"
                        + "jumlah, total_bayar) values(?,?,?,?,?,?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                kodeTransaksiOtomatis();
                String nama_pembeli = txt_nama_pembeli.getText();
                int total = 0;
                for (int i = 0; i < modelKonfirmasiPemesanan.getRowCount(); i++) {
                    total += Integer.parseInt((String) modelKonfirmasiPemesanan.getValueAt(i, 4));
                }
               
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                Date d = new Date();
                String tgl_transaksi = date.format(d);
                // insert all data on table;
                for (int i = 0; i < rows; i++) {
                    no_meja_rev = Integer.parseInt(cb_no_meja.getSelectedItem().toString());

                    String nama_toko = modelKonfirmasiPemesanan.getValueAt(i, 0).toString();
                    String nama_menu = modelKonfirmasiPemesanan.getValueAt(i, 1).toString();
                    int jumlah = Integer.parseInt((String) modelKonfirmasiPemesanan.getValueAt(i, 3));
                    int totalBayar = Integer.parseInt((String) modelKonfirmasiPemesanan.getValueAt(i, 4));
                    // prepare query table detail transaksi
                    pst.setString(1, kodeTransaksi);
                    pst.setInt(2, no_meja_rev);
                    String idTOKO = "", idMENU = "";

                    for (int j = 0; j < rows; j++) {
                        try {
                            String sql4 = "select toko.id_toko from toko where nama_toko='" + nama_toko + "'";
                            Statement stat = conn.createStatement();
                            res = stat.executeQuery(sql4);
                            if (res.next()) {
                                idTOKO = res.getString("id_toko");
                            }
                            pst.setString(3, idTOKO);
                        } catch (SQLException e) {
                        }

                        try {
                            String sql4 = "select menu.id_menu from menu where nama_menu='" + nama_menu + "'";
                            Statement stat = conn.createStatement();
                            res = stat.executeQuery(sql4);
                            if (res.next()) {
                                idMENU = res.getString("id_menu");
                            }
                            pst.setString(4, idMENU);
                        } catch (SQLException e) {
                        }
                    }
                    pst.setInt(5, jumlah);
                    pst.setString(6, String.valueOf(totalBayar));
                    pst.execute();
                }

                try {
                    String sql2 = "insert into transaksi(id_transaksi, nama_pembeli, total_bayar, tgl_transaksi) "
                            + "values(?,?,?,?)";
                    PreparedStatement pst2 = conn.prepareStatement(sql2);

                    // sql2 table transaksi
                    pst2.setString(1, kodeTransaksi);
                    pst2.setString(2, nama_pembeli);
                    pst2.setInt(3, total);
                    pst2.setString(4, tgl_transaksi);
                    pst2.execute();
                } catch (SQLException e) {
                }

                modelKonfirmasiPemesanan.getDataVector().removeAllElements();
                modelKonfirmasiPemesanan.fireTableDataChanged();
                modelPesanan.getDataVector().removeAllElements();
                modelPesanan.fireTableDataChanged();

                JOptionPane.showMessageDialog(this, "Pemesanan Berhasil!");
                lbl_total_bayar.setText("0");
                cb_no_meja.setSelectedIndex(0);
                txt_nama_pembeli.setText("");
                loadDataMeja();

            } catch (SQLException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            try {
                String sql = "update meja set status='not available' where meja='" + no_meja_rev + "'";
                stat = conn.createStatement();
                stat.executeUpdate(sql);
            } catch (SQLException e) {

            }

            //nota
            try {
                JasperReport jr;
                JasperPrint jp;

                String file = "C:\\Users\\ibnua\\Documents\\NetBeansProjects\\penjualan fiks\\src\\report\\struk.jrxml";

                HashMap hash = new HashMap();
                hash.put("id_transaksi", kodeTransaksi);

                jr = JasperCompileManager.compileReport(file);
                jp = JasperFillManager.fillReport(jr, hash, conn);
                JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_konfirmasi_pemesananActionPerformed

    private void btn_data_menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_data_menu1MousePressed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Apakah kamu ingin keluar ?", "Mau kemana", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            new Home().show();
            this.dispose();
        }
    }//GEN-LAST:event_btn_data_menu1MousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new User().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_dashboard;
    private javax.swing.JPanel bg_pembayaran;
    private javax.swing.JPanel bg_pemesanan;
    private javax.swing.JPanel bodypane;
    private javax.swing.JPanel btn_dahsboard;
    private javax.swing.JPanel btn_data_menu1;
    private javax.swing.JButton btn_hapus_konfirmasi_pemesanan;
    private javax.swing.JButton btn_hapus_list;
    private javax.swing.JButton btn_konfirmasi;
    private javax.swing.JButton btn_konfirmasi_pemesanan;
    private javax.swing.JPanel btn_pembayaran;
    private javax.swing.JPanel btn_pemesanan;
    private javax.swing.JComboBox<String> cb_nama_toko;
    private javax.swing.JComboBox<String> cb_no_meja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lbl_jumlah_meja;
    private javax.swing.JLabel lbl_total_bayar;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn10;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JPanel pn4;
    private javax.swing.JPanel pn5;
    private javax.swing.JPanel pn6;
    private javax.swing.JPanel pn7;
    private javax.swing.JPanel pn8;
    private javax.swing.JPanel pn9;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTable tbl_data_menu;
    public javax.swing.JTable tbl_konfirmasi_pemesanan;
    public javax.swing.JTable tbl_pesanan;
    private javax.swing.JTextField txt_nama_pembeli;
    // End of variables declaration//GEN-END:variables
    // filed for photo
    byte[] photo = null;
    String filename = null;

    void setColor(JPanel panel) {
        panel.setBackground(new Color(85, 64, 118));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));
    }

    // get data combo box nama toko
    private void loadDataNamaToko() {
        try {
            String sql = "select * from toko";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {
                cb_nama_toko.addItem(res.getString("nama_toko"));
            }
        } catch (SQLException e) {
            System.out.println("tidak ada dataa");
        }
    }

    // get Data Tabel Menu
    public void loadDataMenu() {
        _Menu.MyQueryMenuUser mq = new MyQueryMenuUser();
        ArrayList<MenuUser> list = mq.BindTable(id_toko);
        String[] columnName = {"Nama Toko", "Nama Menu", "Kategori", "Harga", "Foto"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getNamaToko();
            rows[i][1] = list.get(i).getNamaMenu();
            rows[i][2] = list.get(i).getCategory();
            rows[i][3] = list.get(i).getHarga();

            if (list.get(i).getMyImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
                        .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

                rows[i][4] = image;
            } else {
                rows[i][4] = null;
            }
        }

        modelMenu = new TheModelMenu(rows, columnName);
        tbl_data_menu.setModel(modelMenu);
        tbl_data_menu.setRowHeight(120);
        tbl_data_menu.getColumnModel().getColumn(4).setPreferredWidth(150);
    }
}
