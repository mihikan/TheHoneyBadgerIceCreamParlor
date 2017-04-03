/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mihika
 */
public class DialogErrorCashierOnBreak {



    public DialogErrorCashierOnBreak(){
     String message = "\"Sorry\"\n"
        + "Cashier is on Break\n"
        + "Your payment cannot be processed";
    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
        JOptionPane.ERROR_MESSAGE);   
    }

}
