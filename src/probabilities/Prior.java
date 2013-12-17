/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilities;

import java.io.IOException;
import probabilities.helpers.PriorHelper;

/**
 *
 * @author OMOLARA A
 */
public class Prior { 
    
    public static void main(String[] args) throws IOException {
        //PriorHelper.initiate();   you seriously need to adjust the table name causability in priorhelper.java
        new PriorHelper();
    }
}
