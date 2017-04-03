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
public class DialogPay extends JDialog implements ActionListener, ItemListener {

   JButton buttonOK; 
   
   JLabel  labelAmount;
   JLabel  labelPayType;

   
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelPay;
   JPanel panelTitle;
   JPanel panelMain;
   
   JComboBox comboBoxPayType;
   
   Shop shop;
   ArrayList<Order> orders;
   Order tempOrder;
   
   int oNumber;
   
   public DialogPay(Shop shop,int orderNumber){
       
       this.shop=shop;
       oNumber=orderNumber;
      Dimension size;
      size=new Dimension(400,200); 

      
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);

      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
      panelButton=new JPanel();
      GridLayout gl1=new GridLayout(1,1);
      panelButton.setLayout(gl1);
      
      panelButton.add(buttonOK);
      
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Payment Options");
      
      panelPay=new JPanel();
      GridLayout g12=new GridLayout(1,2);
      panelPay.setLayout(g12);
      
      orders=shop.sendOrders();
      tempOrder=orders.get(orderNumber-1001);
      
      
      labelAmount=new JLabel("You Need to Pay: $"+Double.toString(tempOrder.getTotal()));
      panelTitle=new JPanel();
      panelTitle.add(labelAmount);


      labelPayType=new JLabel("How do you want to pay?");
      comboBoxPayType = new JComboBox(); 
      comboBoxPayType.setBounds(2, 2, 75,75);
       
     comboBoxPayType.addItem("Cash");
     comboBoxPayType.addItem("Credit");
      panelPay.add(labelPayType);
      panelPay.add(comboBoxPayType);
      
      panelMain=new JPanel();
      panelMain.add(panelTitle);
      panelMain.add(panelPay);
      panelMain.add(panelButton);
    
      this.add(panelMain);
      this.setVisible(true);
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
            Object result1=comboBoxPayType.getSelectedItem();
            String PayType=result1.toString();
            if(shop.CashierOnBreak()==false)
            {
            if(PayType.equals("Credit")){
                shop.PayCredit(oNumber-1001);
                DialogDone dd=new DialogDone();
                dispose();
            }
            else if(PayType.equals("Cash")){
                DialogCash dc=new DialogCash(shop,oNumber-1000);
                dispose();
            }
            }
            else{
                DialogErrorCashierOnBreak decb=new DialogErrorCashierOnBreak();
                shop.ReduceLOH(oNumber-1001);
                dispose();
            }
        }
          
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}

