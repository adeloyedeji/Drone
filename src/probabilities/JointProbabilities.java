/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities;

import java.io.IOException;
import probabilities.helpers.JointProbabiliitiesHelper;

/**
 *
 * @author OMOLARA A
 */
public class JointProbabilities {
    
    public JointProbabilities() throws IOException {
        initiate();
    }
    
    public void initiate() throws IOException {
        String[] risks = new String[]{"Identity Theft", "Human Error", "Unauthorised Use",
                                      "Attack", "Data Loss", "Backup Failure", "Asset Damage",
                                      "Natural Disaster", "Operational Disruption", "Programming Bugs",
                                      "Power Problems", "Hacks", "Virus and Infection", "DOS Attack"};
        String[] effects = new String[]{"confidentiality", "integrity", "availability"};
//        int i = 0, j = 0;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 1;
        //confidentiality
        JointProbabiliitiesHelper.setValues(risks[0], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[1], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[2], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[3], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[4], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[5], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[6], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[7], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[8], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[9], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[10], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[11], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[12], effects[0]);
        JointProbabiliitiesHelper.setValues(risks[13], effects[0]);
        //integrity
        JointProbabiliitiesHelper.setValues(risks[0], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[1], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[2], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[3], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[4], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[5], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[6], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[7], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[8], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[9], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[10], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[11], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[12], effects[1]);
        JointProbabiliitiesHelper.setValues(risks[13], effects[1]);
        //availability
        JointProbabiliitiesHelper.setValues(risks[0], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[1], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[2], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[3], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[4], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[5], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[6], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[7], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[8], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[9], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[10], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[11], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[12], effects[2]);
        JointProbabiliitiesHelper.setValues(risks[13], effects[2]);
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 2;
//        
//        
//        
//        
//        
//        
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 3;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 4;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 5;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 6;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 7;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 8;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 9;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 10;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 11;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 12;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 13;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
//        i = 14;
//        while(j < 3) {
//            JointProbabiliitiesHelper.setValues(risks[i], effects[j]);
//            System.out.println("Risk: " + risks[i] + "\tEffect: " + effects[j]);
//            j++;
//        }
        new drone.Analysis(1).setVisible(true);

    }
    
    public static void main(String[] args) throws IOException {
    }
}
