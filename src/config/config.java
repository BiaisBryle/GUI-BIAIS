package config;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class config {

    // 1. CONNECTION METHOD
    public static Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:deliveries.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Failed: " + e.getMessage());
            return null;
        }
    }

    // 2. DISPLAY DATA TO JTABLE (Kini ang gi-fix para dili na ma-lock)
    public static void displayData(String sql, JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            // I-load ang data sa memorya (CachedRowSet)
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
            
            // I-set ang table model gamit ang data nga naa na sa RAM
            // Niini nga paagi, ang Connection sa DB sirado na samtang nagtan-aw ka sa table
            table.setModel(DbUtils.resultSetToTableModel(crs));
            
        } catch (Exception e) {
            System.err.println("Error displaying data: " + e.getMessage());
        }
    }

    // 3. GENERIC ADD / UPDATE / DELETE METHOD
    public void updateRecord(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            pstmt.executeUpdate();
            System.out.println("Operation Successful");
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    // 4. ALIAS METHODS
    public void addRecord(String sql, Object... values) { updateRecord(sql, values); }
    public void deleteRecord(String sql, Object... values) { updateRecord(sql, values); }

    // 5. GET DATA (Using CachedRowSet for safer reads)
    public ResultSet getData(String sql, Object... values) throws SQLException {
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }
            
            try (ResultSet rs = pstmt.executeQuery()) {
                crs.populate(rs);
            }
        }
        return crs;
    }

    // 6. AUTHENTICATE / LOGIN
    public boolean authenticate(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }

    // 7. EMAIL VALIDATION
    public boolean isEmailExisting(String email, String currentID) {
        String sql = "SELECT COUNT(*) FROM user WHERE u_email = ? AND u_id != ?";
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, email);
            pst.setString(2, (currentID == null) ? "" : currentID);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
        return false;
    }
}