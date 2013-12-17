/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import drone.Driver;
import drone.Errors;

/**
 *
 * @author OMOLARA A
 */
public class View3 extends javax.swing.JFrame implements java.awt.event.ActionListener {
    
    javax.swing.JButton consentButton;
    javax.swing.JLabel[] labels = new javax.swing.JLabel[5];
    javax.swing.JTextField[] fields = new javax.swing.JTextField[5];
    String[] texts = new String[] {"Expert's Name", "Designation", "Number of year(s) of experience", "Date", "Time"};
    MyLocation.locationSetter obj = new MyLocation.locationSetter();
    
    public View3() {
        super("Consent Form");
        drone.Driver.setFrameView();
        setGraphics(this);
        setVisible(true);
        setSize(400, 500);
        setLocation(obj.myWidth(this), obj.myHeight(this));
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    public void setGraphics(javax.swing.JFrame frame) {
        java.awt.Container parentFrame = frame.getContentPane();
        parentFrame.setLayout(new java.awt.GridBagLayout());
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 11, 1);
        Driver.contentSize(contentPanel, 250, 400);
        Driver.contentBorder(contentPanel, "Consent Form");
        
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel(texts[i]);
        }
        for(int i = 0; i < fields.length; i++) {
            fields[i] = new javax.swing.JTextField();
        }        
        for(int i = 3; i <= 4; i++) {
            fields[i].setEnabled(false);
        }
        fields[3].setText(Driver.getCurrentDate());
        fields[4].setText(Driver.getCurrentTime());
        
        consentButton = new javax.swing.JButton("Aprrove Consent");
        consentButton.addActionListener(this);
        
        contentPanel.add(labels[0]);
        contentPanel.add(fields[0]);
        contentPanel.add(labels[1]);
        contentPanel.add(fields[1]);
        contentPanel.add(labels[2]);
        contentPanel.add(fields[2]);
        contentPanel.add(labels[3]);
        contentPanel.add(fields[3]);
        contentPanel.add(labels[4]);
        contentPanel.add(fields[4]);
        contentPanel.add(consentButton);
        
        parentFrame.add(contentPanel, new java.awt.GridBagConstraints());
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String name = "", designation = "", numYears = "";
        if(e.getSource() == consentButton) {
            name = fields[0].getText();
            designation = fields[1].getText();
            numYears = fields[2].getText();
            
            if(Driver.isValid(name, labels[0]) && Driver.isValid(designation, labels[1]) && Driver.isValid(numYears, labels[2])) {
                if(Driver.isInteger(numYears)) {
                    drone.Drone.saveExpertData(name, designation, Integer.parseInt(numYears), fields[3].getText(), fields[4].getText(), this);
                    this.dispose();
                    new View1().setVisible(true);
                    Component12.cTotal = Component12.cTotal - 1;
                } else {
                    labels[2].setForeground(Driver.red);
                }
            } else {
                Errors.invalidInput(this);
            }
        }
    }
    
    public static void main(String[] args) {
        new View3().setVisible(true);
    }
}
