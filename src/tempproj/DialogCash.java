/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class DialogCash extends JDialog implements ActionListener{
    Shop shop;
    
    JButton buttonOK;
    JButton buttonCancel;
    
    JTextField tfPennies;
    JTextField tfNickels;
    JTextField tfDimes;
    JTextField tfQuarters;
    JTextField tfOnes;
    JTextField tfFives;
    JTextField tfTens;
    JTextField tfTwenties;
    
    JPanel panelMain;
    JPanel panelButton;
    JPanel panelMoney;
    
    JLabel panelPennies;
    JLabel panelNickels;
    JLabel panelDimes;
    JLabel panelQuarters;
    JLabel panelOnes;
    JLabel panelFives;
    JLabel panelTens;
    JLabel panelTwenties;
    
    ArrayList<Order> orders;
   Order tempOrder;
   
   Customer tempCustomer;
   
    int oNumber;
    
    
    private JTextField makeTextField(String string) {
		JTextField tf=new JTextField();
		JLabel l=new JLabel(string);
	
		this.panelMoney.add(l);
		this.panelMoney.add(tf);
		return tf;
	}

    
    public DialogCash(Shop shop,int orderNumber){
        this.shop=shop;
        
       oNumber=orderNumber;
       
        orders=shop.sendOrders();
        tempOrder=orders.get(oNumber-1);
        
        tempCustomer=tempOrder.getCustomer_order();
        
        Dimension size;
      size=new Dimension(400,250); 
 
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Pay by Cash");
        
        panelButton=new JPanel();
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        buttonCancel=new JButton("Cancel");
        buttonCancel.addActionListener(this);
        
        GridLayout glb=new GridLayout(1,2);
         panelButton.setLayout(glb);
         
         panelButton.add(buttonOK);
         panelButton.add(buttonCancel);
         
         
         panelMoney=new JPanel();
         
         
        GridLayout gltf=new GridLayout(8,2);
        panelMoney.setLayout(gltf);
         
         tfPennies=makeTextField("Pennies: ");
         tfNickels=makeTextField("Nickels: ");
         tfDimes=makeTextField("Dimes: ");
         tfQuarters=makeTextField("Quarters: ");
         tfOnes=makeTextField("One Dollar: ");
         tfFives=makeTextField("Five Dollars: ");
         tfTens=makeTextField("Ten Dollars: ");
         tfTwenties=makeTextField("Twenty Dollars: ");
        
        panelMain=new JPanel();
        GridLayout glm=new GridLayout(1,2);
        
        panelMain.add(panelMoney);
        panelMain.add(panelButton);
        
        
        this.add(panelMain);
        
        this.setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            Object source=null;
            source=e.getSource();

            if(source==buttonOK)
            {
                int penny=Integer.parseInt(this.tfPennies.getText());
                int nickel=Integer.parseInt(this.tfNickels.getText());
                int dime=Integer.parseInt(this.tfDimes.getText());
                int quarter=Integer.parseInt(this.tfQuarters.getText());
                int one=Integer.parseInt(this.tfOnes.getText());
                int five=Integer.parseInt(this.tfFives.getText());
                int ten=Integer.parseInt(this. tfTens.getText());
                int twenty=Integer.parseInt(this.tfTwenties.getText());
                double totalMoney=(0.01*penny)+(0.05*nickel)+(0.1*dime)+(0.25*quarter)+one+(5*five)+(10*ten)+(20*twenty); 
                if((totalMoney-tempOrder.getTotal())>0&&(totalMoney-tempOrder.getTotal())<shop.sendCashInfo()){
                    NotEnoughMoneyException neme=new NotEnoughMoneyException(shop.sendActiveCashier(),shop.sendCashRegister());
                }
                if(shop.sendTempCustomer().getMoney()<tempOrder.getTotal()){
                    NotEnoughMoneyException neme=new NotEnoughMoneyException(shop.sendTempCustomer());
                    DialogErrorNotEnoughMoney denem=new DialogErrorNotEnoughMoney();
                    dispose();
                    DialogPay dp=new DialogPay(shop,shop.order_count+1001);

                }
                else{
                if(tempCustomer.validate(penny, nickel, dime, quarter, one, five, ten, twenty)){
                  DialogErrorMoneyCount demc=new DialogErrorMoneyCount();  
                }
                else{
                if(totalMoney<tempOrder.getTotal()){
                DialogErrorMoneySelect dems=new DialogErrorMoneySelect();
                
                }
                else{
                shop.PayCash(oNumber-1,penny,nickel,dime,quarter,one,five,ten,twenty);
                dispose();
                DialogDone dd=new DialogDone();
                }
                }
                }
            }
            else if(source==buttonCancel)
            {
                dispose();
            }    }
    
}
