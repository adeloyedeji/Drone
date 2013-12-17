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
public class Component7 {

    static javax.swing.JLabel[] labels = new javax.swing.JLabel[23];
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[80];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[20];
    static javax.swing.JTextField[] fields = new javax.swing.JTextField[6];
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component7(final javax.swing.JTabbedPane pane) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 25, 2);
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
        for(int i = 0; i < fields.length; i++) {
            fields[i] = new javax.swing.JTextField();
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
        
        //set the text for individual buttons
        labels[0].setText("KEYS: 3 - High criticality: The organization cannot achieve its mission at all without these assets or services");
        labels[1].setText("2 - Medium Criticality: The organization cannot achieve efficiently its mission without these assets or services");
        labels[2].setText("1 - Low Criticality: The organization can achieve its mission without these asset or services");
        labels[3].setText("0 - Null Criticality or not applicable: Our network domain does not have such asset or needs OR I do not want to consider this asset");
        labels[4].setText("3");
        labels[5].setText("2");
        labels[6].setText("1");
        labels[7].setText("0");
        labels[8].setText("In your network domain, how would you classify the criticality of the following assets ? Pls. add more");
        labels[9].setText("i. Mail Servers");
        labels[10].setText("ii. Application Servers");
        labels[11].setText("iii. Backup Facilities");
        labels[12].setText("iv. Power Facilities");
        labels[13].setText("v. Desktops");
        labels[14].setText("vi. Gateways");
        labels[15].setText("vii. Routers");
        labels[16].setText("viii. Switches");
        labels[17].setText("ix. Hubs");
        labels[18].setText("x. Web Servers");
        labels[19].setText("xi. DNS Servers");
        labels[20].setText("xii. Databases");
        labels[21].setText("xiii. Application Servers");
        labels[22].setText("xiv. Test and Development Servers");
        
        //adding the components into the contentPanel
        contentPanel.add(labels[0]);
        contentPanel.add(labels[1]);
        contentPanel.add(labels[2]);
        contentPanel.add(labels[3]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(drone.Driver.groupLabel(labels[4], labels[5], labels[6], labels[7]));
        contentPanel.add(labels[8]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[9]);
        contentPanel.add(drone.Driver.groupPanel(buttons[0], buttons[1], buttons[2], buttons[3]));
        contentPanel.add(labels[10]);
        contentPanel.add(drone.Driver.groupPanel(buttons[4], buttons[5], buttons[6], buttons[7]));
        contentPanel.add(labels[11]);
        contentPanel.add(drone.Driver.groupPanel(buttons[8], buttons[9], buttons[10], buttons[11]));
        contentPanel.add(labels[12]);
        contentPanel.add(drone.Driver.groupPanel(buttons[12], buttons[13], buttons[14], buttons[15]));
        contentPanel.add(labels[13]);
        contentPanel.add(drone.Driver.groupPanel(buttons[16], buttons[17], buttons[18], buttons[19]));
        contentPanel.add(labels[14]);
        contentPanel.add(drone.Driver.groupPanel(buttons[20], buttons[21], buttons[22], buttons[23]));
        contentPanel.add(labels[15]);
        contentPanel.add(drone.Driver.groupPanel(buttons[24], buttons[25], buttons[26], buttons[27]));
        contentPanel.add(labels[16]);
        contentPanel.add(drone.Driver.groupPanel(buttons[28], buttons[29], buttons[30], buttons[31]));
        contentPanel.add(labels[17]);
        contentPanel.add(drone.Driver.groupPanel(buttons[32], buttons[33], buttons[34], buttons[35]));
        contentPanel.add(labels[18]);
        contentPanel.add(drone.Driver.groupPanel(buttons[36], buttons[37], buttons[38], buttons[39]));
        contentPanel.add(labels[19]);
        contentPanel.add(drone.Driver.groupPanel(buttons[40], buttons[41], buttons[42], buttons[43]));
        contentPanel.add(labels[20]);
        contentPanel.add(drone.Driver.groupPanel(buttons[44], buttons[45], buttons[46], buttons[47]));
        contentPanel.add(labels[21]);
        contentPanel.add(drone.Driver.groupPanel(buttons[48], buttons[49], buttons[50], buttons[51]));
        contentPanel.add(labels[22]);
        contentPanel.add(drone.Driver.groupPanel(buttons[52], buttons[53], buttons[54], buttons[55]));
        contentPanel.add(fields[0]);
        contentPanel.add(drone.Driver.groupPanel(buttons[56], buttons[57], buttons[58], buttons[59]));
        contentPanel.add(fields[1]);
        contentPanel.add(drone.Driver.groupPanel(buttons[60], buttons[61], buttons[62], buttons[63]));
        contentPanel.add(fields[2]);
        contentPanel.add(drone.Driver.groupPanel(buttons[64], buttons[65], buttons[66], buttons[67]));
        contentPanel.add(fields[3]);
        contentPanel.add(drone.Driver.groupPanel(buttons[68], buttons[69], buttons[70], buttons[71]));
        contentPanel.add(fields[4]);
        contentPanel.add(drone.Driver.groupPanel(buttons[72], buttons[73], buttons[74], buttons[75]));
        contentPanel.add(fields[5]);
        contentPanel.add(drone.Driver.groupPanel(buttons[76], buttons[77], buttons[78], buttons[79]));
        contentPanel.add(nextButton);
        
        
        return contentPanel;
    }
}
