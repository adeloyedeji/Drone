/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

/**
 *
 * @author OMOLARA A
 */
public class Validate11 {
    
    public static void inspect11(javax.swing.JRadioButton[] buttons, javax.swing.JFrame frame, String name, javax.swing.JTextField[] fields) {
        int id = 0;
        String e1 = "", e2 = "";
        double[] values = new double[16];
        values[0] = Validate9.getSelectedValues(buttons[0], buttons[1], buttons[2], buttons[3], buttons[4]);
        values[1] = Validate9.getSelectedValues(buttons[5], buttons[6], buttons[7], buttons[8], buttons[9]);
        values[2] = Validate9.getSelectedValues(buttons[10], buttons[11], buttons[12], buttons[13], buttons[14]);
        values[3] = Validate9.getSelectedValues(buttons[15], buttons[16], buttons[17], buttons[18], buttons[19]);
        values[4] = Validate9.getSelectedValues(buttons[20], buttons[21], buttons[22], buttons[23], buttons[24]);
        values[5] = Validate9.getSelectedValues(buttons[25], buttons[26], buttons[27], buttons[28], buttons[29]);
        values[6] = Validate9.getSelectedValues(buttons[30], buttons[31], buttons[32], buttons[33], buttons[34]);
        values[7] = Validate9.getSelectedValues(buttons[35], buttons[36], buttons[37], buttons[38], buttons[39]);
        values[8] = Validate9.getSelectedValues(buttons[40], buttons[41], buttons[42], buttons[43], buttons[44]);
        values[9] = Validate9.getSelectedValues(buttons[45], buttons[46], buttons[47], buttons[48], buttons[49]);
        values[10] = Validate9.getSelectedValues(buttons[50], buttons[51], buttons[52], buttons[53], buttons[54]);
        values[11] = Validate9.getSelectedValues(buttons[55], buttons[56], buttons[57], buttons[58], buttons[59]);
        values[12] = Validate9.getSelectedValues(buttons[60], buttons[61], buttons[62], buttons[63], buttons[64]);
        values[13] = Validate9.getSelectedValues(buttons[65], buttons[66], buttons[67], buttons[68], buttons[69]);
        values[14] = Validate9.getSelectedValues(buttons[70], buttons[71], buttons[72], buttons[73], buttons[74]);
        values[15] = Validate9.getSelectedValues(buttons[75], buttons[76], buttons[77], buttons[78], buttons[79]);
        
        if(fields[0].getText().equalsIgnoreCase("")) {
            e1 = "none";
        } else {
            e1 = fields[0].getText();
        }
        if(fields[1].getText().equalsIgnoreCase("")) {
            e2 = "none";
        } else {
            e2 = fields[0].getText();
        }
        String sql = "INSERT INTO component11 VALUES('"+id+"', '"+values[0]+"', '"+values[1]+"','"+values[2]+"', '"+values[3]+"',"
                + "                                 '"+values[4]+"', '"+values[5]+"','"+values[6]+"', '"+values[7]+"',"
                + "                                 '"+values[8]+"', '"+values[9]+"','"+values[10]+"', '"+values[11]+"',"
                + "                                 '"+values[12]+"', '"+values[13]+"','"+values[14]+"', '"+values[15]+"',"
                + "                                 '"+name+"')";
        String sql3 = "INSERT INTO causability VALUES('"+values[0]+"', '"+values[1]+"','"+values[2]+"', '"+values[3]+"',"
                + "                                 '"+values[4]+"', '"+values[5]+"','"+values[6]+"', '"+values[7]+"',"
                + "                                 '"+values[8]+"', '"+values[9]+"','"+values[10]+"', '"+values[11]+"',"
                + "                                 '"+values[12]+"', '"+values[13]+"','"+values[14]+"', '"+values[15]+"', '"+id+"')";
        String sql2 = "INSERT INTO softwares11 VALUES('"+id+"', '"+e1+"', '"+e2+"', '"+name+"')";
        database.DatabaseHandler.insert(frame, sql);
        database.DatabaseHandler.insertSoftware(frame, sql2);
        database.DatabaseHandler.insertSoftware(frame, sql3);
    }
}
