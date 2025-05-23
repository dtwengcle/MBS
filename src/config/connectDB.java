package config;

import java.sql.*;

public class connectDB {
    private static Connection connect;

    public connectDB() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/deguma", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connect;
    }

    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    public int InsertData(String sql) {
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex.getMessage());
            return 0;
        }
    }

    // Correctly named method for UPDATE/DELETE/INSERT
    public static boolean executeUpdate(String query, Object... values) {
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Execution failed: " + e.getMessage());
            return false;
        }
    }
}
