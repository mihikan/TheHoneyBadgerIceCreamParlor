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
public class DialogErrorMoneySelect {
    public DialogErrorMoneySelect(){
     String message = "\"Error!!!\"\n"
        + "You haven't selected enough Money\n"
        + "Please select your options again";
    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
        JOptionPane.ERROR_MESSAGE);   
    }

}



  

         