
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities.helpers;


/**
 *
 * @author OMOLARA A
 */
public class PriorHelper {
    
    static public int year = 0;
    static public int num_rows = database.DatabaseHandler.getCount("expertdata");
    static public int num_rows_cause = database.DatabaseHandler.getCount("causability");    //applies to all comoponents
    static public int[] cssCollection = new int[num_rows_cause];
    static public int[] yrCollection = new int[num_rows]; 
    static public int[] csCollection = new int[num_rows_cause];
    static public int[] cyrCollection = new int[num_rows];
    static String name = drone.Drone.name;
    static double[] cpValues = new double[14];
    static double v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14;
    static String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14;
    
    public PriorHelper() throws java.io.IOException, java.sql.SQLException {
        initiate();
        System.out.println("From PriorHelper, initiate started");
        new probabilities.PosteriorDistribution();
    }
    
    static public void doTheMathYR(){
        java.sql.Connection cnn = null;
        java.sql.ResultSet rs = null;
        String query = "";
        
        try{
            Class.forName(database.DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            query = "SELECT numyears FROM expertdata ";
            rs = cnn.createStatement().executeQuery(query);
            while(rs.next()){
                for(int i = 0; i < 1; i++){
                    yrCollection[i] = rs.getInt(i+1);
                    //System.out.println(yrCollection[i]);  --working properly
                    cyrCollection[year] = yrCollection[i];  //  --working properly
                    year++;                                 //--working properly
                }
            }
            rs.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
            } catch(java.sql.SQLException sq){
                sq.printStackTrace();
            }
        }
    }
    
    static public void doTheMathCAUSE(String column_name){
        java.sql.Connection cnn = null;
        java.sql.ResultSet rs = null;
        String query = "";
        int cause = 0;
            
        try{
            Class.forName(database.DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            query = "SELECT "+column_name+" FROM causability "; //you need to change the table name from causability to components
            rs = cnn.createStatement().executeQuery(query);
            while(rs.next()){
                for(int i = 0; i < 1; i++){
                    csCollection[i] = rs.getInt(i+1);
                    cssCollection[cause] = csCollection[i];  
                    cause++;                                 
                }
            }
            rs.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
            } catch(java.sql.SQLException sq){
                sq.printStackTrace();
            }
        }
    }
    
    static public double doTheMath(int[] years, int[] cause){
        double sum = 0.0;
        int yrCounter = 0;
        int causeCounter = 0;
        double[] yrDouble = new double[years.length];
        double[] yrDoublePercent = new double[yrDouble.length];
        double[]causeDouble = new double[cause.length];
        double[] causeDoublePercent = new double[causeDouble.length];
        double[] cArray = new double[causeDouble.length];
        
        for(int i = 0; i < yrDouble.length; i++){
            yrDouble[i] = years[i];
            //System.out.println(yrDouble[i]);    working fine
            yrDoublePercent[i] = yrDouble[i] / 100;
            //System.out.println(yrDoublePercent[i]);   working fine
        }
        for(int i = 0; i < causeDouble.length; i++){
            causeDouble[i] = cause[i];
            //System.out.println(causeDouble[i]);   working fine
            causeDoublePercent[i] = causeDouble[i] / 100;
            //System.out.println(causeDoublePercent[i]);    working fine
        }
        int divisor = num_rows_cause / num_rows;
        int c = divisor;
        while(causeCounter < causeDoublePercent.length){
            cArray[causeCounter] = yrDoublePercent[yrCounter];
            if(causeCounter == c - 1){
                yrCounter = yrCounter + 1;
                divisor += 4;
                c = divisor;
            } else{
                yrCounter = yrCounter;
            }
            causeCounter++;
        }
        for(int i = 0; i < cArray.length; i++){
            //System.out.println(cArray[i]);    working fine
            sum += cArray[i] * causeDoublePercent[i];
        }
        System.out.printf("%2.2f", sum);
        return sum / 2.0;
    }
    
    static public String reduce(String str){
        return str.substring(0, 4);
    }
    
    public static void saveCPTable(double[] values) throws java.io.IOException {
        java.sql.Connection cn = null;
        String sql = "INSERT INTO conditionals VALUES('"+name+"',"
                + "'"+values[0]+"', '"+values[1]+"', '"+values[2]+"', '"+values[3]+"',"
                + " '"+values[4]+"', '"+values[5]+"', '"+values[6]+"', '"+values[7]+"',"
                + " '"+values[8]+"', '"+values[9]+"', '"+values[10]+"', '"+values[11]+"',"
                + "'"+values[12]+"', '"+values[13]+"')";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            cn.createStatement().executeUpdate(sql);
            System.out.println("From PriorHelper: conditional values saved!");
            drone.Errors.success("From PriorHelper: Prior values");
        } catch(Exception e) {
            e.printStackTrace();
            drone.Errors.failure("From PriorHelper: Prior values", cpValues);
        }
        finally {
            try {
                if(cn != null) {
                    cn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                drone.Errors.failure("From PriorHelper: Prior values", cpValues);
            }
        }
    }
    
    public static void initiate() throws java.io.IOException {
        doTheMathYR();
        System.out.println();
        doTheMathCAUSE("identity_theft");
        System.out.println();
        v1 = doTheMath(cyrCollection, cssCollection);
        s1 = String.valueOf(v1);
        System.out.println();
        doTheMathCAUSE("human_error");
        System.out.println();
        v2 = doTheMath(cyrCollection, cssCollection);
        s2 = String.valueOf(v2);
        System.out.println();
        doTheMathCAUSE("unauthorized_use");
        System.out.println();
        v3 = doTheMath(cyrCollection, cssCollection);
        s3 = String.valueOf(v3);
        System.out.println();
        doTheMathCAUSE("attack");
        System.out.println();
        v4 = doTheMath(cyrCollection, cssCollection);
        s4 = String.valueOf(v4);
        System.out.println();
        doTheMathCAUSE("data_loss");
        System.out.println();
        v5 = doTheMath(cyrCollection, cssCollection);
        s5 = String.valueOf(v5);
        System.out.println();
        doTheMathCAUSE("backup_failure");
        System.out.println();
        v6 = doTheMath(cyrCollection, cssCollection);
        s6 = String.valueOf(v6);
        System.out.println();
        doTheMathCAUSE("asset_damage");
        System.out.println();
        v7 = doTheMath(cyrCollection, cssCollection);
        s7 = String.valueOf(v7);
        System.out.println();
        doTheMathCAUSE("natural_disaster");
        System.out.println();
        v8 = doTheMath(cyrCollection, cssCollection);
        s8 = String.valueOf(v8);
        System.out.println();
        doTheMathCAUSE("operational_disruption");
        System.out.println();
        v9 = doTheMath(cyrCollection, cssCollection);
        s9 = String.valueOf(v9);
        System.out.println();
        doTheMathCAUSE("programming_bugs");
        System.out.println();
        v10 = doTheMath(cyrCollection, cssCollection);
        s10 = String.valueOf(v10);System.out.println();
        doTheMathCAUSE("power_problems");
        System.out.println();
        v11 = doTheMath(cyrCollection, cssCollection);
        s11 = String.valueOf(v11);
        System.out.println();
        doTheMathCAUSE("hack");
        System.out.println();
        v12 = doTheMath(cyrCollection, cssCollection);
        s12 = String.valueOf(v12);
        System.out.println();
        doTheMathCAUSE("virus_and_infection");
        System.out.println();
        v13 = doTheMath(cyrCollection, cssCollection);
        s13 = String.valueOf(v13);
        System.out.println();
        doTheMathCAUSE("dos_attack");
        System.out.println();
        v14 = doTheMath(cyrCollection, cssCollection);
        s14 = String.valueOf(v14);
        cpValues[0] = v1;
        cpValues[1] = v2;
        cpValues[2] = v3;
        cpValues[3] = v4;
        cpValues[4] = v5;
        cpValues[5] = v6;
        cpValues[6] = v7;
        cpValues[7] = v8;
        cpValues[8] = v9;
        cpValues[9] = v10;
        cpValues[10] = v11;
        cpValues[11] = v12;
        cpValues[12] = v13;
        cpValues[13] = v14;
        
        saveCPTable(cpValues);
    }
}
