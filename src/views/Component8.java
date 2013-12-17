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
public class Component8 {
    
    static javax.swing.JLabel[] labels = new javax.swing.JLabel[26];
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[55];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[11];
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component8(final javax.swing.JTabbedPane pane) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 19, 2);
        Driver.contentSize(contentPanel, 500, 700);
        Driver.contentBorder(contentPanel, "PURPOSE: To know the likelihood of occurence and the impact or the consequences of the netvork security risks being on the three(3) network security objectives ");
        
        //define objects
        nextButton = new javax.swing.JButton("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                pane.setSelectedIndex(pane.getSelectedIndex() + 1);
            }
        });
        for(int i = 0; i < labels.length; i++) {
            labels[i] = new javax.swing.JLabel();
        }
        for(int i = 0; i< buttons.length; i++) {
            buttons[i] = new javax.swing.JRadioButton();
        }
        for(int i = 0; i < groups.length; i++) {
            groups[i] = new javax.swing.ButtonGroup();
        }
        
        //adding individual radiobuttons to its group
        drone.Driver.addGroup(groups[0], buttons[0], buttons[1], buttons[2], buttons[3], buttons[4]);
        drone.Driver.addGroup(groups[1], buttons[5], buttons[6], buttons[7], buttons[8], buttons[9]);
        drone.Driver.addGroup(groups[2], buttons[10], buttons[11], buttons[12], buttons[13], buttons[14]);
        drone.Driver.addGroup(groups[3], buttons[15], buttons[16], buttons[17], buttons[18], buttons[19]);
        drone.Driver.addGroup(groups[4], buttons[20], buttons[21], buttons[22], buttons[23], buttons[24]);
        drone.Driver.addGroup(groups[5], buttons[25], buttons[26], buttons[27], buttons[28], buttons[29]);
        drone.Driver.addGroup(groups[6], buttons[30], buttons[31], buttons[32], buttons[33], buttons[34]);
        drone.Driver.addGroup(groups[7], buttons[35], buttons[36], buttons[37], buttons[38], buttons[39]);
        drone.Driver.addGroup(groups[8], buttons[40], buttons[41], buttons[42], buttons[43], buttons[44]);
        drone.Driver.addGroup(groups[9], buttons[45], buttons[46], buttons[47], buttons[48], buttons[49]);
        drone.Driver.addGroup(groups[10], buttons[50], buttons[51], buttons[52], buttons[53], buttons[54]);
        
        //set the text for each labels
        labels[0].setText("i. Confidentiality: This gives assurance that informattion is not disclosed to unauthorized individuals, processes, or devices");
        labels[1].setText("ii. Integrity: This ensures that information or software is complete, accurate and authentic.");
        labels[2].setText("iii. Availability: This ensures that information and services are accessible and functional when needed");
        labels[3].setText("KEYS: 4 - CERTAIN (100%) is defined as having a definite chance of occurrence");
        labels[4].setText("3 - LIKELY (75%) is defined as having a significant chance of occurrence");
        labels[5].setText("2 - 50 - 50 CHANCE (50%) is defined as equally probable chance of occurrence");
        labels[6].setText("1 - NOT LIKELY (25%) is defined as a modest or insignificant chance of occurrence");
        labels[7].setText("0 - UNCERTAIN (0%) is defined as having a indefinite chance of occurrence");
        labels[8].setText("4 - 100 %");
        labels[9].setText("3 - 75 %");
        labels[10].setText("2 - 50 %");
        labels[11].setText("1 - 25 %");
        labels[12].setText("0 - 0 %");
        labels[13].setText("In a typical day, what is the likelihood of network downtime occuring ?");
        labels[14].setText("How often the following factors are the causes of threat in your network  and result in communication disruption ?");
        labels[15].setText("i. Technological");
        labels[16].setText("ii. Man-made");
        labels[17].setText("iii. Natural");
        labels[18].setText("How vulnerable is the network, host and application(s) to attacks from the internet or intranet ?");
        labels[19].setText("How would you rate the amount of down time through incidents and failures");
        labels[20].setText("What is the probability that an intruder obtain unauthorized access to your critical resources");
        labels[21].setText("In a typical week, how will you rate the occurence of the following type of risk");
        labels[22].setText("i. Leakage of information");
        labels[23].setText("ii. Accessibility to information");
        labels[24].setText("iii. Modification of information in the wrong way");
        labels[25].setText("iv. Other risks and threats");
        
        //adding the components into the contentPanel
        contentPanel.add(labels[0]);
        contentPanel.add(labels[1]);
        contentPanel.add(labels[2]);
        contentPanel.add(labels[3]);
        contentPanel.add(labels[4]);
        contentPanel.add(labels[5]);
        contentPanel.add(labels[6]);
        contentPanel.add(labels[7]);
        contentPanel.add(drone.Driver.hiddenPanel2());
        contentPanel.add(drone.Driver.groupLabel(labels[8], labels[9], labels[10], labels[11], labels[12]));
        contentPanel.add(labels[13]);
        contentPanel.add(drone.Driver.groupPanel(buttons[0], buttons[1], buttons[2], buttons[3], buttons[4]));
        contentPanel.add(labels[14]);
        contentPanel.add(drone.Driver.hiddenPanel2());
        contentPanel.add(labels[15]);
        contentPanel.add(drone.Driver.groupPanel(buttons[5], buttons[6], buttons[7], buttons[8], buttons[9]));
        contentPanel.add(labels[16]);
        contentPanel.add(drone.Driver.groupPanel(buttons[10], buttons[11], buttons[12], buttons[13], buttons[14]));
        contentPanel.add(labels[17]);
        contentPanel.add(drone.Driver.groupPanel(buttons[15], buttons[16], buttons[17], buttons[18], buttons[19]));
        contentPanel.add(labels[18]);
        contentPanel.add(drone.Driver.groupPanel(buttons[20], buttons[21], buttons[22], buttons[23], buttons[24]));
        contentPanel.add(labels[19]);
        contentPanel.add(drone.Driver.groupPanel(buttons[25], buttons[26], buttons[27], buttons[28], buttons[29]));
        contentPanel.add(labels[20]);
        contentPanel.add(drone.Driver.groupPanel(buttons[30], buttons[31], buttons[32], buttons[33], buttons[34]));
        contentPanel.add(labels[21]);
        contentPanel.add(drone.Driver.hiddenPanel2());
        contentPanel.add(labels[22]);
        contentPanel.add(drone.Driver.groupPanel(buttons[35], buttons[36], buttons[37], buttons[38], buttons[39]));
        contentPanel.add(labels[23]);
        contentPanel.add(drone.Driver.groupPanel(buttons[40], buttons[41], buttons[42], buttons[43], buttons[44]));
        contentPanel.add(labels[24]);
        contentPanel.add(drone.Driver.groupPanel(buttons[45], buttons[46], buttons[47], buttons[48], buttons[49]));
        contentPanel.add(labels[25]);
        contentPanel.add(drone.Driver.groupPanel(buttons[50], buttons[51], buttons[52], buttons[53], buttons[54]));
        contentPanel.add(nextButton);
        
        return contentPanel;
    }
}
