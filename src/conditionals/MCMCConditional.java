/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

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

public class MCMCConditional {
    
    public double calculateConditional(double prior, String savedir, boolean status) throws java.io.IOException {
        double conditionalProbability = 0;
        double[] state;
        if(status) {
            state = new double[]{0.33, 0.33, 0.33, 0.33};
        } else {
            state = new double[]{0.67, 0.67, 0.67, 0.67};
        }
        CollingsPRNGAdministrator a = new CollingsPRNGAdministrator();
        PRNG prng = new CollingsPRNG(a.registerPRNGState());
        UnnormalizedDensity target = new Conditional();
        double[] diagVar = new double[]{prior, prior, prior, prior};
        SymmetricProposal proposal = new NormalMetropolisComponentProposal(diagVar, prng);
        CustomMetropolisHastingsSampler mcmc = new CustomMetropolisHastingsSampler(state, target, proposal, prng, true);
        MCMCListener l = new ListenerPrinter();
        MCMCListenerHandle ld = mcmc.registerListener(l);
        ListenerWriter saveFile = new StrippedListenerWriter(savedir);
        MCMCListenerHandle listenerhandler = mcmc.registerListener(saveFile);
        mcmc.iterate(50);
        conditionalProbability = mcmc.acceptanceRatio() * Math.random() / (prior * 10);
        saveFile.close();
        
        return conditionalProbability;
    }
    
    //calculateConditional needs to use the prior values
    //hence a method to get prior values from database
    
    public double getPrior(String name, String riskName) throws java.sql.SQLException {
        double prior = 0;
        java.sql.ResultSet rs = null;
        String query = "SELECT " + riskName + " FROM priors WHERE name = '"+name+"'";
        rs = database.AnalysisDatabase.fetchQuery(query);
        while(rs.next()) {
            prior = rs.getDouble(riskName);
        }
        rs.close();
        
        return prior;
    }
    
    //method to actually implement the above methods and save to database
    
    public void saveProbabilities(double[] data, String name, String effect, boolean state) {
        String tableName = "";
        if(effect.equalsIgnoreCase("confidentiality")) {
            tableName = (state) ? "ccptable" : "ccptablef";
        } else if(effect.equalsIgnoreCase("integrity")) {
            tableName = (state) ? "icptable" : "icptablef";
        } else if(effect.equalsIgnoreCase("availability")) {
            tableName = (state) ? "acptable" : "acptablef";
        }
        String query = "INSERT INTO " + tableName + " VALUES("
                + "'"+name+"', '"+data[0]+"', '"+data[1]+"', '"+data[2]+"', "
                + "'"+data[3]+"', '"+data[4]+"', '"+data[5]+"', '"+data[6]+"', "
                + "'"+data[7]+"', '"+data[8]+"', '"+data[9]+"', '"+data[10]+"', "
                + "'"+data[11]+"', '"+data[12]+"', '"+data[13]+"', '"+data[14]+"', )";
        database.DatabaseHandler.insert(null, query);
    }
    
    public static void test(String effect, boolean state) {
        String tableName = "";
        tableName = ((effect.equalsIgnoreCase("confidentiality")) && state) ? "ccptable" : "cctablef";
        System.out.println(tableName);
    }
    
    public static void main(String[] args) {
    }
}
