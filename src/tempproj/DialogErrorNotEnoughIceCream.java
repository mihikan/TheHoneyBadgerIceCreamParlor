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
public class DialogErrorNotEnoughIceCream {
    public DialogErrorNotEnoughIceCream(){
     String message = "\"Sorry\"\n"
        + "We ran out of one of the Ice Creams.\n"
        + "Your order could not be placed";
    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
        JOptionPane.ERROR_MESSAGE);   
    }
}
