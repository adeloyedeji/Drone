/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drone;


/**
 *
 * @author OMOLARA A
 */
public class Analysis extends javax.swing.JFrame {

    MyLocation.locationSetter obj = new MyLocation.locationSetter();
    javax.swing.JLabel[] labels = new javax.swing.JLabel[4];
    javax.swing.JScrollPane scroller;
    javax.swing.JTextArea suggestionsArea;
    double c = 30.0, i = 20.0, a = 50.0;
    static double total = 0.00;
    static int option = 0;
    public Analysis(int option) throws java.io.IOException, java.sql.SQLException {
        super("Network Performance Prediction System");
        //Driver.initiate();
        drone.Driver.setFrameView();
        Analysis.option = option;
        if(option == 0) {
            previousData(this);
        } else {
            //setGraphics(this, option);
        }
        setVisible(true);
        setSize(500, 700);
        setAlwaysOnTop(true);
        setLocation(obj.myWidth(this), obj.myHeight(this));
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    public void previousData(javax.swing.JFrame frame) throws java.sql.SQLException {
        java.awt.Container parentFrame = frame.getContentPane();
        parentFrame.setLayout(new java.awt.GridLayout(1, 1, 5, 5));
        
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setPreferredSize(Driver.size(this.getWidth(), this.getHeight()));
        contentPanel.setLayout(new java.awt.GridLayout(5, 1, 5, 5));
        
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel();
            Driver.setProperties(labels[i]);
        }
        suggestionsArea = new javax.swing.JTextArea();
        scroller = new javax.swing.JScrollPane(suggestionsArea);
        
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
    
    public void newData(javax.swing.JFrame frame, int option) throws java.sql.SQLException {
        java.awt.Container parentFrame = frame.getContentPane();
        parentFrame.setLayout(new java.awt.GridLayout(1, 1, 5, 5));
        
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setPreferredSize(Driver.size(this.getWidth(), this.getHeight()));
        contentPanel.setBackground(Driver.white);
        contentPanel.setLayout(new java.awt.GridLayout(5, 1, 5, 5));
        
        suggestionsArea = new javax.swing.JTextArea();
        scroller = new javax.swing.JScrollPane(suggestionsArea);
        //scroller.setVerticalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
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
    
    public void giveSuggestions(javax.swing.JTextArea area, String performance) throws java.sql.SQLException {
        area.setLineWrap(true);
        area.setEditable(false);
        String query = null;
        java.sql.ResultSet rss = null;
                
        if(performance.equalsIgnoreCase("POOR")) {
            query = "SELECT low FROM suggestions ORDER BY low LIMIT 0, 100";
            rss = database.AnalysisDatabase.getAdvice(query, "POOR");
            while(rss.next()) {
                for(int i = 0; i < 1; i++) {
                    area.append(rss.getString(i+1) + "\n");
                    area.append("____________________________________________________________\n");
                }
            }
        } else if(performance.equalsIgnoreCase("AVERAGE")) {
            query = "SELECT low FROM suggestions ORDER BY low LIMIT 0, 100";
            rss = database.AnalysisDatabase.getAdvice(query, "AVERAGE");
            while(rss.next()) {
                for(int i = 0; i < 1; i++) {
                    area.append(rss.getString(i+1) + "\n");
                    area.append("____________________________________________________________\n");
                }
            }
        } else {
            query = "SELECT low FROM suggestions ORDER BY low LIMIT 0, 100";
            rss = database.AnalysisDatabase.getAdvice(query, "HIGH");
            while(rss.next()) {
                for(int i = 0; i < 1; i++) {
                    area.append(rss.getString(i+1) + "\n");
                    area.append("____________________________________________________________\n");
                }
            }
        }
        rss.close();
    }
    
    public static void main(String[] args) throws java.io.IOException, java.sql.SQLException{
        new Analysis(option).setVisible(true);
    }
}
