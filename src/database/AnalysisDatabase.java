/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author OMOLARA A
 */
public class AnalysisDatabase {
    
    public AnalysisDatabase() {
        fetchEffect("confidentiality");
    }
    
    public static double[] fetchEffect(String effect) {
        
        double value[] = new double[getCount("effectValues")];
        java.sql.ResultSet rs = null;
        java.sql.Connection cnn = null;
        String sql = "SELECT "+ effect +" FROM effectValues";
        try {
            Class.forName(DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(DatabaseHandler.DATABASE, DatabaseHandler.UR, DatabaseHandler.PR);
            rs = cnn.createStatement().executeQuery(sql);
            while(rs.next()) {
                for(int i = 0; i < value.length; i++) {
                    value[i] = rs.getDouble(i+1);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(cnn != null) {
                    cnn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
            }
        }
        return value;
    }
    
    public static double fetchEffectLast(String effect) {
        
        double value = 0.00;
        java.sql.ResultSet rs = null;
        java.sql.Connection cnn = null;
        String sql = "SELECT "+ effect +" FROM effectValues ORDER BY " + effect + " LIMIT 1, 100";
        try {
            Class.forName(DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(DatabaseHandler.DATABASE, DatabaseHandler.UR, DatabaseHandler.PR);
            rs = cnn.createStatement().executeQuery(sql);
            while(rs.next()) {
                    value = rs.getDouble(effect);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(cnn != null) {
                    cnn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
            }
        }
        return value;
    }
    
    public static int getCount(String tableName) {
        int numRows = 0;
        java.sql.ResultSet rss = null;
        java.sql.Connection cnn = null;
        String sql = "SELECT COUNT(*) FROM " + tableName;
        try {
            Class.forName(DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(DatabaseHandler.DATABASE, DatabaseHandler.UR, DatabaseHandler.PR);
            rss = cnn.createStatement().executeQuery(sql);
            while(rss.next()) {
                numRows = rss.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(cnn != null) {
                    cnn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
            }
        }
        return numRows;
    }
    
    public static String[] getAdvice(String state) {
        String[] advice;
        advice = new String[getCount("suggestions")];
        String adviceColumn;
        if(state.equalsIgnoreCase("POOR")) {
            adviceColumn = "low";
        } else if(state.equalsIgnoreCase("AVERAGE")) {
            adviceColumn = "medium";
        } else {
            adviceColumn = "high";
        }
        
        return advice;
    }
}
