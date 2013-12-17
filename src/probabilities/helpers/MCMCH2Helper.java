/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities.helpers;

import java.io.IOException;
import mcmc.MCMCH1;
import org.omegahat.Probability.Distributions.UnnormalizedDensity;
import org.omegahat.Simulation.MCMC.CustomMetropolisHastingsSampler;
import org.omegahat.Simulation.MCMC.Listeners.ListenerPrinter;
import org.omegahat.Simulation.MCMC.Listeners.ListenerWriter;
import org.omegahat.Simulation.MCMC.Listeners.StrippedListenerWriter;
import org.omegahat.Simulation.MCMC.MCMCListener;
import org.omegahat.Simulation.MCMC.MCMCListenerHandle;
import org.omegahat.Simulation.MCMC.Proposals.NormalMetropolisComponentProposal;
import org.omegahat.Simulation.MCMC.SymmetricProposal;
import org.omegahat.Simulation.RandomGenerators.CollingsPRNG;
import org.omegahat.Simulation.RandomGenerators.CollingsPRNGAdministrator;
import org.omegahat.Simulation.RandomGenerators.PRNG;

/**
 *
 * @author OMOLARA A
 */
public class MCMCH2Helper {
    
    static String name = drone.Drone.name;
    static String itheft = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\IdentityTheft.txt";
    static String humanerror = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\HumanError.txt";
    static String unauthuse = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\UnauthorisedUse.txt";
    static String attack = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\Attack.txt";
    static String dataloss = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\DataLoss.txt";
    static String bckfail = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\BackupFailure.txt";
    static String assetdamage = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\AssetDamage.txt";
    static String naturaldis = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\NaturalDisaster.txt";
    static String opdisruption = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\OperationalDisruption.txt";
    static String progBugs = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\ProgrammingBugs.txt";
    static String powerprob = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\PowerProblem.txt";
    static String hack = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\Hacks.txt";
    static String virusandinfection = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\VirusAndInfection.txt";
    static String dosattack = "C:\\Users\\OMOLARA A\\Documents\\NetBeansProjects\\PROJECt_WORK\\src\\project_work\\DosAttack.txt";
    
    static public double getCP(double pr, String path) throws IOException {
        double cp = 0;
        CollingsPRNGAdministrator a = new CollingsPRNGAdministrator();
        PRNG prng = new CollingsPRNG(a.registerPRNGState());

        UnnormalizedDensity target = new MCMCH1();
        double[] diagVar = new double[]{pr, pr, pr, pr};
        SymmetricProposal proposal = new NormalMetropolisComponentProposal(diagVar, prng);
        double[] state = new double[]{0.33, 0.33, 0.33, 0.33};
        CustomMetropolisHastingsSampler mcmc = new CustomMetropolisHastingsSampler(state, target, proposal, prng, true);
        MCMCListener l = new ListenerPrinter();//line 28
        MCMCListenerHandle lh = mcmc.registerListener(l);
        ListenerWriter saveFile = new StrippedListenerWriter(path);
        MCMCListenerHandle listenerhandler = mcmc.registerListener(saveFile);
        mcmc.iterate(20);
        System.out.println("Acceptance Ratio: " + mcmc.acceptanceRatio() + "\n");
        cp = mcmc.acceptanceRatio() * Math.random() / (pr * 10);
        System.out.println("New Acceptance Ratio for True = " + cp);
        saveFile.close();
        
        return cp;
    }
    
    public static double getCPF(double pr, String path) throws IOException {
        double cp = 0;
        CollingsPRNGAdministrator a = new CollingsPRNGAdministrator();
        PRNG prng = new CollingsPRNG(a.registerPRNGState());

        UnnormalizedDensity target = new MCMCH1();
        double[] diagVar = new double[]{pr, pr, pr, pr};
        SymmetricProposal proposal = new NormalMetropolisComponentProposal(diagVar, prng);
        double[] state = new double[]{0.67, 0.67, 0.67, 0.67};
        CustomMetropolisHastingsSampler mcmc = new CustomMetropolisHastingsSampler(state, target, proposal, prng, true);
        MCMCListener l = new ListenerPrinter();//line 28
        MCMCListenerHandle lh = mcmc.registerListener(l);
        ListenerWriter saveFileF = new StrippedListenerWriter(path);
        MCMCListenerHandle listenerhandler = mcmc.registerListener(saveFileF);
        mcmc.iterate(50);
        System.out.println("Acceptance Ratio: " + mcmc.acceptanceRatio() + "\n");
        cp = mcmc.acceptanceRatio() * Math.random() / (pr * 10);
        System.out.println("New Acceptance Ratio for False = " + cp);
        saveFileF.close();
        
        return cp;
    }
    
    public static double getPr(String risk, String name) {
        double riskProbability = 0;
        String sql = "SELECT " + risk + " FROM conditionals WHERE name = '"+name+"'";
        java.sql.Connection cn = null;
        java.sql.ResultSet rs = null;
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            rs = cn.createStatement().executeQuery(sql);
            while(rs.next()) {
                riskProbability = rs.getDouble(risk);
                System.out.println("\nPrior = " + riskProbability);
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
    
    public static void saveCPTable(double v1, double v2,double v3, double v4,double v5,
                            double v6,double v7, double v8,double v9, double v10,
                            double v11, double v12,double v13, double v14,  String name, String effect) {
        String tableName = "";
        if(effect.equalsIgnoreCase("confidentiality")) {
            tableName = "ccptable";
        } else if(effect.equalsIgnoreCase("integrity")) {
            tableName = "icptable";
        } else {
            tableName = "acptable";
        }
        java.sql.Connection cnn = null;
        String sql = "INSERT INTO " + tableName + " VALUES('"+name+"',"
                + "'"+v1+"', '"+v2+"', '"+v3+"', '"+v4+"',"
                + " '"+v5+"', '"+v6+"', '"+v7+"', '"+v8+"',"
                + " '"+v9+"', '"+v10+"', '"+v11+"', '"+v12+"',"
                + "'"+v13+"', '"+v14+"')";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            cnn.createStatement().executeUpdate(sql);
            saved(true, "Conditional true values");
        } catch(Exception e) {
            e.printStackTrace();
            saved(false, "Conditional true values");
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
    }
    
    public static void saveCPTableF(double v1, double v2,double v3, double v4,double v5,
                            double v6,double v7, double v8,double v9, double v10,
                            double v11, double v12,double v13, double v14,  String name, String effect) {
        String tableName = "";
        if(effect.equalsIgnoreCase("confidentiality")) {
            tableName = "ccptablef";
        } else if(effect.equalsIgnoreCase("integrity")) {
            tableName = "icptablef";
        } else {
            tableName = "acptablef";
        }        
        java.sql.Connection cnn = null;
        String sql = "INSERT INTO " + tableName + " VALUES('"+name+"',"
                + "'"+v1+"', '"+v2+"', '"+v3+"', '"+v4+"',"
                + " '"+v5+"', '"+v6+"', '"+v7+"', '"+v8+"',"
                + " '"+v9+"', '"+v10+"', '"+v11+"', '"+v12+"',"
                + "'"+v13+"', '"+v14+"')";
        try {
            Class.forName(database.DatabaseHandler.DRIVER);
            cnn = java.sql.DriverManager.getConnection(database.DatabaseHandler.DATABASE, database.DatabaseHandler.UR, database.DatabaseHandler.PR);
            cnn.createStatement().executeUpdate(sql);
            saved(true, "Conditional false values");
        } catch(Exception e) {
            e.printStackTrace();
            saved(false, "Conditional false values");
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
    }
    
    public static void saved(boolean val, String data) {
        String title, msg;
        if(val) {
            title = "Success!";
            msg = data + " data written to disk";
            showMessage(title, msg);
        } else {
            title = "Save Failure!";
            msg = data + " data was not written to disk";
            showMessage(title, msg);
        }
    }
    
    public static void saverT(String risk) throws IOException {
        double c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
        c1 = getCP(getPr("itheft", name), itheft);
        c2 = getCP(getPr("humanerror", name), humanerror);
        c3 = getCP(getPr("unauthuse", name), unauthuse);
        c4 = getCP(getPr("attack", name), attack);
        c5 = getCP(getPr("dataloss", name), dataloss);
        c6 = getCP(getPr("bckfail", name), bckfail);
        c7 = getCP(getPr("assetdamage", name), assetdamage);
        c8 = getCP(getPr("naturaldis", name), naturaldis);
        c9 = getCP(getPr("opdisruption", name), opdisruption);
        c10 = getCP(getPr("progBugs", name), progBugs);
        c11 = getCP(getPr("powerprob", name), powerprob);
        c12 = getCP(getPr("hack", name), hack);
        c13 = getCP(getPr("virusandinfection", name), virusandinfection);
        c14 = getCP(getPr("dosattack", name), dosattack);
        
        saveCPTable(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, name, risk);
    }
    
    public static void saverF(String risk) throws IOException {
        double c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
        c1 = getCPF(1 - getPr("itheft", name), itheft);
        c2 = getCPF(1 - getPr("humanerror", name), humanerror);
        c3 = getCPF(1 - getPr("unauthuse", name), unauthuse);
        c4 = getCPF(1 - getPr("attack", name), attack);
        c5 = getCPF(1 - getPr("dataloss", name), dataloss);
        c6 = getCPF(1 - getPr("bckfail", name), bckfail);
        c7 = getCPF(1 - getPr("assetdamage", name), assetdamage);
        c8 = getCPF(1 - getPr("naturaldis", name), naturaldis);
        c9 = getCPF(1 - getPr("opdisruption", name), opdisruption);
        c10 = getCPF(1 - getPr("progBugs", name), progBugs);
        c11 = getCPF(1 - getPr("powerprob", name), powerprob);
        c12 = getCPF(1 - getPr("hack", name), hack);
        c13 = getCPF(1 - getPr("virusandinfection", name), virusandinfection);
        c14 = getCPF(1 - getPr("dosattack", name), dosattack);
        
        saveCPTableF(c1, c2, c3, c4, c5, c6, c7, c8, c9, 10, c11, c12, c13, c14, name, risk);
    }
    
    static public void showMessage(String title, String msg) {
        //javax.swing.JOptionPane.showMessageDialog(null, msg, title, javax.swing.JOptionPane.INFORMATION_MESSAGE);
        System.out.println(title + "\t" + msg);
    }
}
