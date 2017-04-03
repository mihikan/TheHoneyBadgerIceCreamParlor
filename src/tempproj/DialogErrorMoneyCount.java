/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

/**
 *
 * @author Mihika
 */


import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DialogErrorMoneyCount {
    public DialogErrorMoneyCount(){
     String message = "\"Error!!!\"\n"
        + "You don't have enough of each selected value\n"
        + "Please select your options again";
    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
        JOptionPane.ERROR_MESSAGE);   
    }

}



  

         
