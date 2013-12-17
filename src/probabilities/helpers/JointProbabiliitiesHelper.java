/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities.helpers;

/**
 *
 * @author OMOLARA A
 */
public class JointProbabiliitiesHelper {
    
    static public double getPrior(String risk, String name) {
        double prior = 0;
        String sql = "";
        java.sql.Connection cn = null;
        java.sql.ResultSet rs = null;
        String riskName = setRiskName(risk);
        sql = "SELECT " + riskName + " FROM conditionals WHERE name = '"+name+"'";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            rs = cn.createStatement().executeQuery(sql);
            while(rs.next()) {
                prior = rs.getDouble(riskName);
                System.out.println("\nJointProbabilitiesHelper method getPrior, Prior: " + prior);
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
        return prior;
    }
    
    static public double getPosterior(String effect, String risk, String name, String state) {
        String sql = "";
        double posterior = 0;
        String tableName = "";
        java.sql.ResultSet rs = null;
        java.sql.Connection cnn = null;
        if(effect.equalsIgnoreCase("confidentiality")) {
            tableName = "cposterior";
        } else if(effect.equalsIgnoreCase("integrity")){
            tableName = "iposterior";
        } else {
            tableName = "aposterior";
        }
        String riskName = setRiskName(risk);
        sql = "SELECT " + state + " FROM " + tableName + " WHERE risk = '" + riskName + "' AND name = '" + name + "'";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            rs = cnn.createStatement().executeQuery(sql);
            while(rs.next()) {
                posterior = rs.getDouble(state);
                System.out.println("\nAt JointPosteriorHelper, Posterior Value = " + posterior);
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
            } catch(java.sql.SQLException se) {
                se.printStackTrace();
            }
        }
        return posterior;
    }
    
    static public double sampleJPD(double prior, double posterior) {
        /**
         * To compute or sample for the Joint Probability Distribution.
         * by using the formula P(A, C) = P(A) * P(C|A) where
         * P(A) = prior probability of the risk
         * P(C|A) = posterior probability of the effect given the risk
         */
        return prior * posterior;
    }
    
    static public String setRiskName(String risk) {
        String riskName = "";
        if(risk.equalsIgnoreCase("Identity Theft")) {
            riskName = "itheft";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Human Error")) {
            riskName = "humanerror";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Unauthorised Use")) {
            riskName = "unauthuse";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Attack")) {
            riskName = "attack";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Data Loss")) {
            riskName = "dataloss";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Backup Failure")) {
            riskName = "bckfail";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Asset Damage")) {
            riskName = "assetdamage";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Natural Disaster")) {
            riskName = "naturaldis";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Operational Disruption")) {
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
            riskName = "opdisruption";
        } else if(risk.equalsIgnoreCase("Programming Bugs")) {
            riskName = "progBugs";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Power Problems")) {
            riskName = "powerprob";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Hacks")) {
            riskName = "hack";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("Virus and Infection")) {
            riskName = "virusandinfection";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else if(risk.equalsIgnoreCase("DOS Attack")){
            riskName = "dosattack";
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, match found for riskName: " + risk);
        } else {
            System.out.println("At Class: JointProbabilitiesHelper method setRiskName, no match was found for riskName: " + risk);
        }
        return riskName;
    }
    
    static public void setValues(String risk, String effect) {
        String session = drone.Drone.name;
        /*double pr = getPrior(risk, session); pst = 0,
        pst = getPosterior(effect, risk, session, "present");
        */
        double post = 0, post2 = 0;
        post = sampleJPD(getPrior(risk, session), getPosterior(effect, risk, session, "present"));
        post2 = sampleJPD(getPrior(risk, session), getPosterior(effect, risk, session, "absent"));
        
        saveJointProbabilities(session, post, 1-post, post2, 1-post2);
    }
    
    public static void saveJointProbabilities(String name, double eyry, double enry, double eyrn, double enrn) {
        /*
         * the values are 
         *  eyry = (effect = yes | risk = yes) provided by sampleJPD()
         *  enry = (effect = no | risk = yes) also provided by sampleJPD()
         *  eyrn = (effect = yes | risk = no) 1 - eyry
         *  enrn = (effect = no | risk = no ) 1 - enry
         */
        int id = 0;
        String sql = "INSERT INTO joints VALUES('"+id+"', '"+name+"', '"+eyry+"', '"+enry+"', '"+eyrn+"', '"+enrn+"')";
        database.DatabaseHandler.insert(null, sql);
    }
}
