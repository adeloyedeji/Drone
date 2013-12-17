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
public class Component3 {
    
    static javax.swing.JLabel[] labels = new javax.swing.JLabel[18];
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[48];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[12];
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component3(final javax.swing.JTabbedPane pane) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 15, 2);
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
        for(int i = 0; i < buttons.length; i++) {
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
        
        //set text for the labels
        labels[0].setText("KEYS: 3 - YES | 2 - No | 1 - I DON'T KNOW | 0 - NOT AVAILABLE");
        labels[1].setText("3");
        labels[2].setText("2");
        labels[3].setText("1");
        labels[4].setText("0");
        labels[5].setText("What are the most significant threats to your system? would they incluse some of the following:");
        labels[6].setText("Denial of systems services");
        labels[7].setText("Disruption of systems services");
        labels[8].setText("Unauthorized monitoring of systems services");
        labels[9].setText("Disclosure of proprietary or private information");
        labels[10].setText("Modification or destruction of related computer capabilities e.g. networks, databases");
        labels[11].setText("Manipulation of computer or communication services resulting in fraud, financial loss etc");
        labels[12].setText("Has your organization ever been compromised (internally or externally) ?");
        labels[13].setText("Has an intruder obtained unauthorized access to your critical resources?");
        labels[14].setText("Has a malicious user access, modify or destroy data or services within your system ?");
        labels[15].setText("Does the network applications expose the underlying servers within your system ?");
        labels[16].setText("Is important network equipment protected from power failure and other disruptions caused by failures in supporting faicilites?");
        labels[17].setText("Do the employees in your organization know about the security operational risks(risk awareness, risk culture) ?");
        
         //adding the components into the contentPanel
        contentPanel.add(labels[0]);
        contentPanel.add(drone.Driver.groupLabel(labels[1], labels[2], labels[3], labels[4]));
        contentPanel.add(labels[5]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[6]);
        contentPanel.add(drone.Driver.groupPanel(buttons[0], buttons[1], buttons[2], buttons[3]));
        contentPanel.add(labels[7]);
        contentPanel.add(drone.Driver.groupPanel(buttons[4], buttons[5], buttons[6], buttons[7]));
        contentPanel.add(labels[8]);
        contentPanel.add(drone.Driver.groupPanel(buttons[8], buttons[9], buttons[10], buttons[11]));
        contentPanel.add(labels[9]);
        contentPanel.add(drone.Driver.groupPanel(buttons[12], buttons[13], buttons[14], buttons[15]));
        contentPanel.add(labels[10]);
        contentPanel.add(drone.Driver.groupPanel(buttons[16], buttons[17], buttons[18], buttons[19]));
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
        contentPanel.add(nextButton);
        
        
        return contentPanel;
    }
}
