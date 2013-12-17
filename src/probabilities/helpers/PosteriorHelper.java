/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities.helpers;

/**
 *
 * @author OMOLARA A
 */
public class PosteriorHelper {
    
    static String c = "confidentiality";
    static String i = "integrity";
    static String  a = "availability";
    static double itheftP = 0, itheftA = 0, humanerrorP = 0, humanerrorA = 0, unauthuseP = 0, unauthuseA = 0, attackP = 0, attackA = 0;
    static double datalossP = 0, datalossA = 0, bckfailP = 0, bckfailA = 0, assetdamageP = 0, assetdamageA = 0, naturaldisP = 0, naturaldisA = 0;
    static double opdisruptionP = 0, opdisruptionA = 0, progBugsP = 0, progBugsA = 0, powerprobP = 0, powerprobA = 0, hackP = 0, hackA = 0;
    static double virusandinfectionP = 0, virusandinfectionA = 0, dosattackP = 0, dosattackA = 0;
    
    public static double getRisk(String name, String risk) {
        double riskProbability = 0;
        java.sql.Connection cn = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT " + risk + " FROM conditionals WHERE name = '"+name+"'";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            rs = cn.createStatement().executeQuery(sql);
            while(rs.next()) {
                riskProbability = rs.getDouble(risk);
            }
            rs.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            
            try {
                if(cn != null) {
                    cn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
            }
        }
        return riskProbability;
    }
    
    public static double setPosterior(double cond, double risk, double effect) {
        /*  to calculate the posterior probability of the effect given the risk is true
            i.e. p(c|a) = p(a|c=true) * p(c) / p(a)
            where p(a|c=true) = conitional of a given c (p(a|c))
            p(c) = 0.33 effect
            p(a) = varies risk
        */
        
        double posterior = 0;
        posterior = (cond * effect) / risk;
        return posterior;
    }
    
    public static double getConditional(boolean state, String name, String risk, String effect) {
        double cond = 0;
        String tbl_name = "";
        if(state && effect.equalsIgnoreCase("confidentiality")) {
            tbl_name = "ccptable";
        } else if(!state && effect.equalsIgnoreCase("confidentiality")) {
            tbl_name = "ccptablef";
        } else if(state && effect.equalsIgnoreCase("integrity")) {
            tbl_name = "icptable";
        } else if(!state && effect.equalsIgnoreCase("integrity")) {
            tbl_name = "icptablef";
        } else if(state && effect.equalsIgnoreCase("availability")) {
            tbl_name = "acptable";
        } else {
            tbl_name = "acptablef";
        }
        java.sql.Connection cnn = null;
        java.sql.ResultSet rs = null;
        String query = "SELECT " + risk + " FROM " + tbl_name + " WHERE name = '"+name+"'";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            rs = cnn.createStatement().executeQuery(query);
            while(rs.next()) {
                cond = rs.getDouble(risk);
            }
            rs.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(cnn != null) {
                    cnn.close();
                }
            } catch(java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return cond;
    }
    
    public static boolean savePosterior(double trueValue, double falseValue, String name, String risk, String effect) {
        java.sql.Connection conn = null;
        boolean saved = false;
        String tableName = "";
        String sql;
        int id = 0;
        if(effect.equalsIgnoreCase("confidentiality")) {
            tableName = "cposterior";
        } else if(effect.equalsIgnoreCase("integrity")) {
            tableName = "iposterior";
        } else {
            tableName = "aposterior";
        }
        sql = "INSERT INTO " + tableName + " VALUES('"+id+"', '"+name+"', '"+risk+"', '"+trueValue+"', '"+falseValue+"')";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            conn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            conn.createStatement().executeUpdate(sql);
            saved = !saved;
        } catch(Exception e) {
            e.printStackTrace();
            saved = saved;
        }
        finally {
            
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
                saved = saved;
            }
        }
        return saved;
    }
    
    public static void savePosteriorData(String effect) {
        String sessionName = drone.Drone.name;
        itheftP = setPosterior(getConditional(true, sessionName, "itheft", effect), getRisk(sessionName, "itheft"), 0.33);
        System.out.println(itheftP);
        itheftA = setPosterior(getConditional(false, sessionName, "itheft", effect), 1 - getRisk(sessionName, "itheft"), 0.67);
        System.out.println(itheftA);
        humanerrorP = setPosterior(getConditional(true, sessionName, "humanerror", effect), getRisk(sessionName, "humanerror"), 0.33);
        humanerrorA = setPosterior(getConditional(false, sessionName, "humanerror", effect), 1 - getRisk(sessionName, "humanerror"), 0.67);
        
        unauthuseP = setPosterior(getConditional(true, sessionName, "unauthuse", effect), getRisk(sessionName, "unauthuse"), 0.33);
        unauthuseA = setPosterior(getConditional(false, sessionName, "unauthuse", effect), 1 - getRisk(sessionName, "unauthuse"), 0.67);
        
        attackP = setPosterior(getConditional(true, sessionName, "attack", effect), getRisk(sessionName, "attack"), 0.33);
        attackA = setPosterior(getConditional(false, sessionName, "attack", effect), 1 - getRisk(sessionName, "attack"), 0.67);
        
        datalossP = setPosterior(getConditional(true, sessionName, "dataloss", effect), getRisk(sessionName, "dataloss"), 0.33);
        datalossA = setPosterior(getConditional(false, sessionName, "dataloss", effect), 1 - getRisk(sessionName, "dataloss"), 0.67);
        
        bckfailP = setPosterior(getConditional(true, sessionName, "bckfail", effect), getRisk(sessionName, "bckfail"), 0.33);
        bckfailA = setPosterior(getConditional(false, sessionName, "bckfail", effect), 1 - getRisk(sessionName, "bckfail"), 0.67);
        
        assetdamageP = setPosterior(getConditional(true, sessionName, "assetdamage", effect), getRisk(sessionName, "assetdamage"), 0.33);
        assetdamageA = setPosterior(getConditional(false, sessionName, "assetdamage", effect), 1 - getRisk(sessionName, "assetdamage"), 0.67);
        
        naturaldisP = setPosterior(getConditional(true, sessionName, "naturaldis", effect), getRisk(sessionName, "naturaldis"), 0.33);
        naturaldisA = setPosterior(getConditional(false, sessionName, "naturaldis", effect), 1 - getRisk(sessionName, "naturaldis"), 0.67);
        
        opdisruptionP = setPosterior(getConditional(true, sessionName, "opdisruption", effect), getRisk(sessionName, "opdisruption"), 0.33);
        opdisruptionA = setPosterior(getConditional(false, sessionName, "opdisruption", effect), 1 - getRisk(sessionName, "opdisruption"), 0.67);
        
        progBugsP = setPosterior(getConditional(true, sessionName, "progBugs", effect), getRisk(sessionName, "progBugs"), 0.33);
        progBugsA = setPosterior(getConditional(false, sessionName, "progBugs", effect), 1 - getRisk(sessionName, "progBugs"), 0.67);
        
        powerprobP = setPosterior(getConditional(true, sessionName, "powerprob", effect), getRisk(sessionName, "powerprob"), 0.33);
        powerprobA = setPosterior(getConditional(false, sessionName, "powerprob", effect), 1 - getRisk(sessionName, "powerprob"), 0.67);
        
        hackP = setPosterior(getConditional(true, sessionName, "hack", effect), getRisk(sessionName, "hack"), 0.33);
        hackA = setPosterior(getConditional(false, sessionName, "hack", effect), 1 - getRisk(sessionName, "hack"), 0.67);        
        
        virusandinfectionP = setPosterior(getConditional(true, sessionName, "virusandinfection", effect), getRisk(sessionName, "virusandinfection"), 0.33);
        virusandinfectionA = setPosterior(getConditional(false, sessionName, "virusandinfection", effect), 1 - getRisk(sessionName, "virusandinfection"), 0.67);
        
        dosattackP = setPosterior(getConditional(true, sessionName, "dosattack", effect), getRisk(sessionName, "dosattack"), 0.33);
        dosattackA = setPosterior(getConditional(false, sessionName, "dosattack", effect), 1 - getRisk(sessionName, "dosattack"), 0.67);
        
        savePosterior(itheftP, itheftA, sessionName, "itheft", effect);
        savePosterior(humanerrorP, humanerrorA, sessionName, "humanerror", effect);
        savePosterior(unauthuseP, unauthuseA, sessionName, "unauthuse", effect);
        savePosterior(attackP, attackA, sessionName, "attack", effect);
        savePosterior(datalossP, datalossA, sessionName, "dataloss", effect);
        savePosterior(bckfailP, bckfailA, sessionName, "bckfail", effect);
        savePosterior(assetdamageP, assetdamageA, sessionName, "assetdamage", effect);
        savePosterior(naturaldisP, naturaldisA, sessionName, "naturaldis", effect);
        savePosterior(opdisruptionP, opdisruptionA, sessionName, "opdisruption", effect);
        savePosterior(progBugsP, progBugsA, sessionName, "progBugs", effect);
        savePosterior(powerprobP, powerprobA, sessionName, "powerprob", effect);
        savePosterior(hackP, hackA, sessionName, "hack", effect);
        savePosterior(virusandinfectionP, virusandinfectionA, sessionName, "virusandinfection", effect);
        savePosterior(dosattackP, dosattackA, sessionName, "dosattack", effect);
    }
}
