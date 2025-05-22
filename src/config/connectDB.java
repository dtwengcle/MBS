package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {
    private static Connection connect;
    
    public connectDB(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/deguma", "root", "");
        } 
        catch (SQLException ex) {
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
    
    public int InsertData(String sql){
        int result;
        try{
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully! ");
            pst.close();
            result = 1;
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);
            result = 0;
        }
        return result;
    }

    public PreparedStatement prepareStatement(String checkSql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean executeQuery(String query, Object... values) {
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]); // Set values dynamically
            }
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Returns true if the execution was successful
        } catch (SQLException e) {
            System.out.println("Execution failed: " + e.getMessage());
            e.printStackTrace();
            return false;
      
        }
        
        
    }

    
    
}
