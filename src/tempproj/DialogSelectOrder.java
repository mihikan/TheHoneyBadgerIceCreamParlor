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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mihika
 */
public class DialogSelectOrder extends JDialog implements ActionListener, ItemListener{
    Shop shop;
    
    JButton buttonOK;
    JButton buttonCancel;
    JTextField  textOrderNo;
    BorderLayout bl;
    
    JPanel panelAllOrders;
    JPanel panelText;
    JPanel panelButton;
    JPanel panelMain;
    
    ArrayList<JLabel> labelOrders;
    JLabel labelOrder;
    JLabel labelOrder1;
    JLabel labelOrder2;
    JLabel labelOrder3;
    JLabel labelOrder4;
    JLabel labelOrder5;
    
    ArrayList<Order> orders;
    Order tempOrder;
   
    
    public DialogSelectOrder(Shop shop){
      this.shop=shop;
      
      Dimension size;
      size=new Dimension(600,730); 
      this.setSize(size);
      this.setLocationRelativeTo(null);
      
      
      panelText=new JPanel();
      panelAllOrders=new JPanel(); 
        
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);
      
      buttonCancel=new JButton("Cancel");
      buttonCancel.addActionListener(this);
      
      panelButton=new JPanel();
      
      panelButton.add(buttonOK);
      panelButton.add(buttonCancel);
     
      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
      GridLayout g12=new GridLayout(100,1);
      panelAllOrders.setLayout(g12);
      
      orders=shop.sendOrders();
      
      
      
      for(int i=0;i<orders.size();i++){
          tempOrder=orders.get(i);
          String output,output1,output2,output3,output4;
          output="Order Number:"+Integer.toString(tempOrder.getOrder_Number());
          output1="Customer: "+tempOrder.getCustomer_order().getName();
          output2="Worker: "+tempOrder.getWorker_order().getName_worker();
          output3="Total Amount: "+Double.toString(tempOrder.getTotal());
          if(tempOrder.isStatus()){
                    output4="*This Order has been Paid for*";
              }
          else{
              output4="";
            }
          labelOrder=new JLabel(output);
          labelOrder1=new JLabel(output1);
          labelOrder2=new JLabel(output2);
          labelOrder3=new JLabel(output3);
          labelOrder5=new JLabel(output4);
          labelOrder4=new JLabel("--------------------------------------------");
          panelAllOrders.add(labelOrder);
          panelAllOrders.add(labelOrder1);
          panelAllOrders.add(labelOrder2);
          panelAllOrders.add(labelOrder3);
          panelAllOrders.add(labelOrder5);
          panelAllOrders.add(labelOrder4);
      }
      
      textOrderNo=new JTextField();
      textOrderNo.setColumns(10);
      JLabel labelChooseOrder=new JLabel("Which order do you want to pay for? ");
      panelText.add(labelChooseOrder);
      panelText.add(textOrderNo);
      
            panelMain=new JPanel();

      panelMain.add(panelAllOrders);
      JPanel panelSouth=new JPanel();
      panelSouth.add(panelText);
      panelSouth.add(panelButton);
      this.add(panelSouth,bl.SOUTH);
      this.add(panelMain);
      this.setVisible(true);
      
      }
     
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source=null;
        source=e.getSource();
        
        if(source==buttonOK)
        {
            String s=this.textOrderNo.getText();
            int Number=Integer.parseInt(s);
            System.out.println(Number);
            dispose();
            DialogPay dp=new DialogPay(shop,Number);
        }
        else if(source==buttonCancel)
        {
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
