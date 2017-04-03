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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mihika
 */
public class DialogCustomer extends JDialog implements ActionListener, ItemListener {

   JButton buttonOK; 
   
   JLabel  labelCustomer;
   
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelCustomer;
   JPanel panelMain=new JPanel();
   
   JComboBox comboBoxCustomer = new JComboBox();
   
   public String CustomerName;
   
   Shop shop;
   
   ArrayList <Customer> customerList;
   
   Customer customer;
   
   
   public DialogCustomer(Shop shop){
      Dimension size;
      size=new Dimension(250,250); 

      
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);

      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      


       panelButton=new JPanel();
       
      GridLayout gl2=new GridLayout(1,2);
      panelButton.setLayout(gl2);
      
      panelButton.add(buttonOK);
      this.add(panelButton,bl.SOUTH);
      
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Customer");
      
      panelCustomer=new JPanel();
      GridLayout g12=new GridLayout(1,2);
      panelCustomer.setLayout(g12);
      
      panelMain.add(panelCustomer);
      
      //this.shop=shop;
      this.shop=shop;
      labelCustomer=new JLabel("Customer              ");
   
        customerList=shop.sendCustomer();
        String line;


       int i=0;
           while(i<customerList.size())
           {
               customer=customerList.get(i);
               line=customer.getName();
               comboBoxCustomer.addItem(line);
               i++;
           }  
           
        
    
       
       comboBoxCustomer.setBounds(2, 2, 75,75);

      panelCustomer.add(labelCustomer);
      panelCustomer.add(comboBoxCustomer);
      
      this.add(panelMain);
      
      this.setVisible(true);
      
      
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
            Object result=comboBoxCustomer.getSelectedItem();
            CustomerName=result.toString();
            shop.getCustomerName(CustomerName);
        }
          dispose();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*    public static void main(String []args){
    DialogCustomer dg=new DialogCustomer();
    
    }
    */


}
