/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drone;

import views.View1;


/**
 *
 * @author OMOLARA A
 */
public class Drone extends javax.swing.JFrame implements java.awt.event.ActionListener {
    static public final String DRIVER = "com.mysql.jdbc.Driver";
    static public final String DATABASE = "jdbc:mysql://localhost:3306/drone";
    static public final String UR = "root";
    static public final String PR = "root";
    javax.swing.JButton consentButton;
    javax.swing.JLabel[] labels = new javax.swing.JLabel[5];
    javax.swing.JTextField[] fields = new javax.swing.JTextField[5];
    String[] texts = new String[] {"Expert's Name", "Designation", "Number of year(s) of experience", "Date", "Time"};
    MyLocation.locationSetter obj = new MyLocation.locationSetter();
    public static String name = "";
    static int oopt;
    
    public Drone() throws java.io.IOException, java.sql.SQLException {
        super("Home");
        Driver.setFrameView();
        usePrevious(this);
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
    
    public void getExpertTotal(javax.swing.JFrame frame) {
        int id = 0;
        int total = 0;
        String sql = "";
        String tot = "";
        String title = "Total Experts";
        String msg = "How many experts would you like to use";
        String msg2 = "Enter a name to save this session";
        tot = javax.swing.JOptionPane.showInputDialog(frame, msg, title, javax.swing.JOptionPane.QUESTION_MESSAGE);
        name = javax.swing.JOptionPane.showInputDialog(frame, msg2, title, javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(database.DatabaseHandler.checkName(name).equalsIgnoreCase("")){
            if(Driver.isInteger(tot)) {
                total = Integer.parseInt(tot);
                setGraphics(frame);
                sql = "INSERT INTO totals VALUES('"+id+"', '"+total+"', '"+name+"')";
                database.DatabaseHandler.insert(frame, sql);
            } else {
                Errors.invalidInput(frame);
            }
        } else {
            title = "Error";
            msg = "The name you picked is already in use. Try again with a different name";
            javax.swing.JOptionPane.showMessageDialog(frame, msg, title, javax.swing.JOptionPane.INFORMATION_MESSAGE);
            getExpertTotal(this);
        }
    }
    
    
    public void usePrevious(javax.swing.JFrame frame) throws java.io.IOException, java.sql.SQLException {
        int option = 0;
        String title = "Use previous data";
        String msg = "Would you like to use previous data";
        option = javax.swing.JOptionPane.showConfirmDialog(frame, msg, title, javax.swing.JOptionPane.YES_NO_OPTION);
        if(option == 0) {
            oopt = option;
            frame.dispose();
            new Analysis(option).setVisible(true);
        } else {
            getExpertTotal(frame);
        }
    }
       
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String name = "", designation = "", numYears = "";
        if(e.getSource() == consentButton) {
            name = fields[0].getText();
            designation = fields[1].getText();
            numYears = fields[2].getText();
            
            if(Driver.isValid(name, labels[0]) && Driver.isValid(designation, labels[1]) && Driver.isValid(numYears, labels[2])) {
                if(Driver.isInteger(numYears)) {
                    saveExpertData(name, designation, Integer.parseInt(numYears), fields[3].getText(), fields[4].getText(), this);
                    this.dispose();
                   new View1().setVisible(true);
                } else {
                    labels[2].setForeground(Driver.red);
                }
            } else {
                Errors.invalidInput(this);
            }
        }
    }  
   
    public static void saveExpertData(String name, String designation, int numYears, String date, String time, javax.swing.JFrame frame) {
        int id = 0;
        String sql = "INSERT INTO expertdata VALUES('"+id+"', '"+name+"', '"+designation+"', '"+numYears+"', '"+date+"', '"+time+"')";
        database.DatabaseHandler.insert(frame, sql);
    }
    
    public static void main(String[] args) throws java.io.IOException, java.sql.SQLException {
        new Drone().setVisible(true); 
    }
}
