/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import drone.Errors;

/**
 *
 * @author OMOLARA A
 */
public class DatabaseHandler {
    
    static public final String DRIVER = "com.mysql.jdbc.Driver";
    static public final String DATABASE = "jdbc:mysql://localhost:3306/drone";
    static public final String UR = "root";
    static public final String PR = "root";
    
    public static void insert(javax.swing.JFrame frame, String sql) {
        java.sql.Connection connection = null;
        //String sql = "INSERT INTO expertdata VALUES('"+id+"', '"+name+"', '"+designation+"', '"+numYears+"', '"+date+"', '"+time+"')";
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(DATABASE, UR, PR);
            connection.createStatement().executeUpdate(sql);
        } catch(Exception e) {
            Errors.saveError(frame);
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                Errors.sqlError(frame);
            }
        }
    }
    
    public static int fetchTotal(javax.swing.JFrame frame, String sessionName) {
        int id = 0;
        java.sql.ResultSet rs = null;
        java.sql.Connection connection = null;
        String sql = "SELECT total FROM totals WHERE name = '"+sessionName+"'";
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(DATABASE, UR, PR);
            rs = connection.createStatement().executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("total");
            }
            rs.close();
        } catch(Exception e) {
            Errors.saveError(frame);
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                Errors.sqlError(frame);
            }
        }
        return id;
    }
    
    public static void updateTotal(javax.swing.JFrame frame, String sessionName, int total) {
        java.sql.Connection connection = null;
        //String sql = "SELECT id FROM totals WHERE name = '"+sessionName+"'";
        String sql = "UPDATE totals SET total = '"+total+"' WHERE name = '"+sessionName+"'";
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(DATABASE, UR, PR);
            connection.createStatement().executeUpdate(sql);
        } catch(Exception e) {
            Errors.saveError(frame);
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                Errors.sqlError(frame);
            }
        }
    }
    
    public static void insertSoftware(javax.swing.JFrame frame, String sql) {
        java.sql.Connection connection = null;
        //String sql = "INSERT INTO expertdata VALUES('"+id+"', '"+name+"', '"+designation+"', '"+numYears+"', '"+date+"', '"+time+"')";
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(DATABASE, UR, PR);
            connection.createStatement().executeUpdate(sql);
        } catch(Exception e) {
            Errors.saveError(frame);
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                Errors.sqlError(frame);
            }
        }
    }
    
    public static int getCount(String tbl_name) {
        int num_rows = 0;
        java.sql.ResultSet rs = null;
        java.sql.Connection connection = null;
        String sql = "SELECT COUNT(*) FROM "+tbl_name+"";
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(DATABASE, UR, PR);
            rs = connection.createStatement().executeQuery(sql);
            while(rs.next()) {
                num_rows = rs.getInt(1);
            }
            rs.close();
        } catch(Exception e) {
            Errors.saveError(null);
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                Errors.sqlError(null);
            }
        }
        return num_rows;
    }
    
    public static String checkName(String name) {
        String databaseName = "";
        java.sql.ResultSet rs = null;
        java.sql.Connection cnn = null;
        String sql = "SELECT name FROM acptable WHERE name = '"+name+"'";
        try {
            Class.forName(DRIVER);
            cnn = java.sql.DriverManager.getConnection(DATABASE, UR, PR);
            rs = cnn.createStatement().executeQuery(sql);
            while(rs.next()) {
                databaseName = rs.getString("name");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(cnn != null) {
                    cnn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
            }
        }
        return databaseName;
    }
}
