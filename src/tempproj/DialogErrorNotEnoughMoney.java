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
public class DialogErrorNotEnoughMoney {
        public DialogErrorNotEnoughMoney(){
     String message = "\"Sorry\"\n"
        + "You do not have enough Money\n"
        + "Please pay by Credit Card";
    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
        JOptionPane.ERROR_MESSAGE);   
    }
}
