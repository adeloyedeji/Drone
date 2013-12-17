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
public class Analysis extends javax.swing.JFrame {

    MyLocation.locationSetter obj = new MyLocation.locationSetter();
    javax.swing.JLabel[] labels = new javax.swing.JLabel[4];
    javax.swing.JTextArea suggestionsArea;
    double c = 30.0, i = 20.0, a = 50.0;
    static double total = 0.00;
    static int option = 0;
    public Analysis(int option) throws IOException {
        super("Network Performance Prediction System");
        //Driver.initiate();
        this.option = option;
        if(option == 0) {
            previousData(this);
        } else {
            //setGraphics(this, option);
        }
        drone.Driver.setFrameView();
        setVisible(true);
        setSize(500, 700);
        setAlwaysOnTop(true);
        setLocation(obj.myWidth(this), obj.myHeight(this));
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    public void previousData(javax.swing.JFrame frame) {
        java.awt.Container parentFrame = frame.getContentPane();
        parentFrame.setLayout(new java.awt.GridLayout(1, 1, 5, 5));
        
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setPreferredSize(Driver.size(this.getWidth(), this.getHeight()));
        //contentPanel.setBackground(Driver.white);
        contentPanel.setLayout(new java.awt.GridLayout(5, 1, 5, 5));
        
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel();
            Driver.setProperties(labels[i]);
        }
        suggestionsArea = new javax.swing.JTextArea();
        
        labels[0].setText("Percentage damage on Confidentiality is: " + Driver.scale(c, labels[0]) + " AT: " + c +"%");
        labels[1].setText("Percentage damage on Integrity is: " + Driver.scale(i, labels[1]) + " AT: " + i +"%");
        labels[2].setText("Percentage damage on Availability is : " + Driver.scale(a, labels[2]) + " AT: " + a +"%");
        labels[3].setText("Overall Performance of the Network is: " + Driver.overallPerformance(c, i, a, labels[3])  + " AT: " + roundOff(total) +"%");
        giveSuggestions(suggestionsArea, Driver.overallPerformance(c, i, a, labels[3]));
        
        for(int i = 0; i < labels.length; i++) {
            contentPanel.add(labels[i]);
            Driver.setProperties(labels[i]);
        }
        contentPanel.add(suggestionsArea);
        
        parentFrame.add(contentPanel, new java.awt.GridBagConstraints());
    }
    
    public void newData(javax.swing.JFrame frame, int option) {
        java.awt.Container parentFrame = frame.getContentPane();
        parentFrame.setLayout(new java.awt.GridLayout(1, 1, 5, 5));
        
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setPreferredSize(Driver.size(this.getWidth(), this.getHeight()));
        contentPanel.setBackground(Driver.white);
        contentPanel.setLayout(new java.awt.GridLayout(5, 1, 5, 5));
        
        suggestionsArea = new javax.swing.JTextArea();
        
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel();
            Driver.setProperties(labels[i]);
        }
        
        labels[0].setText("Percentage damage on Confidentiality is: " + Driver.scale(c, labels[0]) + " AT: " + c +"%");
        labels[1].setText("Percentage damage on Integrity is: " + Driver.scale(i, labels[1]) + " AT: " + i +"%");
        labels[2].setText("Percentage damage on Availability is : " + Driver.scale(a, labels[2]) + " AT: " + a +"%");
        labels[3].setText("Overall Performance of the Network is: " + Driver.overallPerformance(c, i, a, labels[3])  + " AT: " + roundOff(total) +"%");
        giveSuggestions(suggestionsArea, Driver.overallPerformance(c, i, a, labels[3]));
        
        for(int i = 0; i < labels.length; i++) {
            contentPanel.add(labels[i]);
        }
        contentPanel.add(suggestionsArea);
        
        parentFrame.add(contentPanel, new java.awt.GridBagConstraints());
    }
    
    public double roundOff(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
    
    public void giveSuggestions(javax.swing.JTextArea area, String performance) {
        area.setLineWrap(true);
        area.setEditable(false);
        
        if(performance.equalsIgnoreCase("POOR")) {
            
        } else if(performance.equalsIgnoreCase("AVERAGE")) {
            
        } else {
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Analysis(0).setVisible(true);
    }
}
