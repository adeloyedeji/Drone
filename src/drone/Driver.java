/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drone;

/**
 *
 * @author OMOLARA A
 */
public class Driver {
    
    static public java.awt.Color red = new java.awt.Color(255, 0, 0);
    static public java.awt.Color green = new java.awt.Color(0, 200, 0);
    static public java.awt.Color blue = new java.awt.Color(51, 51, 255);
    static public java.awt.Color white = new java.awt.Color(255, 255, 255);
    static public java.awt.Font analysisFont = new java.awt.Font("Lucida Fax", 1, 12);
    
     public static String getCurrentDate(){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat now = new java.text.SimpleDateFormat("yyyy/MM/dd");
        return now.format(calendar.getTime());
    }
    
    public static String getCurrentTime(){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat now = new java.text.SimpleDateFormat("HH:mm:ss");
        return now.format(calendar.getTime());
    }
    
    public static void layoutFormat(javax.swing.JPanel panel, int row, int column) {
        panel.setLayout(new java.awt.GridLayout(row, column, 5, 5));
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException e) {
            e.printStackTrace();
            Errors.invalidInput(null);
            return false;
        }
        return true;
    }
        
    public static void contentSize(javax.swing.JPanel panel, int x, int y) {
        panel.setPreferredSize(new java.awt.Dimension(x, y));
    }
    
    public static boolean isValid(String str1, javax.swing.JLabel label) {
        if(str1.equalsIgnoreCase("")) {
            label.setForeground(red);
            return false;
        } else {
            label.setForeground(blue);
        }
        return true;
    }
    public static void contentBorder(javax.swing.JPanel panel, String title) {
        panel.setBorder(new javax.swing.border.TitledBorder(title));
    }
    
    public static void addGroup(javax.swing.ButtonGroup group, javax.swing.JRadioButton button1, javax.swing.JRadioButton button2, 
                                                         javax.swing.JRadioButton button3, javax.swing.JRadioButton button4) {
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
    }
    
    public static void addGroup(javax.swing.ButtonGroup group, javax.swing.JRadioButton button1, javax.swing.JRadioButton button2, 
                                                         javax.swing.JRadioButton button3, javax.swing.JRadioButton button4, 
                                                         javax.swing.JRadioButton button5) {
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
        group.add(button5);
    }
    
    public static javax.swing.JComponent groupPanel(javax.swing.JRadioButton button1, javax.swing.JRadioButton button2,
                                  javax.swing.JRadioButton button3, javax.swing.JRadioButton button4) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        layoutFormat(panel, 1, 4);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        
        return panel;
    }
    
    public static javax.swing.JComponent groupPanel(javax.swing.JRadioButton button1, javax.swing.JRadioButton button2,
                                  javax.swing.JRadioButton button3, javax.swing.JRadioButton button4, 
                                  javax.swing.JRadioButton button5) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        layoutFormat(panel, 1, 5);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        
        return panel;
    }
    
    public static javax.swing.JComponent groupLabel(javax.swing.JLabel label1, javax.swing.JLabel label2, 
                                  javax.swing.JLabel label3, javax.swing.JLabel label4) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        layoutFormat(panel, 1, 4);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        
        return panel;
    }
    
    public static javax.swing.JComponent groupLabel(javax.swing.JLabel label1, javax.swing.JLabel label2, 
                                  javax.swing.JLabel label3, javax.swing.JLabel label4, 
                                  javax.swing.JLabel label5) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        layoutFormat(panel, 1, 5);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        
        return panel;
    }
    
    public static javax.swing.JComponent hiddenPanel() {
        javax.swing.JLabel[] labels = new javax.swing.JLabel[4];
        javax.swing.JPanel panel = new javax.swing.JPanel();
        layoutFormat(panel, 1, 4);
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel("sdj");
            labels[i].setVisible(false);
            panel.add(labels[i]);
        }
        return panel;
    }
    
    public static javax.swing.JComponent hiddenPanel2() {
        javax.swing.JLabel[] labels = new javax.swing.JLabel[4];
        javax.swing.JPanel panel = new javax.swing.JPanel();
        layoutFormat(panel, 1, 5);
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel("sdj");
            labels[i].setVisible(false);
            panel.add(labels[i]);
        }
        return panel;
    }
    
    public static void setFrameView() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        // If Nimbus is not available, fall back to cross-platform
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
        // not worth my time
        }
        }
    }
    
    public static String scale(double value, javax.swing.JLabel label) {
        String scale = "";
        if(value >= 0.00 &&  value <= 24.00) {
            scale = "LOW";
            label.setForeground(Driver.green);
        } else if(value >= 25.00 && value <= 49.00) {
            scale = "MEDIUM";
            label.setForeground(Driver.blue);
        } else {
            scale = "HIGH";
            label.setForeground(Driver.red);
        }
        return scale;
    }
    
    public static String overallPerformance(double c, double i, double a, javax.swing.JLabel label) {
        double total = 0.00;
        String overallPerformance = "";
        total = (c + i + a) / 3;
        Analysis.total = total;
        overallPerformance = setPerformance(Analysis.total, label);
        System.out.println(Analysis.total);
        return overallPerformance;
    }
    
    public static String setPerformance(double value, javax.swing.JLabel label) {
        String performance = "";
        if(value >= 0.00 && value <= 24.00) {
            label.setForeground(Driver.green);
            performance = "EXCELLENT";
        } else if(value >= 25.00 && value <= 49.00)  {
            label.setForeground(Driver.blue);
            performance = "AVERAGE";
            System.out.println(label.getText());
        } else {
            label.setForeground(Driver.red);
            performance = "POOR";
        }
        return performance;
    }
    
    public static void setProperties(javax.swing.JLabel label) {
        label.setFont(Driver.analysisFont);
    }
    
    
    
    public static void initiate() throws java.io.IOException, java.sql.SQLException {
        new probabilities.helpers.PriorHelper();
        System.out.println("Prior Class started.");
        new probabilities.PosteriorDistribution();
        System.out.println("Posterior Class started.");
        new probabilities.JointProbabilities();
        System.out.println("JointProbabilities Class started.");
    }
    
    public static java.awt.Dimension size(int width, int height) {
        return new java.awt.Dimension(width, height);
    }
    
    public static void getSession(javax.swing.JFrame frame) {
        String msg2 = "Enter a name to save this session";
        String title = "Total Experts";
        Drone.name = javax.swing.JOptionPane.showInputDialog(frame, msg2, title, javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(Drone.name.equalsIgnoreCase("")) {
            getSession(frame);
        }
        if(database.DatabaseHandler.checkName(Drone.name).equalsIgnoreCase("")){
            //Drone.name = name;
            new views.View3().setVisible(true);
        } else {
            Errors.invalidInput(frame);
        }
    }
}
