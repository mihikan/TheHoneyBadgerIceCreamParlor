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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mihika
 */
public class DialogAbout extends JDialog implements ActionListener {

   JButton buttonOK; 
   
   
   JLabel  labelProject;
   JLabel  labelTeam;
   JLabel  labelTM;
   JLabel  labelMihika;
   JLabel  labelShruti;
   JLabel  labelSneha;
   JLabel labelblank=new JLabel("                                           ");

   
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelAbout;
   JPanel Main=new JPanel();
   
   public DialogAbout(){
      Dimension size;
      size=new Dimension(400,200); 

      
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);


      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
      panelButton=new JPanel();
      GridLayout g13=new GridLayout(1,3);
      
      panelButton.setLayout(g13);
      panelButton.add(labelblank);
      panelButton.add(buttonOK);
      panelButton.add(labelblank);

            
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("About");       

      
      panelAbout=new JPanel();
      GridLayout g62=new GridLayout(6,2);
      panelAbout.setLayout(g62);
      
      labelProject=new JLabel("Project: The Honey Badger Ice Cream Parlor");  
      labelTeam=new JLabel("Team: The Scavengers!");
      labelTM=new JLabel("Team Members:");
      labelMihika=new JLabel("Mihika Naik");
      labelShruti=new JLabel("Shruti Mishra");
      labelSneha=new JLabel("Sneha Kalita");     
       
      
      panelAbout.add(labelProject);      
      panelAbout.add(labelTeam);
      panelAbout.add(labelTM);
      panelAbout.add(labelMihika);
      panelAbout.add(labelShruti);
      panelAbout.add(labelSneha);
      
      Main.add(panelAbout);
      Main.add(panelButton);
      
      this.add(Main);
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
