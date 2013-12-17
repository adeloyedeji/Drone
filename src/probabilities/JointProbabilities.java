/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities;


/**
 *
 * @author OMOLARA A
 */
public class JointProbabilities {
    
    public JointProbabilities() throws java.io.IOException, java.sql.SQLException {
        initiate();
    }
    
    public void initiate() throws java.io.IOException, java.sql.SQLException {
        String[] risks = new String[]{"Identity Theft", "Human Error", "Unauthorised Use",
                                      "Attack", "Data Loss", "Backup Failure", "Asset Damage",
                                      "Natural Disaster", "Operational Disruption", "Programming Bugs",
                                      "Power Problems", "Hacks", "Virus and Infection", "DOS Attack"};
        String[] effects = new String[]{"confidentiality", "integrity", "availability"};
        //confidentiality
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[0], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[1], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[2], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[3], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[4], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[5], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[6], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[7], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[8], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[9], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[10], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[11], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[12], effects[0]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[13], effects[0]);
        //integrity
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[0], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[1], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[2], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[3], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[4], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[5], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[6], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[7], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[8], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[9], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[10], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[11], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[12], effects[1]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[13], effects[1]);
        //availability
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[0], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[1], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[2], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[3], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[4], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[5], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[6], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[7], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[8], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[9], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[10], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[11], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[12], effects[2]);
        probabilities.helpers.JointProbabiliitiesHelper.setValues(risks[13], effects[2]);
        
        new drone.Analysis(1).setVisible(true);
    }
    
    public static void main(String[] args) throws java.io.IOException, java.sql.SQLException{
        new JointProbabilities();
    }
}
