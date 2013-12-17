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
public class Component4 {
    
    static javax.swing.JLabel[] labels = new javax.swing.JLabel[32];
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[100];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[25];
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component4(final javax.swing.JTabbedPane pane) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 29, 2);   //you can change 29 to 15
        Driver.contentSize(contentPanel, 500, 700);
        Driver.contentBorder(contentPanel, "To have a full knowledge of the network domain resources and processes");
        
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
        drone.Driver.addGroup(groups[0], buttons[0], buttons[1], buttons[2], buttons[3]);
        drone.Driver.addGroup(groups[1], buttons[4], buttons[5], buttons[6], buttons[7]);
        drone.Driver.addGroup(groups[2], buttons[8], buttons[9], buttons[10], buttons[11]);
        drone.Driver.addGroup(groups[3], buttons[12], buttons[13], buttons[14], buttons[15]);
        drone.Driver.addGroup(groups[4], buttons[16], buttons[17], buttons[18], buttons[19]);
        drone.Driver.addGroup(groups[5], buttons[20], buttons[21], buttons[22], buttons[23]);
        drone.Driver.addGroup(groups[6], buttons[24], buttons[25], buttons[26], buttons[27]);
        drone.Driver.addGroup(groups[7], buttons[28], buttons[29], buttons[30], buttons[31]);
        drone.Driver.addGroup(groups[8], buttons[32], buttons[33], buttons[34], buttons[35]);
        drone.Driver.addGroup(groups[9], buttons[36], buttons[37], buttons[38], buttons[39]);
        drone.Driver.addGroup(groups[10], buttons[40], buttons[41], buttons[42], buttons[43]);
        drone.Driver.addGroup(groups[11], buttons[44], buttons[45], buttons[46], buttons[47]);
        drone.Driver.addGroup(groups[12], buttons[48], buttons[49], buttons[50], buttons[51]);
        drone.Driver.addGroup(groups[13], buttons[52], buttons[53], buttons[54], buttons[55]);
        drone.Driver.addGroup(groups[14], buttons[56], buttons[57], buttons[58], buttons[59]);
        drone.Driver.addGroup(groups[15], buttons[60], buttons[61], buttons[62], buttons[63]);
        drone.Driver.addGroup(groups[16], buttons[64], buttons[65], buttons[66], buttons[67]);
        drone.Driver.addGroup(groups[17], buttons[68], buttons[69], buttons[70], buttons[71]);
        drone.Driver.addGroup(groups[18], buttons[72], buttons[73], buttons[74], buttons[75]);
        drone.Driver.addGroup(groups[19], buttons[76], buttons[77], buttons[78], buttons[79]);
        drone.Driver.addGroup(groups[21], buttons[80], buttons[81], buttons[82], buttons[83]);
        drone.Driver.addGroup(groups[21], buttons[84], buttons[85], buttons[86], buttons[87]);
        drone.Driver.addGroup(groups[22], buttons[88], buttons[89], buttons[90], buttons[91]);
        drone.Driver.addGroup(groups[23], buttons[92], buttons[93], buttons[94], buttons[95]);
        drone.Driver.addGroup(groups[24], buttons[96], buttons[97], buttons[98], buttons[99]);
        
        //set text for the labels
        labels[0].setText("KEYS: 3 - YES | 2 - No | 1 - I DON'T KNOW | 0 - NOT AVAILABLE");
        labels[1].setText("3");
        labels[2].setText("2");
        labels[3].setText("1");
        labels[4].setText("0");
        labels[5].setText("Does your organization use a local intrusion detection system(s) IDS ?");
        labels[6].setText("Does your organization use a local intrusion prevention system(s) IPS ?");
        labels[7].setText("Does your organization implant a local firewall for all connections with external networks ?");
        labels[8].setText("Does your organization use any anti-virus / anti-malware application for all windows PCs connected to the organization network ?");
        labels[9].setText("Does your organization has a backup hardware and applications in use");
        labels[10].setText("Is your anti-virus application implemented using:");
        labels[11].setText("A managed client/server architecture");
        labels[12].setText("A stand-alone configuration");
        labels[13].setText("Are anti-virus / anti-malware signatures up to date ? ");
        labels[14].setText("Is your patching up to date ?");
        labels[15].setText("Do you have effective operational controls");
        labels[16].setText("Are there appropriate environmental controls in place for securing servers and desktop machines ?");
        labels[17].setText("Are appropriate environmental controls in place to sustain critical computing infrastructure ?");
        labels[18].setText("Where applicable, have the following controls been considered:");
        labels[19].setText("Physical and environmental security");
        labels[20].setText("Visitor and employee identification measures for building access control");
        labels[21].setText("Physical entry controls");
        labels[22].setText("Building evacuation procedures / signs been posted throughtout the building");
        labels[23].setText("Fire alarm system");
        labels[24].setText("Appropriate fire suppresion system");
        labels[25].setText("Electrical power backup");
        labels[26].setText("Temperature / humidity control system");
        labels[27].setText("Equipment security / personnel safety");
        labels[28].setText("Are your social engineering techniques effective ?");
        labels[29].setText("Do you use Access Control Lists (ACLs) in your network ?");
        labels[30].setText("Are there procedures and policies to follow to guard the availability of information ? e.g. if key person is sick or disappears");
        labels[31].setText("Does your organization track who did what at what time with some information ?");
        
        //adding the components into the contentPanel
        contentPanel.add(labels[0]);
        contentPanel.add(drone.Driver.groupLabel(labels[1], labels[2], labels[3], labels[4]));
        contentPanel.add(labels[5]);
        contentPanel.add(drone.Driver.groupPanel(buttons[0], buttons[1], buttons[2], buttons[3]));
        contentPanel.add(labels[6]);
        contentPanel.add(drone.Driver.groupPanel(buttons[4], buttons[5], buttons[6], buttons[7]));
        contentPanel.add(labels[7]);
        contentPanel.add(drone.Driver.groupPanel(buttons[8], buttons[9], buttons[10], buttons[11]));
        contentPanel.add(labels[8]);
        contentPanel.add(drone.Driver.groupPanel(buttons[12], buttons[13], buttons[14], buttons[15]));
        contentPanel.add(labels[9]);
        contentPanel.add(drone.Driver.groupPanel(buttons[16], buttons[17], buttons[18], buttons[19]));
        contentPanel.add(labels[10]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[11]);
        contentPanel.add(drone.Driver.groupPanel(buttons[20], buttons[21], buttons[22], buttons[23]));
        contentPanel.add(labels[12]);
        contentPanel.add(drone.Driver.groupPanel(buttons[24], buttons[25], buttons[26], buttons[27]));
        contentPanel.add(labels[13]);
        contentPanel.add(drone.Driver.groupPanel(buttons[28], buttons[29], buttons[30], buttons[31]));
        contentPanel.add(labels[14]);
        contentPanel.add(drone.Driver.groupPanel(buttons[32], buttons[33], buttons[34], buttons[35]));
        contentPanel.add(labels[15]);
        contentPanel.add(drone.Driver.groupPanel(buttons[36], buttons[37], buttons[38], buttons[39]));
        contentPanel.add(labels[16]);
        contentPanel.add(drone.Driver.groupPanel(buttons[40], buttons[41], buttons[42], buttons[43]));
        contentPanel.add(labels[17]);
        contentPanel.add(drone.Driver.groupPanel(buttons[44], buttons[45], buttons[46], buttons[47]));
        contentPanel.add(labels[18]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[19]);
        contentPanel.add(drone.Driver.groupPanel(buttons[48], buttons[49], buttons[50], buttons[51]));
        contentPanel.add(labels[20]);
        contentPanel.add(drone.Driver.groupPanel(buttons[52], buttons[53], buttons[54], buttons[55]));
        contentPanel.add(labels[21]);
        contentPanel.add(drone.Driver.groupPanel(buttons[56], buttons[57], buttons[58], buttons[59]));
        contentPanel.add(labels[22]);
        contentPanel.add(drone.Driver.groupPanel(buttons[60], buttons[61], buttons[62], buttons[63]));
        contentPanel.add(labels[23]);
        contentPanel.add(drone.Driver.groupPanel(buttons[64], buttons[65], buttons[66], buttons[67]));
        contentPanel.add(labels[24]);
        contentPanel.add(drone.Driver.groupPanel(buttons[68], buttons[69], buttons[70], buttons[71]));
        contentPanel.add(labels[25]);
        contentPanel.add(drone.Driver.groupPanel(buttons[72], buttons[73], buttons[74], buttons[75]));
        contentPanel.add(labels[26]);
        contentPanel.add(drone.Driver.groupPanel(buttons[76], buttons[77], buttons[78], buttons[79]));
        contentPanel.add(labels[27]);
        contentPanel.add(drone.Driver.groupPanel(buttons[80], buttons[81], buttons[82], buttons[83]));
        contentPanel.add(labels[28]);
        contentPanel.add(drone.Driver.groupPanel(buttons[84], buttons[85], buttons[86], buttons[87]));
        contentPanel.add(labels[29]);
        contentPanel.add(drone.Driver.groupPanel(buttons[88], buttons[89], buttons[90], buttons[91]));
        contentPanel.add(labels[30]);
        contentPanel.add(drone.Driver.groupPanel(buttons[92], buttons[93], buttons[94], buttons[95]));
        contentPanel.add(labels[31]);
        contentPanel.add(drone.Driver.groupPanel(buttons[96], buttons[97], buttons[98], buttons[99]));
        contentPanel.add(nextButton);
        
        return contentPanel;
    }
}
