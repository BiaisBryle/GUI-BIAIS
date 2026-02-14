
package config;

import java.sql.*;
import javax.swing.JTable;

/**
 *
 * @author USER6
 */
public class config {
    
    
  // Connection Method to SQLITE
    public static Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            // Ensure deliveries.db is in the main project folder
            Connection con = DriverManager.getConnection("jdbc:sqlite:deliveries.db");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Failed: " + e.getMessage());
            return null;
        }
    }

    // Static method to update JTable
    public static void displayData(String sql, JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            // This line requires rs2xml.jar in your Libraries
            table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.err.println("Error displaying data: " + e.getMessage());
        }
    }

    // Simplified Generic Method for Adding/Updating/Deleting
    public static void updateRecord(String sql, Object... values) {
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





public void addRecord(String sql, Object... values) {
    try (Connection conn = config.connectDB(); // Use the connectDB method
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Loop through the values and set them in the prepared statement dynamically
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) values[i]); // If the value is Integer
            } else if (values[i] instanceof Double) {
                pstmt.setDouble(i + 1, (Double) values[i]); // If the value is Double
            } else if (values[i] instanceof Float) {
                pstmt.setFloat(i + 1, (Float) values[i]); // If the value is Float
            } else if (values[i] instanceof Long) {
                pstmt.setLong(i + 1, (Long) values[i]); // If the value is Long
            } else if (values[i] instanceof Boolean) {
                pstmt.setBoolean(i + 1, (Boolean) values[i]); // If the value is Boolean
            } else if (values[i] instanceof java.util.Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime())); // If the value is Date
            } else if (values[i] instanceof java.sql.Date) {
                pstmt.setDate(i + 1, (java.sql.Date) values[i]); // If it's already a SQL Date
            } else if (values[i] instanceof java.sql.Timestamp) {
                pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]); // If the value is Timestamp
            } else {
                pstmt.setString(i + 1, values[i].toString()); // Default to String for other types
            }
        }

        pstmt.executeUpdate();
        System.out.println("Record added successfully!");
    } catch (SQLException e) {
        System.out.println("Error adding record: " + e.getMessage());
    }
}

    public boolean authenticate(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return true;
            }
        }
    } catch (SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
    }
    return false;
}

 

   public ResultSet getData(String sql, Object... values) throws SQLException {
    Connection conn = connectDB();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    for (int i = 0; i < values.length; i++) {
        pstmt.setObject(i + 1, values[i]);
    }
    return pstmt.executeQuery();
}


}
