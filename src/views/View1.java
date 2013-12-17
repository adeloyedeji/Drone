/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import drone.Driver;

/**
 *
 * @author OMOLARA A
 */
public class View1 extends javax.swing.JFrame implements java.awt.event.ActionListener{
    MyLocation.locationSetter obj = new MyLocation.locationSetter();
    public View1() {
        super("Network - Information Gathering");
        Driver.setFrameView();
        setGraphics(this);
        setVisible(true);
        setSize(700, 700);
        setLocation(obj.myWidth(this), obj.myHeight(this));
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        //pack();
    }
    
    public void setGraphics(javax.swing.JFrame frame) {
        java.awt.Container parentFrame = frame.getContentPane();
        
        javax.swing.JTabbedPane tab = new javax.swing.JTabbedPane();
        tab.addTab("Network services", Component1.component1(tab));
        tab.addTab("Network Assets", Component2.component2(tab));
        tab.addTab("Network Security Information", Component3.component3(tab));
        tab.addTab("Network Countermeasures Applications", Component4.component4(tab));
        tab.addTab("Human Resources Security", Component5.component5(tab));
        tab.addTab("Security Management Information", Component6.component6(tab, this));
        
        parentFrame.add(tab);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == Component1.nextButton) {
            
        } else if(e.getSource() == Component2.nextButton) {
            
        }
    }
    
    public static void main(String[] args) {
        new View1().setVisible(true);
    }
}
