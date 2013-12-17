/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmc;

/**
 *
 * @author OMOLARA A
 */

import java.io.IOException;
public class MCMCH2 {
    
        
    public MCMCH2() throws IOException {
        probabilities.helpers.MCMCH2Helper.saverT("confidentiality");
        probabilities.helpers.MCMCH2Helper.saverT("integrity");
        probabilities.helpers.MCMCH2Helper.saverT("availability");
        probabilities.helpers.MCMCH2Helper.saverF("confidentiality");
        probabilities.helpers.MCMCH2Helper.saverF("integrity");
        probabilities.helpers.MCMCH2Helper.saverF("availability");
        new probabilities.PosteriorDistribution();
    }
    public static void main(String[] args) throws Throwable {
        new MCMCH2();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
