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
public class View2 extends javax.swing.JFrame implements java.awt.event.ActionListener {
    
    MyLocation.locationSetter obj = new MyLocation.locationSetter();
    public View2() {
        super("Network - Information Gathering");
        Driver.setFrameView();
        setGraphics(this);
        setVisible(true);
        setSize(700, 700);
        setLocation(obj.myWidth(this), obj.myHeight(this));
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    public void setGraphics(javax.swing.JFrame frame) {
        java.awt.Container parentFrame = frame.getContentPane();
        
        javax.swing.JTabbedPane tab = new javax.swing.JTabbedPane();
        tab.addTab("Asset Management", Component7.component7(tab));
        tab.addTab("Security Risk - A", Component8.component8(tab));
        tab.addTab("Security Risk - B", Component9.component9(tab, this));
        tab.addTab("Security Risk - C", Component10.component10(tab, this));
        tab.addTab("Security Risk - D", Component11.component11(tab, this));
        tab.addTab("Security Risk - E", Component12.component12(tab, this));
        
        parentFrame.add(tab);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        
    }
    
    public static void main(String[] args) {
        new View2().setVisible(true);
    }
}
