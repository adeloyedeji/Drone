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
public class Component5 {
    
    static javax.swing.JLabel[] labels = new javax.swing.JLabel[14];
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[32];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[8];
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component5(final javax.swing.JTabbedPane pane) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 11, 2);
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
        
        //set text for the labels
        labels[0].setText("KEYS: 3 - YES | 2 - No | 1 - I DON'T KNOW | 0 - NOT AVAILABLE");
        labels[1].setText("3");
        labels[2].setText("2");
        labels[3].setText("1");
        labels[4].setText("0");
        labels[5].setText("Does your organization make necessary investigations about their staff prior to employment");
        labels[6].setText("Does your organization ensure that employed staff, contractors and third party users are aware of information security threats and concerns, their responsibilities and liabilites");
        labels[7].setText("Does your organization equipp the employed staff with access rights to support organizational security policy in the course of their normal work through:");
        labels[8].setText("Information security awareness");
        labels[9].setText("Education");
        labels[10].setText("Training");
        labels[11].setText("Does your organization remove the acces rights when employees, contractors and third party users exit the organization ?");
        labels[12].setText("Are systems left logged in while staffs are away ?");
        labels[13].setText("Does your organization keep the information that has been protected by an employee, if the employee resigns (confidentiality) ?");
        
        //adding the components into the contentPanel
        contentPanel.add(labels[0]);
        contentPanel.add(drone.Driver.groupLabel(labels[1], labels[2], labels[3], labels[4]));
        contentPanel.add(labels[5]);
        contentPanel.add(drone.Driver.groupPanel(buttons[0], buttons[1], buttons[2], buttons[3]));
        contentPanel.add(labels[6]);
        contentPanel.add(drone.Driver.groupPanel(buttons[4], buttons[5], buttons[6], buttons[7]));
        contentPanel.add(labels[7]);
        contentPanel.add(drone.Driver.hiddenPanel());
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
        contentPanel.add(nextButton);
        
        
        return contentPanel;
    }
}
