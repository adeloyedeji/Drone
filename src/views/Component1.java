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
public class Component1 {
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[36];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[9];
    static javax.swing.JLabel[] labels = new javax.swing.JLabel[15];
    static javax.swing.JTextField softwareField;
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component1(final javax.swing.JTabbedPane pane) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 12, 2);
        Driver.contentSize(contentPanel, 500, 700);
        //defining objects
        Driver.contentBorder(contentPanel, "To have a full knowledge of the network domain resources and processes");
        softwareField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                pane.setSelectedIndex(pane.getSelectedIndex() + 1);
                //write code here to collect selected values
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
        //add the individual buttons to a buttongroup
        drone.Driver.addGroup(groups[0], buttons[0], buttons[1], buttons[2], buttons[3]);
        drone.Driver.addGroup(groups[1], buttons[4], buttons[5], buttons[6], buttons[7]);
        drone.Driver.addGroup(groups[2], buttons[8], buttons[9], buttons[10], buttons[11]);
        drone.Driver.addGroup(groups[3], buttons[12], buttons[13], buttons[14], buttons[15]);
        drone.Driver.addGroup(groups[4], buttons[16], buttons[17], buttons[18], buttons[19]);
        drone.Driver.addGroup(groups[5], buttons[20], buttons[21], buttons[22], buttons[23]);
        drone.Driver.addGroup(groups[6], buttons[24], buttons[25], buttons[26], buttons[27]);
        drone.Driver.addGroup(groups[7], buttons[28], buttons[29], buttons[30], buttons[31]);
        drone.Driver.addGroup(groups[8], buttons[32], buttons[33], buttons[34], buttons[35]);
        
        labels[0].setText("KEYS: 3 - YES | 2 - No | 1 - I DON'T KNOW | 0 - NOT AVAILABLE");
        labels[1].setText("3");
        labels[2].setText("2");
        labels[3].setText("1");
        labels[4].setText("0");
        labels[5].setText("Does your organization expose her network to the public ?");
        labels[6].setText("Does your organization expose her network to the internet(E.g. Web, Database, FTP, SSH, e.t.c) ?");
        labels[7].setText("Does your organization have amy dedicated connections to other organizations network(vendors, business partners) ?");
        labels[8].setText("Does your organization alloe the use of peer-to-peer file sharing software(E.g. BitTorrent, eDonkey, e.t.c) ?");
        labels[9].setText("Do you use authentication for your web services ?");
        labels[10].setText("Are there any peak processing periods ?");
        labels[11].setText("What software do you use for your web services ?");
        labels[12].setText("Open source");
        labels[13].setText("Property");
        labels[14].setText("Commercial");
        
        //adding the components to the contentPanel
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
        contentPanel.add(drone.Driver.groupPanel(buttons[20], buttons[21], buttons[22], buttons[23]));
        contentPanel.add(labels[11]);
        contentPanel.add(softwareField);
        contentPanel.add(labels[12]);
        contentPanel.add(drone.Driver.groupPanel(buttons[24], buttons[25], buttons[26], buttons[27]));
        contentPanel.add(labels[13]);
        contentPanel.add(drone.Driver.groupPanel(buttons[28], buttons[29], buttons[30], buttons[31]));
        contentPanel.add(labels[14]);
        contentPanel.add(drone.Driver.groupPanel(buttons[32], buttons[33], buttons[34], buttons[35]));
        contentPanel.add(nextButton);
        
        return contentPanel;
    }
}
