/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities;

import java.io.IOException;

/**
 *
 * @author OMOLARA A
 */
public class PosteriorDistribution {
    
    public PosteriorDistribution() throws IOException {
        initiate();
        System.out.println("From PosteriorDistribution, initiate started");
    }
    
    public void initiate() throws IOException {
        //new probabilities.helpers.PosteriorHelper();
        new probabilities.helpers.PosteriorHelper().savePosteriorData("confidentiality");
        new probabilities.helpers.PosteriorHelper().savePosteriorData("integrity");
        new probabilities.helpers.PosteriorHelper().savePosteriorData("availability");
        new probabilities.JointProbabilities();
    }
    public static void main(String[] args) throws IOException {
        new PosteriorDistribution();
    }
}
