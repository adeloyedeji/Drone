/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prior;


/**
 *
 * @author OMOLARA A
 */
public class PriorModule {
    
    static int temp;
    static double tempv;
    
    public PriorModule() throws java.sql.SQLException{
       int[] yearCollection = new int[getYears().length];
       yearCollection = java.util.Arrays.copyOf(getYears(), getYears().length);
       initiate(yearCollection);
       new conditionals.Conditional();
    }
    public static int[] getYears() throws java.sql.SQLException {
        java.sql.ResultSet rss = null;
        int j = 0;
        int[] numYears = new int[database.AnalysisDatabase.getCount("expertdata")];
        String query = "SELECT numyears FROM expertdata ORDER BY id";
        rss = database.AnalysisDatabase.fetchQuery(query);
        while(rss.next()) {
            for(int i = 0; i < 1; i++) {
                temp = rss.getInt(i+1);
                numYears[j] = temp;
                j++;
            }
        }
        rss.close();
        return numYears;
    }
    
    public static double[] getRiskFrequency(String riskName, String component) throws java.sql.SQLException{
        java.sql.ResultSet rs = null;
        int j = 0;
        double[] riskFrequency = new double[database.AnalysisDatabase.getCount("causability")];
        String query = "SELECT " + riskName + " FROM " + component+ "ORDER BY " + riskName;
        rs = database.AnalysisDatabase.fetchQuery(query);
        while(rs.next()) {
            for(int i = 0; i < 1; i ++) {
                tempv = rs.getDouble(i+1);
                riskFrequency[j] = tempv;
                j++;
            }
        }
        rs.close();
        return riskFrequency;
    }
    
    public static double calculatePrior(String riskName, String component, int[] yearCollection) throws java.sql.SQLException{
        double sum = 0.0;
        
        //initialize new array to collect all entries for a particular risk e.g. identity theft
        int riskLength = getRiskFrequency(riskName, component).length;
        double[] riskCollection = new double[riskLength];
        
        //copy all risks to riskCollection array
        riskCollection = java.util.Arrays.copyOf(getRiskFrequency(riskName, component), riskLength);
        
        /*  Assuming that the total number of experts is the same as the total number
         *  of rows for a particular risk therefore, calculating the prior using the formular
         *  WiPi(0) where
         *  Wi = weight of the expert gotten from the number of years of experience of the expert
         *  Pi(0) = represents the experts i's probabiility distribution for a particular risk
         */
        for(int i = 0; i < riskLength; i++) {
            sum += yearCollection[i] * riskCollection[i];
        }
        
        return sum;
    }
    
    public void initiate(int[] yearCollection) throws java.sql.SQLException{
        int id = 0;
        String name = drone.Drone.name;
        String[] risks = {"iTheft", "humanError", "unauthUse", "attack", "dataLoss",
                          "bckFail", "assetDamage", "naturalDis", "opDisruption",
                          "progBug", "powerProb", "hacks", "virus", "dosAttack",
                          "extra1", "extra2"};
        String[] components = {"component9", "component10", "component11", "component12"};
        double[] sums = new double[risks.length];
        
        //calculate prior probability for identity theft
        sums[0] = calculatePrior(risks[0], components[0], yearCollection) +
                  calculatePrior(risks[0], components[1], yearCollection) + 
                  calculatePrior(risks[0], components[2], yearCollection) + 
                  calculatePrior(risks[0], components[3], yearCollection);
        
        //calculate prior probability for human error
        sums[1] = calculatePrior(risks[1], components[0], yearCollection) +
                  calculatePrior(risks[1], components[1], yearCollection) +
                  calculatePrior(risks[1], components[2], yearCollection) +
                  calculatePrior(risks[1], components[3], yearCollection);
        
        //calculate prior probability for unauthorised use
        sums[2] = calculatePrior(risks[2], components[0], yearCollection) +
                  calculatePrior(risks[2], components[1], yearCollection) +
                  calculatePrior(risks[2], components[2], yearCollection) + 
                  calculatePrior(risks[2], components[3], yearCollection);
        
        //calculate prior probability for attack
        sums[3] = calculatePrior(risks[3], components[0], yearCollection) + 
                  calculatePrior(risks[3], components[1], yearCollection) +
                  calculatePrior(risks[3], components[2], yearCollection) +
                  calculatePrior(risks[3], components[3], yearCollection);
        
        //calculate prior probability for data loss
        sums[4] = calculatePrior(risks[4], components[0], yearCollection) +
                  calculatePrior(risks[4], components[1], yearCollection) +
                  calculatePrior(risks[4], components[2], yearCollection) +
                  calculatePrior(risks[4], components[3], yearCollection);
        
        //calculate prior probability for backup failure
        sums[5] = calculatePrior(risks[5], components[0], yearCollection) +
                  calculatePrior(risks[5], components[1], yearCollection) +
                  calculatePrior(risks[5], components[2], yearCollection) +
                  calculatePrior(risks[5], components[3], yearCollection);
        
        //calculate prior probability for asset damage
        sums[6] = calculatePrior(risks[6], components[0], yearCollection) +
                  calculatePrior(risks[6], components[1], yearCollection) +
                  calculatePrior(risks[6], components[2], yearCollection) +
                  calculatePrior(risks[6], components[3], yearCollection);
        
        //calculate prior probability for natural disaster
        sums[7] = calculatePrior(risks[7], components[0], yearCollection) +
                  calculatePrior(risks[7], components[1], yearCollection) +
                  calculatePrior(risks[7], components[2], yearCollection) +
                  calculatePrior(risks[7], components[3], yearCollection);
        
        //calculate prior probability for operational disruption
        sums[8] = calculatePrior(risks[8], components[0], yearCollection) +
                  calculatePrior(risks[8], components[1], yearCollection) +
                  calculatePrior(risks[8], components[2], yearCollection) +
                  calculatePrior(risks[8], components[3], yearCollection);
        
        //calculate prior probability for programming bugs
        sums[9] = calculatePrior(risks[9], components[0], yearCollection) +
                  calculatePrior(risks[9], components[1], yearCollection) +
                  calculatePrior(risks[9], components[2], yearCollection) +
                  calculatePrior(risks[9], components[3], yearCollection);
        
        //calculate prior probability for power problems
        sums[10] = calculatePrior(risks[10], components[0], yearCollection) +
                   calculatePrior(risks[10], components[1], yearCollection) + 
                   calculatePrior(risks[10], components[2], yearCollection) + 
                   calculatePrior(risks[10], components[3], yearCollection);
        
        //calculate prior probability for hacks
        sums[11] = calculatePrior(risks[11], components[0], yearCollection) + 
                   calculatePrior(risks[11], components[1], yearCollection) + 
                   calculatePrior(risks[11], components[2], yearCollection) + 
                   calculatePrior(risks[11], components[3], yearCollection);
        
        //calculate prior probability for virus and infection
        sums[12] = calculatePrior(risks[12], components[0], yearCollection) + 
                   calculatePrior(risks[12], components[1], yearCollection) + 
                   calculatePrior(risks[12], components[2], yearCollection) + 
                   calculatePrior(risks[12], components[3], yearCollection);
        
        //calculate prior probability for dos attack
        sums[13] = calculatePrior(risks[13], components[0], yearCollection) + 
                   calculatePrior(risks[13], components[1], yearCollection) + 
                   calculatePrior(risks[13], components[2], yearCollection) + 
                   calculatePrior(risks[13], components[3], yearCollection);
        
        //calculate prior probability for dos extra1
        sums[14] = calculatePrior(risks[14], components[0], yearCollection) +
                   calculatePrior(risks[14], components[1], yearCollection) +
                   calculatePrior(risks[14], components[2], yearCollection) + 
                   calculatePrior(risks[14], components[3], yearCollection);
        
        //calculate prior probability for extra2
        sums[15] = calculatePrior(risks[15], components[0], yearCollection) +
                   calculatePrior(risks[15], components[1], yearCollection) +
                   calculatePrior(risks[15], components[2], yearCollection) + 
                   calculatePrior(risks[15], components[3], yearCollection);
        
        //save the values to database;
        savePrior(id, name, sums);
    }
    
    public void savePrior(int id, String name, double[] data) {
        String sql = "INSERT INTO priors VALUES("
                + "'"+id+"', '"+name+"', '"+data[0]+"', '"+data[1]+"', '"+data[2]+"',"
                + " '"+data[3]+"', '"+data[4]+"', '"+data[5]+"', '"+data[6]+"', "
                + "'"+data[7]+"', '"+data[8]+"', '"+data[9]+"', '"+data[10]+"', "
                + "'"+data[11]+"', '"+data[12]+"', '"+data[13]+"', '"+data[14]+"', "
                + "'"+data[15]+"')";
        database.DatabaseHandler.insert(null, sql);
    }
    
    public static void test() {
        int sum = 0;
        int[] t1 = {1, 2, 3, 4, 5};
        int[] t2 = java.util.Arrays.copyOf(t1, t1.length);
        for(int i : t2) {
            System.out.println(i);
        }
        System.out.println("Sum is: " + sum);
        for(int i = 0; i < t1.length; i++) {
            sum += t1[i] * t2[i];
            System.out.println("Sum is: " + sum);
        }
    }
    
    public static void test2() {
        int j = 0;
        String name = "deji";
        for(int i = 0; i < 5; i++) {
            System.out.println("New name is: " + name + j);
            j++;
        }
    }
    
    /*public static void main(String[] args) throws java.sql.SQLException {
        for(int years : getYears()) {
            System.out.println(years);
        }
        System.out.println("******************");
        System.out.println("|                |");
        System.out.println("******************");
        for(double riskFreq : getRiskFrequency("identity_theft")) {
            System.out.println(riskFreq);
        }
        test();
        test2();
    }*/
}
