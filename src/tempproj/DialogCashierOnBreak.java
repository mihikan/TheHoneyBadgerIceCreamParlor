/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

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
public class DialogCashierOnBreak extends JDialog implements ActionListener {
    JButton buttonOK;
    JButton buttonYES;
   
   
   JLabel  labelProject;
   JLabel label2;
   JLabel label3;
   

   JLabel labelblank=new JLabel("                                           ");

   
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelButton2;
   JPanel panelAbout;
   JPanel Main=new JPanel();
   
   Shop shop;
   
   public DialogCashierOnBreak(Shop shop){
       this.shop=shop;
      Dimension size;
      size=new Dimension(400,200); 

      
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);

      buttonYES=new JButton("YES");
      buttonYES.addActionListener(this);
      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
      panelButton=new JPanel();
      GridLayout g13=new GridLayout(1,3);
      
      panelButton.setLayout(g13);
      panelButton.add(labelblank);
      panelButton.add(buttonOK);
      panelButton.add(labelblank);

      panelButton2=new JPanel();
 
      
      panelButton2.setLayout(g13);
      panelButton2.add(labelblank);
      panelButton2.add(buttonYES);
      panelButton2.add(labelblank);
      
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Cashier on Break");       

      
      panelAbout=new JPanel();
      GridLayout g62=new GridLayout(2,1);
      panelAbout.setLayout(g62);
      
      labelProject=new JLabel(shop.Cashier());
      if(shop.CashierOnBreak()){
          label2=new JLabel("is on Break");
          label3=new JLabel("Select another cashier");
          panelAbout.add(labelProject);
          panelAbout.add(label2);
          panelAbout.add(label3);
          Main.add(panelAbout);
          Main.add(panelButton);
      }
      else{
          label2=new JLabel("is not on Break");
          label3=new JLabel("Do you want to put him on break ?");
           panelAbout.add(labelProject);
           panelAbout.add(label2);
           panelAbout.add(label3);
           Main.add(panelAbout);
            Main.add(panelButton2);
          
      }
     
 
      
      this.add(Main);
      this.setVisible(true);
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
           dispose();
        }
        else if(e.getActionCommand()=="YES"){
            shop.SetCashierOnBreak();
            dispose();
        }
    }
}
