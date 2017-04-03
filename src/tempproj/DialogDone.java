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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mihika
 */
public class DialogDone extends JDialog implements ActionListener {

   JButton buttonOK; 
   
   JLabel  labelDone;
  
   
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelSplit;
   
   JComboBox comboBoxDone=new JComboBox();
   
   public DialogDone(){
       
      Dimension size;
      size=new Dimension(200,200); 

      
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);

      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
      panelButton=new JPanel();
      GridLayout gl1=new GridLayout(1,1);
      panelButton.setLayout(gl1);
      
      panelButton.add(buttonOK);
      this.add(panelButton,bl.SOUTH);
      
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Done");
      
      panelSplit=new JPanel();
      GridLayout g12=new GridLayout(6,2);
      panelSplit.setLayout(g12);
      this.add(panelSplit,bl.CENTER);
      labelDone=new JLabel("Done!"); 
      comboBoxDone.setBounds(2, 2, 75,75);
       
      panelSplit.add(labelDone);
    
      
      this.setVisible(true);
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
           dispose();
        }
          
    }

  
          
}


