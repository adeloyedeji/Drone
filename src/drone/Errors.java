/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drone;

import java.io.IOException;

/**
 *
 * @author OMOLARA A
 */
public class Errors {
    
    public static void invalidInput(javax.swing.JFrame frame) {
        String title = "Error";
        String msg = "INVALID ENTRY PLEASE CHECK YOUR INPUT";
        javax.swing.JOptionPane.showMessageDialog(frame, msg, title, javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public static void saveError(javax.swing.JFrame frame) {
        String title = "Error";
        String msg = "UNABLE TO SAVE YOUR RECORD. PLEASE TRY AGAIN";
        javax.swing.JOptionPane.showMessageDialog(frame, msg, title, javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public static void sqlError(javax.swing.JFrame frame) {
        String title = "Error";
        String msg = "There was a problem with the database. Please try again";
        javax.swing.JOptionPane.showMessageDialog(frame, msg, title, javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public static void success(javax.swing.JTabbedPane frame, String msg) {
        String title = "Complete";
        javax.swing.JOptionPane.showMessageDialog(frame, msg, title, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void success(String data) throws IOException{
        String title = "Success";
        String msg = data + " Saved Successfully!";
        //javax.swing.JOptionPane.showMessageDialog(null, msg, title, javax.swing.JOptionPane.INFORMATION_MESSAGE);
        System.out.println(title + "\t" + msg);
        new mcmc.MCMCH2();
    }
    
    public static void failure(String data, double[] cpValues) throws IOException {
        String title = "Failure!";
        String msg =data + " record was not saved! Try again with a different name?";
        int option = javax.swing.JOptionPane.showConfirmDialog(null, msg, title, javax.swing.JOptionPane.YES_NO_OPTION);
        if(option == 0) {
            probabilities.helpers.PriorHelper.saveCPTable(cpValues);
        } else {
            doNothing();
            new mcmc.MCMCH2();
        }
    }
    
    public static void doNothing() {}
    
}
