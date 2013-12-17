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
public class Component6 {
    
    static javax.swing.JLabel[] labels = new javax.swing.JLabel[56];
    static javax.swing.JRadioButton[] buttons = new javax.swing.JRadioButton[160];
    static javax.swing.ButtonGroup[] groups = new javax.swing.ButtonGroup[40];
    static javax.swing.JButton nextButton;
    
    public static javax.swing.JComponent component6(final javax.swing.JTabbedPane pane, final javax.swing.JFrame frame) {
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        Driver.layoutFormat(contentPanel, 27, 2);
        Driver.contentSize(contentPanel, 500, 700);
        Driver.contentBorder(contentPanel, "To have a full knowledge of the network domain resources and processes");
        
        //define objects
        nextButton = new javax.swing.JButton("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
                new View2().setVisible(true);
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
        drone.Driver.addGroup(groups[20], buttons[80], buttons[81], buttons[82], buttons[83]);
        drone.Driver.addGroup(groups[21], buttons[84], buttons[85], buttons[86], buttons[87]);
        drone.Driver.addGroup(groups[22], buttons[88], buttons[89], buttons[90], buttons[91]);
        drone.Driver.addGroup(groups[23], buttons[92], buttons[93], buttons[94], buttons[95]);
        drone.Driver.addGroup(groups[24], buttons[96], buttons[97], buttons[98], buttons[99]);
        drone.Driver.addGroup(groups[25], buttons[100], buttons[101], buttons[102], buttons[103]);
        drone.Driver.addGroup(groups[26], buttons[104], buttons[105], buttons[106], buttons[107]);
        drone.Driver.addGroup(groups[27], buttons[108], buttons[109], buttons[110], buttons[111]);
        drone.Driver.addGroup(groups[28], buttons[112], buttons[113], buttons[114], buttons[115]);
        drone.Driver.addGroup(groups[29], buttons[116], buttons[117], buttons[118], buttons[119]);
        drone.Driver.addGroup(groups[30], buttons[120], buttons[121], buttons[122], buttons[123]);
        drone.Driver.addGroup(groups[31], buttons[124], buttons[125], buttons[126], buttons[127]);
        drone.Driver.addGroup(groups[32], buttons[128], buttons[129], buttons[130], buttons[131]);
        drone.Driver.addGroup(groups[33], buttons[132], buttons[133], buttons[134], buttons[135]);
        drone.Driver.addGroup(groups[34], buttons[136], buttons[137], buttons[138], buttons[139]);
        drone.Driver.addGroup(groups[35], buttons[140], buttons[141], buttons[142], buttons[143]);
        drone.Driver.addGroup(groups[36], buttons[144], buttons[145], buttons[146], buttons[147]);
        drone.Driver.addGroup(groups[37], buttons[148], buttons[149], buttons[150], buttons[151]);
        drone.Driver.addGroup(groups[38], buttons[152], buttons[153], buttons[154], buttons[155]);
        drone.Driver.addGroup(groups[39], buttons[156], buttons[157], buttons[158], buttons[159]);
        
        //set text for the labels
        labels[0].setText("KEYS: 3 - YES | 2 - No | 1 - I DON'T KNOW | 0 - NOT AVAILABLE");
        labels[1].setText("3");
        labels[2].setText("2");
        labels[3].setText("1");
        labels[4].setText("0");
        labels[5].setText("In a typical week, what is the volume of network traffic ?");
        labels[6].setText("i. Less than 10, 000  traffics ?");
        labels[7].setText("ii. Between 10, 000 to 50, 000 traffics ?");
        labels[8].setText("iii. More than 50, 000 traffics ?");
        labels[9].setText("How often are logs reviewed ?");
        labels[10].setText("i. Hourly");
        labels[11].setText("ii. Daily");
        labels[12].setText("iii. Weekly");
        labels[13].setText("iv. Monthly");
        labels[14].setText("v. Yearly");
        labels[15].setText("How often are you performing vulnerability scanning ?");
        labels[16].setText("i. Hourly");
        labels[17].setText("ii. Daily");
        labels[18].setText("iii. Weekly");
        labels[19].setText("iv. Monthly");
        labels[20].setText("v. Yearly");
        labels[21].setText("How often are your systems patched ?");
        labels[22].setText("i. Automatically (as at when needed)");
        labels[23].setText("ii. Hourly");
        labels[24].setText("iii. Daily");
        labels[25].setText("How often is the documented inventory list hardware assets reviewed and updated ?");
        labels[26].setText("i. Hourly");
        labels[27].setText("ii. Daily");
        labels[28].setText("iii. Weekly");
        labels[29].setText("iv. Monthly");
        labels[30].setText("v. Yearly");
        labels[31].setText("How often is the antivirus software reviewed and updated ?");
        labels[32].setText("i. Hourly");
        labels[33].setText("ii. Daily");
        labels[34].setText("iii. Weekly");
        labels[35].setText("iv. Monthly");
        labels[36].setText("v. Yearly");
        labels[37].setText("How often is the firewall configuration reviewed and updated ?");
        labels[38].setText("i. Hourly");
        labels[39].setText("ii. Daily");
        labels[40].setText("iii. Weekly");
        labels[41].setText("iv. Monthly");
        labels[42].setText("v. Yearly");
        labels[43].setText("How much downtime can your network afford in the event of a disaster ?");
        labels[44].setText("i. Less than 1 hour");
        labels[45].setText("ii. > 1 hour but < 24 hours");
        labels[46].setText("iii. > 24 hours but less than 48 hours");
        labels[47].setText("In a typical day, what is the frequency of technological factors causing a downtime ?");
        labels[48].setText("i. 24 hours ");
        labels[49].setText("ii. < 24hours");
        labels[50].setText("In a typical day, what is the frequency of man-made factors causing a downtime ?");
        labels[51].setText("i. 24 hours ");
        labels[52].setText("ii. < 24hours ");
        labels[53].setText("In a typical day, what is the frequency of natural events causing a downtime");
        labels[54].setText("i. 24 hours ");
        labels[55].setText("ii. < 24hours ");
        
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
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[10]);
        contentPanel.add(drone.Driver.groupPanel(buttons[12], buttons[13], buttons[14], buttons[15]));
        contentPanel.add(labels[11]);
        contentPanel.add(drone.Driver.groupPanel(buttons[16], buttons[17], buttons[18], buttons[19]));
        contentPanel.add(labels[12]);
        contentPanel.add(drone.Driver.groupPanel(buttons[20], buttons[21], buttons[22], buttons[23]));
        contentPanel.add(labels[13]);
        contentPanel.add(drone.Driver.groupPanel(buttons[24], buttons[25], buttons[26], buttons[27]));
        contentPanel.add(labels[14]);
        contentPanel.add(drone.Driver.groupPanel(buttons[28], buttons[29], buttons[30], buttons[31]));
        contentPanel.add(labels[15]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[16]);
        contentPanel.add(drone.Driver.groupPanel(buttons[32], buttons[33], buttons[34], buttons[35]));
        contentPanel.add(labels[17]);
        contentPanel.add(drone.Driver.groupPanel(buttons[36], buttons[37], buttons[38], buttons[39]));
        contentPanel.add(labels[18]);
        contentPanel.add(drone.Driver.groupPanel(buttons[40], buttons[41], buttons[42], buttons[43]));
        contentPanel.add(labels[19]);
        contentPanel.add(drone.Driver.groupPanel(buttons[44], buttons[45], buttons[46], buttons[47]));
        contentPanel.add(labels[20]);
        contentPanel.add(drone.Driver.groupPanel(buttons[48], buttons[49], buttons[50], buttons[51]));
        contentPanel.add(labels[21]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[22]);
        contentPanel.add(drone.Driver.groupPanel(buttons[52], buttons[53], buttons[54], buttons[55]));
        contentPanel.add(labels[23]);
        contentPanel.add(drone.Driver.groupPanel(buttons[56], buttons[57], buttons[58], buttons[59]));
        contentPanel.add(labels[24]);
        contentPanel.add(drone.Driver.groupPanel(buttons[60], buttons[61], buttons[62], buttons[63]));
        contentPanel.add(labels[25]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[26]);
        contentPanel.add(drone.Driver.groupPanel(buttons[64], buttons[65], buttons[66], buttons[67]));
        contentPanel.add(labels[27]);
        contentPanel.add(drone.Driver.groupPanel(buttons[68], buttons[69], buttons[70], buttons[71]));
        contentPanel.add(labels[28]);
        contentPanel.add(drone.Driver.groupPanel(buttons[72], buttons[73], buttons[74], buttons[75]));
        contentPanel.add(labels[29]);
        contentPanel.add(drone.Driver.groupPanel(buttons[76], buttons[77], buttons[78], buttons[79]));
        contentPanel.add(labels[30]);
        contentPanel.add(drone.Driver.groupPanel(buttons[80], buttons[81], buttons[82], buttons[83]));
        contentPanel.add(labels[31]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[32]);
        contentPanel.add(drone.Driver.groupPanel(buttons[84], buttons[85], buttons[86], buttons[87]));
        contentPanel.add(labels[33]);
        contentPanel.add(drone.Driver.groupPanel(buttons[88], buttons[89], buttons[90], buttons[91]));
        contentPanel.add(labels[34]);
        contentPanel.add(drone.Driver.groupPanel(buttons[92], buttons[93], buttons[94], buttons[95]));
        contentPanel.add(labels[35]);
        contentPanel.add(drone.Driver.groupPanel(buttons[96], buttons[97], buttons[98], buttons[99]));
        contentPanel.add(labels[36]);
        contentPanel.add(drone.Driver.groupPanel(buttons[100], buttons[101], buttons[102], buttons[103]));
        contentPanel.add(labels[37]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[38]);
        contentPanel.add(drone.Driver.groupPanel(buttons[104], buttons[105], buttons[106], buttons[107]));
        contentPanel.add(labels[39]);
        contentPanel.add(drone.Driver.groupPanel(buttons[108], buttons[109], buttons[110], buttons[111]));
        contentPanel.add(labels[40]);
        contentPanel.add(drone.Driver.groupPanel(buttons[112], buttons[113], buttons[114], buttons[115]));
        contentPanel.add(labels[41]);
        contentPanel.add(drone.Driver.groupPanel(buttons[116], buttons[117], buttons[118], buttons[119]));
        contentPanel.add(labels[42]);
        contentPanel.add(drone.Driver.groupPanel(buttons[120], buttons[121], buttons[122], buttons[123]));
        contentPanel.add(labels[43]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[44]);
        contentPanel.add(drone.Driver.groupPanel(buttons[124], buttons[125], buttons[126], buttons[127]));
        contentPanel.add(labels[45]);
        contentPanel.add(drone.Driver.groupPanel(buttons[128], buttons[129], buttons[130], buttons[131]));
        contentPanel.add(labels[46]);
        contentPanel.add(drone.Driver.groupPanel(buttons[132], buttons[133], buttons[134], buttons[135]));
        contentPanel.add(labels[47]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[48]);
        contentPanel.add(drone.Driver.groupPanel(buttons[136], buttons[137], buttons[138], buttons[139]));
        contentPanel.add(labels[49]);
        contentPanel.add(drone.Driver.groupPanel(buttons[140], buttons[141], buttons[142], buttons[143]));
        contentPanel.add(labels[50]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[51]);
        contentPanel.add(drone.Driver.groupPanel(buttons[144], buttons[145], buttons[146], buttons[147]));
        contentPanel.add(labels[52]);
        contentPanel.add(drone.Driver.groupPanel(buttons[148], buttons[149], buttons[150], buttons[151]));
        contentPanel.add(labels[53]);
        contentPanel.add(drone.Driver.hiddenPanel());
        contentPanel.add(labels[54]);
        contentPanel.add(drone.Driver.groupPanel(buttons[152], buttons[153], buttons[154], buttons[155]));
        contentPanel.add(labels[55]);
        contentPanel.add(drone.Driver.groupPanel(buttons[156], buttons[157], buttons[158], buttons[159]));
        
        contentPanel.add(nextButton);
        
        return contentPanel;
    }
}
