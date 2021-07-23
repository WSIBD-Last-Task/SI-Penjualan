/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import _Menu.Menu;
import _Menu.MyQueryMenu;
import _Menu.TheModelMenu;
import _Toko.MyQuery;
import _Toko.TheModel;
import _Toko.Toko;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author ibnnu
 */
public final class Admin extends javax.swing.JFrame {

    private final Connection conn;
    private PreparedStatement pst;
    private ResultSet res;
    private TheModel model;
    private TheModelMenu modelMenu;
    private final DefaultTableModel modelMeja;
    private final DefaultTableModel modelTransaksi;
    private final DefaultTableModel modelTransaksiToko;

    private String id_toko;
    // rekap
    private String tanggal_dari, tanggal_sampai;

    public Admin() {
        initComponents();
        // cek koneksi
        conn = koneksi.Koneksi.cekKoneksi();

        modelMeja = new DefaultTableModel();
        modelMeja.addColumn("NO MEJA");
        modelMeja.addColumn("STATUS");
        tbl_data_meja.setModel(modelMeja);

        modelTransaksi = new DefaultTableModel();
        modelTransaksi.addColumn("#ID");
        modelTransaksi.addColumn("*PEMBELI");
        modelTransaksi.addColumn("TOKO");
        modelTransaksi.addColumn("MENU");
        modelTransaksi.addColumn("JUMLAH");
        modelTransaksi.addColumn("TOTAL");
        modelTransaksi.addColumn("TANGGAL");
        tbl_transaksi.setModel(modelTransaksi);

        modelTransaksiToko = new DefaultTableModel();
        modelTransaksiToko.addColumn("*PEMBELI");
        modelTransaksiToko.addColumn("MENU");
        modelTransaksiToko.addColumn("JUMLAH");
        modelTransaksiToko.addColumn("TOTAL");
        modelTransaksiToko.addColumn("TANGGAL");
        tbl_data_transaksi_per_toko.setModel(modelTransaksiToko);

        // data toko
        loadDataToko();
        // data meja
        loadDataMeja();
        // data nama toko untuk combo box
        loadDataNamaToko();
        // data menu
        loadDataMenu();
        // data transaksi
        loadDataTransaksi();
        // load data total order
        loadBadge();
        // id toko otomatis
        id_toko_otomatis();
    }

    private void loadDataTransaksi() {
        modelTransaksi.getDataVector().removeAllElements();
        modelTransaksi.fireTableDataChanged();
        String sql = "SELECT detailtransaksi.id_detailTransaksi, transaksi.nama_pembeli, toko.nama_toko,"
                + " menu.nama_menu, detailtransaksi.jumlah, detailtransaksi.total_bayar,"
                + " transaksi.tgl_transaksi FROM detailtransaksi, transaksi, toko, menu"
                + " WHERE detailtransaksi.id_detailTransaksi = transaksi.id_transaksi AND "
                + "detailtransaksi.id_toko = toko.id_toko AND detailtransaksi.id_menu = menu.id_menu;";
        try {
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {
                Object[] o = new Object[7];
                o[0] = res.getString("id_detailTransaksi");
                o[1] = res.getString("nama_pembeli");
                o[2] = res.getString("nama_toko");
                o[3] = res.getString("nama_menu");
                o[4] = res.getString("jumlah");
                o[5] = res.getString("total_bayar");
                o[6] = res.getString("tgl_transaksi");
                modelTransaksi.addRow(o);
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

        txt_id_toko = new javax.swing.JTextField();
        txt_id_menu = new javax.swing.JTextField();
        main = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_data_menu = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btn_data_meja = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_data_toko = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_dahsboard = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_data_transaksi = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_data_menu1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        bodypane = new javax.swing.JPanel();
        bg_dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_ttransaksi = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_ttpendapatan = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_ttmeja = new javax.swing.JLabel();
        cb_toko_2 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_data_transaksi_per_toko = new javax.swing.JTable();
        lbl_total_pendapatan = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btn_statistik = new javax.swing.JButton();
        bg_toko = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_path = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cb_kategori = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_data_toko = new javax.swing.JTable();
        JDekstopPane = new javax.swing.JDesktopPane();
        bg_profil_toko = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        btn_upload = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_nama_toko = new javax.swing.JTextField();
        btn_tambah_menu1 = new javax.swing.JButton();
        bg_transaksi = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        btn_cetak = new javax.swing.JButton();
        btn_rekap1 = new javax.swing.JButton();
        dc_tanggal_sampai = new com.toedter.calendar.JDateChooser();
        dc_tanggal_dari = new com.toedter.calendar.JDateChooser();
        jLabel40 = new javax.swing.JLabel();
        btn_rekap_range = new javax.swing.JButton();
        lbl_total_rekap_transaksi = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        bg_meja = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_data_meja = new javax.swing.JTable();
        btn_edit_meja = new javax.swing.JButton();
        btn_hapus_meja = new javax.swing.JButton();
        txt_no_meja = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cb_status_meja = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        lbl_jumlah_meja = new javax.swing.JLabel();
        btn_tambah_meja = new javax.swing.JButton();
        bg_menu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_data_menu = new javax.swing.JTable();
        btn_tambah_menu = new javax.swing.JButton();
        btn_hapus_menu = new javax.swing.JButton();
        txt_nama_menu = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cb_nama_toko = new javax.swing.JComboBox<>();
        btn_edit_menu = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        cb_kategori_menu = new javax.swing.JComboBox<>();
        txt_harga = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        JDekstopPane1 = new javax.swing.JDesktopPane();
        bg_profil_menu = new javax.swing.JLabel();
        btn_upload_menu = new javax.swing.JButton();
        txt_path_menu = new javax.swing.JTextField();

        txt_id_menu.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(54, 33, 89));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_data_menu.setBackground(new java.awt.Color(64, 43, 100));
        btn_data_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_data_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_data_menuMousePressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_menu_25px.png"))); // NOI18N

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Data Menu");

        javax.swing.GroupLayout btn_data_menuLayout = new javax.swing.GroupLayout(btn_data_menu);
        btn_data_menu.setLayout(btn_data_menuLayout);
        btn_data_menuLayout.setHorizontalGroup(
            btn_data_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_data_menuLayout.setVerticalGroup(
            btn_data_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_data_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, -1));

        btn_data_meja.setBackground(new java.awt.Color(64, 43, 100));
        btn_data_meja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_data_meja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_data_mejaMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_table_25px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data Meja");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_data_mejaLayout = new javax.swing.GroupLayout(btn_data_meja);
        btn_data_meja.setLayout(btn_data_mejaLayout);
        btn_data_mejaLayout.setHorizontalGroup(
            btn_data_mejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_mejaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_data_mejaLayout.setVerticalGroup(
            btn_data_mejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_mejaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_data_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        btn_data_toko.setBackground(new java.awt.Color(64, 43, 100));
        btn_data_toko.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_data_toko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_data_tokoMousePressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_shop_25px.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data Toko");

        javax.swing.GroupLayout btn_data_tokoLayout = new javax.swing.GroupLayout(btn_data_toko);
        btn_data_toko.setLayout(btn_data_tokoLayout);
        btn_data_tokoLayout.setHorizontalGroup(
            btn_data_tokoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_tokoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        btn_data_tokoLayout.setVerticalGroup(
            btn_data_tokoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_tokoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_data_toko, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        btn_dahsboard.setBackground(new java.awt.Color(85, 65, 118));
        btn_dahsboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dahsboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_dahsboardMousePressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_25px_1.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Dashboard");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_dahsboardLayout = new javax.swing.GroupLayout(btn_dahsboard);
        btn_dahsboard.setLayout(btn_dahsboardLayout);
        btn_dahsboardLayout.setHorizontalGroup(
            btn_dahsboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dahsboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        btn_dahsboardLayout.setVerticalGroup(
            btn_dahsboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dahsboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_dahsboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        btn_data_transaksi.setBackground(new java.awt.Color(64, 43, 100));
        btn_data_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_data_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_data_transaksiMousePressed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_checkout_25px.png"))); // NOI18N

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Data Transaksi");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_data_transaksiLayout = new javax.swing.GroupLayout(btn_data_transaksi);
        btn_data_transaksi.setLayout(btn_data_transaksiLayout);
        btn_data_transaksiLayout.setHorizontalGroup(
            btn_data_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_transaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btn_data_transaksiLayout.setVerticalGroup(
            btn_data_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_data_transaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_data_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

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

        sidepane.add(btn_data_menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, -1, -1));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_baru-removebg-preview.png"))); // NOI18N
        sidepane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 70));

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
        jLabel1.setText("OVERVIEW_______________________________");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Dashboard");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_dashboard.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

        jPanel6.setBackground(new java.awt.Color(246, 246, 246));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setText("Total Transaksi");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_ticket_purchase_60px.png"))); // NOI18N

        lbl_ttransaksi.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_ttransaksi.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(lbl_ttransaksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ttransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bg_dashboard.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, 130));

        jPanel7.setBackground(new java.awt.Color(246, 246, 246));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel35.setText("Jumlah Pendapatan");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_money_bag_60px.png"))); // NOI18N

        lbl_ttpendapatan.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_ttpendapatan.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(lbl_ttpendapatan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ttpendapatan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bg_dashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 240, -1));

        jPanel8.setBackground(new java.awt.Color(246, 246, 246));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel38.setText("Jumlah Meja");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_table_60px_2.png"))); // NOI18N

        lbl_ttmeja.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_ttmeja.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(lbl_ttmeja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ttmeja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bg_dashboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 240, -1));

        cb_toko_2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_toko_2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb_toko_2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        bg_dashboard.add(cb_toko_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 170, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_shop_25px_4.png"))); // NOI18N
        bg_dashboard.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 40));

        jScrollPane7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_data_transaksi_per_toko.setAutoCreateRowSorter(true);
        tbl_data_transaksi_per_toko.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data_transaksi_per_toko.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_data_transaksi_per_toko.setRowHeight(25);
        tbl_data_transaksi_per_toko.setRowMargin(5);
        tbl_data_transaksi_per_toko.setSelectionBackground(new java.awt.Color(64, 43, 100));
        tbl_data_transaksi_per_toko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data_transaksi_per_tokoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_data_transaksi_per_toko);

        bg_dashboard.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 730, 210));

        lbl_total_pendapatan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_total_pendapatan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total_pendapatan.setText("-");
        bg_dashboard.add(lbl_total_pendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 130, 40));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel37.setText("Total Pendapatan :");
        bg_dashboard.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, 40));

        btn_statistik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_statistik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_plot_25px.png"))); // NOI18N
        btn_statistik.setToolTipText("statistik penjualan");
        btn_statistik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statistikActionPerformed(evt);
            }
        });
        bg_dashboard.add(btn_statistik, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 40, 40));

        bodypane.add(bg_dashboard, "card2");

        bg_toko.setBackground(new java.awt.Color(255, 255, 255));
        bg_toko.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_toko.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(64, 43, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MANAJEMEN TOKO____________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Data Toko");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_toko.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

        txt_path.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bg_toko.add(txt_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 350, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel12.setText("Nama Toko");
        bg_toko.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cb_kategori.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "makanan", "minuman", "kue", "manisan" }));
        bg_toko.add(cb_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 180, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel13.setText("Kategori");
        bg_toko.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_data_toko.setAutoCreateRowSorter(true);
        tbl_data_toko.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data_toko.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_data_toko.setRowHeight(25);
        tbl_data_toko.setRowMargin(5);
        tbl_data_toko.setSelectionBackground(new java.awt.Color(64, 43, 100));
        tbl_data_toko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data_tokoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_data_toko);

        bg_toko.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 740, 260));

        JDekstopPane.setLayer(bg_profil_toko, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDekstopPaneLayout = new javax.swing.GroupLayout(JDekstopPane);
        JDekstopPane.setLayout(JDekstopPaneLayout);
        JDekstopPaneLayout.setHorizontalGroup(
            JDekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
            .addGroup(JDekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JDekstopPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg_profil_toko, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        JDekstopPaneLayout.setVerticalGroup(
            JDekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
            .addGroup(JDekstopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JDekstopPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg_profil_toko, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bg_toko.add(JDekstopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 170, 140));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_20px.png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        bg_toko.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 130, 40));

        btn_upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_upload_20px.png"))); // NOI18N
        btn_upload.setText("Upload");
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });
        bg_toko.add(btn_upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 130, 40));

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_20px.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        bg_toko.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 130, 40));

        txt_nama_toko.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nama_toko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_tokoActionPerformed(evt);
            }
        });
        bg_toko.add(txt_nama_toko, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 40));

        btn_tambah_menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_25px_1.png"))); // NOI18N
        btn_tambah_menu1.setText("Tambah");
        btn_tambah_menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_menu1ActionPerformed(evt);
            }
        });
        bg_toko.add(btn_tambah_menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 130, 40));

        bodypane.add(bg_toko, "card3");

        bg_transaksi.setBackground(new java.awt.Color(255, 255, 255));
        bg_transaksi.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_transaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(64, 43, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TRANSAKSI PENJUALAN____________________");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Data Transaksi");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_transaksi.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_transaksi.setAutoCreateRowSorter(true);
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NO MEJA", "MENU", "TOTAL", "TANGGAL"
            }
        ));
        tbl_transaksi.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setRowHeight(25);
        tbl_transaksi.setRowMargin(5);
        tbl_transaksi.setSelectionBackground(new java.awt.Color(64, 43, 100));
        jScrollPane3.setViewportView(tbl_transaksi);
        if (tbl_transaksi.getColumnModel().getColumnCount() > 0) {
            tbl_transaksi.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbl_transaksi.getColumnModel().getColumn(1).setPreferredWidth(40);
        }

        bg_transaksi.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 740, 300));

        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_print_20px.png"))); // NOI18N
        btn_cetak.setText("Cetak Laporan");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        bg_transaksi.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 160, 40));

        btn_rekap1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_sync_25px.png"))); // NOI18N
        btn_rekap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rekap1ActionPerformed(evt);
            }
        });
        bg_transaksi.add(btn_rekap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 60, 40));

        dc_tanggal_sampai.setToolTipText("range - sampai");
        dc_tanggal_sampai.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dc_tanggal_sampaiPropertyChange(evt);
            }
        });
        bg_transaksi.add(dc_tanggal_sampai, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 190, 40));

        dc_tanggal_dari.setToolTipText("range - dari");
        dc_tanggal_dari.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dc_tanggal_dariPropertyChange(evt);
            }
        });
        bg_transaksi.add(dc_tanggal_dari, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 180, 40));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_width_25px.png"))); // NOI18N
        jLabel40.setToolTipText("range");
        bg_transaksi.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        btn_rekap_range.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_filter_20px.png"))); // NOI18N
        btn_rekap_range.setText("Rekap");
        btn_rekap_range.setToolTipText("rekap range data");
        btn_rekap_range.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rekap_rangeActionPerformed(evt);
            }
        });
        bg_transaksi.add(btn_rekap_range, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 110, 40));

        lbl_total_rekap_transaksi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total_rekap_transaksi.setText("-");
        bg_transaksi.add(lbl_total_rekap_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 40, 40));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setText("Total Transaksi :");
        bg_transaksi.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 40));

        bodypane.add(bg_transaksi, "card4");

        bg_meja.setBackground(new java.awt.Color(255, 255, 255));
        bg_meja.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_meja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(64, 43, 100));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MANAJEMEN DATA MEJA____________________");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Data Meja");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_meja.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_data_meja.setAutoCreateRowSorter(true);
        tbl_data_meja.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data_meja.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_data_meja.setRowHeight(25);
        tbl_data_meja.setRowMargin(5);
        tbl_data_meja.setSelectionBackground(new java.awt.Color(64, 43, 100));
        tbl_data_meja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data_mejaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_data_meja);

        bg_meja.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 740, 260));

        btn_edit_meja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_20px.png"))); // NOI18N
        btn_edit_meja.setText("Edit");
        btn_edit_meja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_mejaActionPerformed(evt);
            }
        });
        bg_meja.add(btn_edit_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 130, 40));

        btn_hapus_meja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_20px.png"))); // NOI18N
        btn_hapus_meja.setText("Hapus");
        btn_hapus_meja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_mejaActionPerformed(evt);
            }
        });
        bg_meja.add(btn_hapus_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 100, 40));

        txt_no_meja.setEditable(false);
        txt_no_meja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bg_meja.add(txt_no_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel21.setText("Status");
        bg_meja.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel22.setText("No Meja");
        bg_meja.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cb_status_meja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "available", "not available" }));
        bg_meja.add(cb_status_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 180, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("Jumlah Meja :");
        bg_meja.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        lbl_jumlah_meja.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_jumlah_meja.setText("Jumlah Meja :");
        bg_meja.add(lbl_jumlah_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        btn_tambah_meja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_25px_1.png"))); // NOI18N
        btn_tambah_meja.setText("Tambah");
        btn_tambah_meja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_mejaActionPerformed(evt);
            }
        });
        bg_meja.add(btn_tambah_meja, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 130, 40));

        bodypane.add(bg_meja, "card2");

        bg_menu.setBackground(new java.awt.Color(255, 255, 255));
        bg_menu.setPreferredSize(new java.awt.Dimension(1100, 630));
        bg_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(64, 43, 100));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("MANAJEMEN DATA MENU____________________");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Data Menu");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        bg_menu.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 127));

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

        bg_menu.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 740, 200));

        btn_tambah_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_25px_1.png"))); // NOI18N
        btn_tambah_menu.setText("Tambah");
        btn_tambah_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_menuActionPerformed(evt);
            }
        });
        bg_menu.add(btn_tambah_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 130, 40));

        btn_hapus_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_20px.png"))); // NOI18N
        btn_hapus_menu.setText("Hapus");
        btn_hapus_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_menuActionPerformed(evt);
            }
        });
        bg_menu.add(btn_hapus_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 120, 40));

        txt_nama_menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nama_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_menuActionPerformed(evt);
            }
        });
        bg_menu.add(txt_nama_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel27.setText("Toko");
        bg_menu.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel28.setText("Nama Menu");
        bg_menu.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cb_nama_toko.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb_nama_tokoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        bg_menu.add(cb_nama_toko, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 180, 40));

        btn_edit_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_20px.png"))); // NOI18N
        btn_edit_menu.setText("Edit");
        btn_edit_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_menuActionPerformed(evt);
            }
        });
        bg_menu.add(btn_edit_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 130, 40));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel29.setText("Kategori");
        bg_menu.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        cb_kategori_menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "makanan", "minuman", "kue", "manisan" }));
        bg_menu.add(cb_kategori_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 180, 40));

        txt_harga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });
        bg_menu.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 140, 40));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel30.setText("Harga");
        bg_menu.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 80, -1));

        JDekstopPane1.setLayer(bg_profil_menu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDekstopPane1Layout = new javax.swing.GroupLayout(JDekstopPane1);
        JDekstopPane1.setLayout(JDekstopPane1Layout);
        JDekstopPane1Layout.setHorizontalGroup(
            JDekstopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDekstopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bg_profil_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JDekstopPane1Layout.setVerticalGroup(
            JDekstopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDekstopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bg_profil_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg_menu.add(JDekstopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 110, 100));

        btn_upload_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_upload_20px.png"))); // NOI18N
        btn_upload_menu.setText("Upload");
        btn_upload_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upload_menuActionPerformed(evt);
            }
        });
        bg_menu.add(btn_upload_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 130, 40));

        txt_path_menu.setEditable(false);
        txt_path_menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bg_menu.add(txt_path_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 540, 40));

        bodypane.add(bg_menu, "card2");

        main.add(bodypane, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 630));

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_data_mejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_data_mejaMousePressed
        // TODO add your handling code here:
        setColor(btn_data_meja);
        resetColor(btn_data_toko);
        resetColor(btn_dahsboard);
        resetColor(btn_data_transaksi);
        resetColor(btn_data_menu);

        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_meja);
        bodypane.repaint();
        bodypane.revalidate();

    }//GEN-LAST:event_btn_data_mejaMousePressed

    private void btn_data_tokoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_data_tokoMousePressed
        setColor(btn_data_toko);
        resetColor(btn_dahsboard);
        resetColor(btn_data_meja);
        resetColor(btn_data_transaksi);
        resetColor(btn_data_menu);
        loadDataToko();
        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_toko);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_data_tokoMousePressed

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        ImageIcon img = new ImageIcon(f.toString());
        Image tempImg = img.getImage();
        Image modImg = tempImg.getScaledInstance(bg_profil_toko.getWidth(), bg_profil_toko.getHeight(), Image.SCALE_SMOOTH);
        img = new ImageIcon(modImg);
        bg_profil_toko.setIcon(img);
        filename = f.getAbsolutePath();
        txt_path.setText(filename);

        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            photo = bos.toByteArray();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_uploadActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "update toko set nama_toko = ?, kategori=?, foto_toko=? where id_toko=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_nama_toko.getText());
            pst.setString(2, cb_kategori.getSelectedItem().toString());
            pst.setBytes(3, photo);
            pst.setString(4, txt_id_toko.getText());
            pst.execute();
            JOptionPane.showMessageDialog(this, "Update informasi toko berhasil!");
            loadDataToko();
            id_toko_otomatis();
            resetFieldToko();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btn_editActionPerformed

    private void tbl_data_tokoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_tokoMouseClicked
        // TODO add your handling code here:
        int i = tbl_data_toko.getSelectedRow();
        txt_id_toko.setText(model.getValueAt(i, 0).toString());
        try {
            String nama_toko = model.getValueAt(i, 1).toString();
            String sql = "select * from toko where nama_toko ='" + nama_toko + "'";
            Statement st = conn.createStatement();
            res = st.executeQuery(sql);
            if (res.next()) {
                txt_id_toko.setText(res.getString("id_toko"));
                txt_nama_toko.setText(res.getString("nama_toko"));
                cb_kategori.setSelectedItem(res.getString("kategori"));
            } else {
                System.out.println("tidak ada data!");
            }

        } catch (SQLException e) {
            System.out.println("tidak ada data!");
        }
        try {
            String id_toko = (String) model.getValueAt(i, 0);
            String sql = "select foto_toko from toko where id_toko='" + id_toko + "'";
            Statement st = conn.createStatement();
            res = st.executeQuery(sql);
            if (res.next()) {
                byte[] img = res.getBytes("foto_toko");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImage = im.getScaledInstance(bg_profil_toko.getWidth(), bg_profil_toko.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImage);
                bg_profil_toko.setIcon(newImage);
            } else {
                System.out.println("tidak ada data!");
            }
        } catch (SQLException e) {
            System.out.println("tidak ada data!");
        }
    }//GEN-LAST:event_tbl_data_tokoMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(null,
                "Apakah kamu yakin ?", "Hati Hati!", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            try {
                String sql = "delete from toko where id_toko='" + txt_id_toko.getText() + "'";
                Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Hapus data berhasil!");
                loadDataToko();
                id_toko_otomatis();
                resetFieldToko();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Hapus data gagal!");
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_dahsboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dahsboardMousePressed
        // TODO add your handling code here:
        setColor(btn_dahsboard);
        resetColor(btn_data_toko);
        resetColor(btn_data_meja);
        resetColor(btn_data_transaksi);
        resetColor(btn_data_menu);
        loadDataToko();
        loadBadge();
        loadDataTransaksi();
        loadDataMenu();

        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_dashboard);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_dahsboardMousePressed

    private void btn_data_transaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_data_transaksiMousePressed
        // TODO add your handling code here:
        setColor(btn_data_transaksi);
        resetColor(btn_data_toko);
        resetColor(btn_dahsboard);
        resetColor(btn_data_meja);
        resetColor(btn_data_menu);

        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_transaksi);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_data_transaksiMousePressed

    private void tbl_data_mejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_mejaMouseClicked
        // TODO add your handling code here:
        int i = tbl_data_meja.getSelectedRow();
        txt_no_meja.setText(modelMeja.getValueAt(i, 0).toString());
        cb_status_meja.setSelectedItem(modelMeja.getValueAt(i, 1));
        txt_no_meja.setEditable(false);
    }//GEN-LAST:event_tbl_data_mejaMouseClicked

    private void btn_edit_mejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_mejaActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "update meja set status=? where id_meja=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, cb_status_meja.getSelectedItem().toString());
            pst.setInt(2, Integer.parseInt(txt_no_meja.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Edit data berhasil!");
            loadDataMeja();
            txt_no_meja.setEditable(true);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "edit data gagal!" + e.getMessage());
        }
    }//GEN-LAST:event_btn_edit_mejaActionPerformed

    private void btn_hapus_mejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_mejaActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(null,
                "Apakah kamu yakin ?", "Hati Hati!", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            try {
                String sql = "delete from meja where id_meja='" + txt_no_meja.getText() + "'";
                Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Hapus data berhasil!");
                loadDataMeja();
                txt_no_meja.setEditable(true);
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Hapus data gagal!");
                System.err.println(e.getMessage());
                txt_no_meja.setEditable(true);
            }
        }
    }//GEN-LAST:event_btn_hapus_mejaActionPerformed

    private void btn_data_menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_data_menuMousePressed
        // TODO add your handling code here:
        setColor(btn_data_menu);
        resetColor(btn_data_toko);
        resetColor(btn_dahsboard);
        resetColor(btn_data_transaksi);
        resetColor(btn_data_meja);
        loadDataMenu();
        loadDataNamaToko();
        // panel
        bodypane.removeAll();
        bodypane.repaint();
        bodypane.revalidate();

        bodypane.add(bg_menu);
        bodypane.repaint();
        bodypane.revalidate();
    }//GEN-LAST:event_btn_data_menuMousePressed

    private void tbl_data_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_menuMouseClicked
        // TODO add your handling code here:
        int i = tbl_data_menu.getSelectedRow();
        String nama_menu = modelMenu.getValueAt(i, 1).toString();
        try {
            String sql = "select * from menu where nama_menu ='" + nama_menu + "'";
            Statement st = conn.createStatement();
            res = st.executeQuery(sql);
            if (res.next()) {
                txt_id_menu.setText(res.getString("id_menu"));
                txt_nama_menu.setText(res.getString("nama_menu"));
                cb_kategori_menu.setSelectedItem(res.getString("kategori"));
                txt_harga.setText(res.getString("harga"));
//                System.out.println(txt_id_menu.getText());
            } else {
                System.out.println("tidak ada data!");
            }

        } catch (SQLException e) {
            System.out.println("tidak ada data!");
        }
        try {
            String sql = "select nama_toko from toko where id_toko='" + modelMenu.getValueAt(i, 0) + "'";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                cb_nama_toko.setSelectedItem(res.getString("nama_toko"));
            }
        } catch (Exception e) {
        }
        try {
            String sql = "select foto_menu from menu where nama_menu='" + nama_menu + "'";
            Statement st = conn.createStatement();
            res = st.executeQuery(sql);
            if (res.next()) {
                byte[] img = res.getBytes("foto_menu");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImage = im.getScaledInstance(bg_profil_menu.getWidth(), bg_profil_menu.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImage);
                bg_profil_menu.setIcon(newImage);
            } else {
                System.out.println("tidak ada data!");
            }
        } catch (SQLException e) {
            System.out.println("tidak ada data!");
        }
    }//GEN-LAST:event_tbl_data_menuMouseClicked

    private void btn_tambah_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_menuActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "insert into menu(nama_menu, id_toko, kategori, harga, foto_menu) "
                    + "values(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_nama_menu.getText());
            pst.setString(2, id_toko);
            pst.setString(3, cb_kategori_menu.getSelectedItem().toString());
            pst.setString(4, txt_harga.getText());
            pst.setBytes(5, photo);

            pst.execute();
            JOptionPane.showMessageDialog(this, "Insert informasi toko berhasil!");
            refreshMenu();
            loadDataMenu();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_tambah_menuActionPerformed

    private void btn_hapus_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_menuActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Apakah kamu yakin ? ", "Peringatan!", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            // TODO add your handling code here:
            try {
                String sql = "delete from menu where id_menu = '" + txt_id_menu.getText() + "'";
                Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Insert informasi menu berhasil!");
                refreshMenu();
                loadDataMenu();
            } catch (HeadlessException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_hapus_menuActionPerformed

    private void txt_nama_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_menuActionPerformed

    private void btn_edit_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_menuActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "update menu set id_toko = ?, nama_menu = ?, kategori=?, foto_menu=? where id_menu=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_toko);
            pst.setString(2, txt_nama_menu.getText());
            pst.setString(3, cb_kategori.getSelectedItem().toString());
            pst.setBytes(4, photo);
            pst.setString(5, txt_id_menu.getText());

            pst.execute();
            JOptionPane.showMessageDialog(this, "Update informasi menu berhasil!");
            loadDataMenu();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_edit_menuActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void btn_upload_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upload_menuActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        ImageIcon img = new ImageIcon(f.toString());
        Image tempImg = img.getImage();
        Image modImg = tempImg.getScaledInstance(bg_profil_menu.getWidth(), bg_profil_menu.getHeight(), Image.SCALE_SMOOTH);
        img = new ImageIcon(modImg);
        bg_profil_menu.setIcon(img);
        filename1 = f.getAbsolutePath();
        txt_path_menu.setText(filename1);

        try {
            File image = new File(filename1);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            photo = bos.toByteArray();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_upload_menuActionPerformed

    private void txt_nama_tokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_tokoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_tokoActionPerformed

    private void btn_tambah_mejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_mejaActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "insert into meja (meja, status) values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txt_no_meja.getText()));
            pst.setString(2, cb_status_meja.getSelectedItem().toString());

            pst.execute();
            JOptionPane.showMessageDialog(this, "Tambah data meja berhasil!");
            loadDataMeja();
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Tambah data meja gagal!" + e.getMessage());
        }
    }//GEN-LAST:event_btn_tambah_mejaActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        if (dc_tanggal_dari.getDate() == null || dc_tanggal_sampai.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Isi range tanggal terlebih dahulu");
        } else {
            try {
                JasperReport jr;
                JasperPrint jp;
                JasperDesign jd;
                jd = JRXmlLoader.load("C:\\Users\\ibnua\\Documents\\NetBeansProjects\\penjualan fiks\\src\\report\\rekapPenjualan.jrxml");
                String sql = "SELECT detailtransaksi.id_detailTransaksi, transaksi.nama_pembeli, "
                + "toko.nama_toko, menu.nama_menu, detailtransaksi.jumlah, "
                + "detailtransaksi.total_bayar, transaksi.tgl_transaksi "
                + "FROM detailtransaksi, transaksi, toko, menu "
                + "WHERE (transaksi.tgl_transaksi BETWEEN '"+tanggal_dari+"' AND '"+tanggal_sampai+"' ) "
                + "AND detailtransaksi.id_detailTransaksi = transaksi.id_transaksi "
                + "AND detailtransaksi.id_toko = toko.id_toko "
                + "AND detailtransaksi.id_menu = menu.id_menu";
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                jr = JasperCompileManager.compileReport(jd);
                jp = JasperFillManager.fillReport(jr, null, conn);
                JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cetakActionPerformed
    private String tanggal_rekap;
    private void btn_rekap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rekap1ActionPerformed
        // TODO add your handling code here:
        loadDataTransaksi();
        dc_tanggal_dari.setCalendar(null);
        dc_tanggal_sampai.setCalendar(null);
    }//GEN-LAST:event_btn_rekap1ActionPerformed

    private void cb_toko_2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_toko_2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        modelTransaksiToko.getDataVector().removeAllElements();
        modelTransaksiToko.fireTableDataChanged();
        String namaToko = cb_toko_2.getSelectedItem().toString();
        String id_toko_2 = "";
        try {
            String sql = "select id_toko from toko where nama_toko='" + cb_toko_2.getSelectedItem().toString() + "'";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                id_toko_2 = res.getString("id_toko");
            }
        } catch (SQLException e) {
        }

        try {
            String sql = "SELECT transaksi.nama_pembeli as 'nama_pembeli', menu.nama_menu, detailtransaksi.jumlah, "
                    + "detailtransaksi.total_bayar, transaksi.tgl_transaksi FROM detailtransaksi, transaksi, toko, menu "
                    + "WHERE detailtransaksi.id_toko = '" + id_toko_2 + "' "
                    + "AND detailtransaksi.id_toko = toko.id_toko "
                    + "AND detailtransaksi.id_menu = menu.id_menu "
                    + "AND detailtransaksi.id_detailTransaksi = transaksi.id_transaksi;";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {
                Object[] o = new Object[5];
                o[0] = res.getString("nama_pembeli");
                o[1] = res.getString("nama_menu");
                o[2] = res.getString("jumlah");
                o[3] = res.getString("total_bayar");
                o[4] = res.getString("tgl_transaksi");
                modelTransaksiToko.addRow(o);
            }
        } catch (SQLException e) {
            modelTransaksiToko.getDataVector().removeAllElements();
            modelTransaksiToko.fireTableDataChanged();
            Object[] o = new Object[1];
            o[0] = "tidak ada data";
            modelTransaksiToko.addRow(o);
            System.out.println("tidak ada data");
            System.out.println(e.getMessage());
        }

        try {
            String sql = "SELECT SUM(detailtransaksi.total_bayar) as 'total' FROM detailtransaksi, transaksi, toko, menu "
                    + "WHERE detailtransaksi.id_toko = '" + id_toko_2 + "' "
                    + "AND detailtransaksi.id_toko = toko.id_toko "
                    + "AND detailtransaksi.id_menu = menu.id_menu "
                    + "AND detailtransaksi.id_detailTransaksi = transaksi.id_transaksi;";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                lbl_total_pendapatan.setText(res.getString("total"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cb_toko_2PopupMenuWillBecomeInvisible

    private void tbl_data_transaksi_per_tokoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_transaksi_per_tokoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_data_transaksi_per_tokoMouseClicked

    private void dc_tanggal_sampaiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dc_tanggal_sampaiPropertyChange
        // TODO add your handling code here:
        try {
            if (dc_tanggal_sampai.getDate() != null) {
                String pattern = "dd/MM/yyyy";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                tanggal_sampai = String.valueOf(format.format(dc_tanggal_sampai.getDate()));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_dc_tanggal_sampaiPropertyChange

    private void dc_tanggal_dariPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dc_tanggal_dariPropertyChange
        // TODO add your handling code here:
        try {
            if (dc_tanggal_dari.getDate() != null) {
                String pattern = "dd/MM/yyyy";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                tanggal_dari = String.valueOf(format.format(dc_tanggal_dari.getDate()));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_dc_tanggal_dariPropertyChange

    private void btn_rekap_rangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rekap_rangeActionPerformed
        // TODO add your handling code here:
        System.out.println(tanggal_dari);
        System.out.println(tanggal_sampai);
        String sql = "SELECT detailtransaksi.id_detailTransaksi, transaksi.nama_pembeli, "
                + "toko.nama_toko, menu.nama_menu, detailtransaksi.jumlah, "
                + "detailtransaksi.total_bayar, transaksi.tgl_transaksi "
                + "FROM detailtransaksi, transaksi, toko, menu "
                + "WHERE (transaksi.tgl_transaksi BETWEEN '"+tanggal_dari+"' AND '"+tanggal_sampai+"' ) "
                + "AND detailtransaksi.id_detailTransaksi = transaksi.id_transaksi "
                + "AND detailtransaksi.id_toko = toko.id_toko "
                + "AND detailtransaksi.id_menu = menu.id_menu;";
        modelTransaksi.getDataVector().removeAllElements();
        modelTransaksi.fireTableDataChanged();
        if (dc_tanggal_dari.getDate() == null && dc_tanggal_sampai.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Isi tanggal terlebih dahulu");
        } else {
            try {
                Statement stat = conn.prepareStatement(sql);
                res = stat.executeQuery(sql);
                while (res.next()) {
                    Object[] o = new Object[7];
                    o[0] = res.getString("id_detailTransaksi");
                    o[1] = res.getString("nama_pembeli");
                    o[2] = res.getString("nama_toko");
                    o[3] = res.getString("nama_menu");
                    o[4] = res.getString("jumlah");
                    o[5] = res.getString("total_bayar");
                    o[6] = res.getString("tgl_transaksi");
                    modelTransaksi.addRow(o);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Tidak ada data");
                System.out.println(e.getMessage());
            }
        }
        lbl_total_rekap_transaksi.setText(String.valueOf(modelTransaksi.getRowCount()));
    }//GEN-LAST:event_btn_rekap_rangeActionPerformed

    private void btn_data_menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_data_menu1MousePressed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Apakah kamu ingin keluar ?", "Mau kemana", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            new Login().show();
            this.dispose();
        }
    }//GEN-LAST:event_btn_data_menu1MousePressed

    private void btn_statistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statistikActionPerformed
        // TODO add your handling code here:
        try {
            String query = "SELECT transaksi.tgl_transaksi as 'tgl_transaksi', COUNT(detailtransaksi.id_detailTransaksi) "
                    + "as 'total' FROM detailtransaksi, transaksi "
                    + "WHERE detailtransaksi.id_detailTransaksi = transaksi.id_transaksi "
                    + "GROUP BY transaksi.id_transaksi;";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
            JFreeChart chart = ChartFactory.createBarChart("Statistik", "Tanggal Transaksi", "Total Transaksi", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Statistik Penjualan", chart);
            frame.setVisible(true);
            frame.pack();
            setLocationRelativeTo(null);
            frame.setSize(1060, 630);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_statistikActionPerformed
    private static String kode_toko, kode;

    private void id_toko_otomatis() {
        String sql = "select * from toko order by id_toko desc";
        try {
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                kode = res.getString("id_toko").substring(1);
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

                kode_toko = "T" + nol + autoNumber;
                System.out.println(kode_toko);
            } else {
                kode_toko = "T001";
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("tidak ada data yang masuk");
            System.out.println(e.getMessage());
        }
    }

    private void resetFieldToko() {
        txt_nama_toko.setText("");
        cb_kategori.setSelectedIndex(0);
        txt_path.setText("");
        bg_profil_toko.setText(null);
    }

    private void btn_tambah_menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_menu1ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "insert into toko(id_toko, nama_toko, kategori, foto_toko) "
                    + "values(?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, kode_toko);
            pst.setString(2, txt_nama_toko.getText());
            pst.setString(3, cb_kategori.getSelectedItem().toString());
            pst.setBytes(4, photo);

            pst.execute();
            loadDataToko();
            resetFieldToko();
            JOptionPane.showMessageDialog(this, "Insert informasi toko berhasil!");
            refreshMenu();
            loadDataMenu();
            id_toko_otomatis();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_tambah_menu1ActionPerformed

    private void cb_nama_tokoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_nama_tokoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try {
            String sql = "select id_toko from toko where nama_toko='"
                    + cb_nama_toko.getSelectedItem().toString() + "'";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                id_toko = res.getString("id_toko");
                System.out.println(id_toko);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cb_nama_tokoPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(Admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDekstopPane;
    private javax.swing.JDesktopPane JDekstopPane1;
    private javax.swing.JPanel bg_dashboard;
    private javax.swing.JPanel bg_meja;
    private javax.swing.JPanel bg_menu;
    private javax.swing.JLabel bg_profil_menu;
    private javax.swing.JLabel bg_profil_toko;
    private javax.swing.JPanel bg_toko;
    private javax.swing.JPanel bg_transaksi;
    private javax.swing.JPanel bodypane;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JPanel btn_dahsboard;
    private javax.swing.JPanel btn_data_meja;
    private javax.swing.JPanel btn_data_menu;
    private javax.swing.JPanel btn_data_menu1;
    private javax.swing.JPanel btn_data_toko;
    private javax.swing.JPanel btn_data_transaksi;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_edit_meja;
    private javax.swing.JButton btn_edit_menu;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hapus_meja;
    private javax.swing.JButton btn_hapus_menu;
    private javax.swing.JButton btn_rekap1;
    private javax.swing.JButton btn_rekap_range;
    private javax.swing.JButton btn_statistik;
    private javax.swing.JButton btn_tambah_meja;
    private javax.swing.JButton btn_tambah_menu;
    private javax.swing.JButton btn_tambah_menu1;
    private javax.swing.JButton btn_upload;
    private javax.swing.JButton btn_upload_menu;
    private javax.swing.JComboBox<String> cb_kategori;
    private javax.swing.JComboBox<String> cb_kategori_menu;
    private javax.swing.JComboBox<String> cb_nama_toko;
    private javax.swing.JComboBox<String> cb_status_meja;
    private javax.swing.JComboBox<String> cb_toko_2;
    private com.toedter.calendar.JDateChooser dc_tanggal_dari;
    private com.toedter.calendar.JDateChooser dc_tanggal_sampai;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbl_jumlah_meja;
    private javax.swing.JLabel lbl_total_pendapatan;
    private javax.swing.JLabel lbl_total_rekap_transaksi;
    private javax.swing.JLabel lbl_ttmeja;
    private javax.swing.JLabel lbl_ttpendapatan;
    private javax.swing.JLabel lbl_ttransaksi;
    private javax.swing.JPanel main;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTable tbl_data_meja;
    private javax.swing.JTable tbl_data_menu;
    private javax.swing.JTable tbl_data_toko;
    private javax.swing.JTable tbl_data_transaksi_per_toko;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id_menu;
    private javax.swing.JTextField txt_id_toko;
    private javax.swing.JTextField txt_nama_menu;
    private javax.swing.JTextField txt_nama_toko;
    private javax.swing.JTextField txt_no_meja;
    private javax.swing.JTextField txt_path;
    private javax.swing.JTextField txt_path_menu;
    // End of variables declaration//GEN-END:variables

    // filed for photo
    byte[] photo = null;
    String filename = null;
    String filename1 = null;

    void setColor(JPanel panel) {
        panel.setBackground(new Color(85, 64, 118));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));
    }

    // get Data Tabel Menu
    public void loadDataMenu() {
        _Menu.MyQueryMenu mq = new MyQueryMenu();
        ArrayList<Menu> list = mq.BindTable();
        String[] columnName = {"ID Toko", "Nama Menu", "Kategori", "Harga", "Foto"};
        Object[][] rows = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getIdToko();
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

    // get Data Tabel Toko
    public void loadDataToko() {
        _Toko.MyQuery mq = new MyQuery();
        ArrayList<Toko> list = mq.BindTable();
        String[] columnName = {"Id", "Nama", "Kategori", "Foto"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getCategory();

            if (list.get(i).getMyImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
                        .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

                rows[i][3] = image;
            } else {
                rows[i][3] = null;
            }
        }

        model = new TheModel(rows, columnName);
        tbl_data_toko.setModel(model);
        tbl_data_toko.setRowHeight(120);
        tbl_data_toko.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    // get data Table meja
    private void loadDataMeja() {
        modelMeja.getDataVector().removeAllElements();
        modelMeja.fireTableDataChanged();
        try {
            String sql = "select * from meja";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] o = new Object[2];
                o[0] = res.getString("meja");
                o[1] = res.getString("status");
                modelMeja.addRow(o);
            }

            lbl_jumlah_meja.setText(String.valueOf(tbl_data_meja.getRowCount()));
        } catch (SQLException e) {
            System.out.println("tidak ada data!");
        }
    }

    // get data combo box nama toko
    private void loadDataNamaToko() {
        try {
            String sql = "select * from toko";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            cb_nama_toko.removeAllItems();
            cb_toko_2.removeAllItems();
            while (res.next()) {
                cb_nama_toko.addItem(res.getString("nama_toko"));
                cb_toko_2.addItem(res.getString("nama_toko"));
            }
        } catch (SQLException e) {
            System.out.println("tidak ada dataa");
        }
    }

    // menghilangkan field menu
    private void refreshMenu() {
        txt_nama_menu.setText("");
        txt_harga.setText("");
        cb_nama_toko.setSelectedIndex(0);
        cb_kategori_menu.setSelectedIndex(0);
        txt_path_menu.setText("");
    }

    private void loadBadge() {
        // load total order
        try {
            String sql = "SELECT COUNT(DISTINCT id_transaksi) as 'total' FROM transaksi";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                lbl_ttransaksi.setText(String.valueOf(res.getString("total")));
            }
        } catch (SQLException e) {
            System.out.println("tidak ada yang order");
            System.out.println(e.getMessage());
        }
        // load total expenses
        try {
            String sql = "SELECT SUM(total_bayar) as 'total' FROM `transaksi`";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                lbl_ttpendapatan.setText(String.valueOf(res.getString("total")));
            }
        } catch (SQLException e) {
            System.out.println("tidak ada yang order");
            System.out.println(e.getMessage());
        }
        // load jumlah meja
        try {
            String sql = "SELECT COUNT(*) as 'total' FROM `meja`";
            Statement stat = conn.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                lbl_ttmeja.setText(String.valueOf(res.getString("total")));
            }
        } catch (SQLException e) {
            System.out.println("tidak ada yang order");
            System.out.println(e.getMessage());
        }

    }
}
