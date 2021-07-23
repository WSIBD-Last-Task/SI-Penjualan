package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
    
    public static Connection conn;
    

    public static Connection cekKoneksi() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost/app_penjualan", "root", "");
            System.out.println("koneksi berhasil");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        cekKoneksi();
        
    }

    private static class JasperReport {

        public JasperReport() {
        }
    }

    private static class JasperPrint {

        public JasperPrint() {
        }
    }

    private static class JasperCompileManager {

        private static JasperReport compileReport(String file) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public JasperCompileManager() {
        }
    }

    private static class JasperFillManager {

        private static JasperPrint fillReport(JasperReport jr, Object object, Connection conn) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public JasperFillManager() {
        }
    }

    private static class JasperViewer {

        private static void viewReport(JasperPrint jp) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public JasperViewer() {
        }
    }
}
