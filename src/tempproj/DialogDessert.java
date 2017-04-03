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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Mihika
 */
public class DialogDessert extends JDialog implements ActionListener, ItemListener{
    
    JButton buttonOK;
    JButton buttonCancel;
    
    JRadioButton radiobuttonICCone;
    JRadioButton radiobuttonICSundae;
    JRadioButton radiobuttonICSplit;
    JRadioButton radiobuttonICSoda;
    JRadioButton radiobuttonICRBF;
    
    ButtonGroup groupDessert;
    
    BorderLayout bl;
    
    JPanel panelButton;
    JPanel panelDessert;
    JPanel panelMain;
    
    int temp;
    
    Shop shop;
    
    private JRadioButton makeRadioButton(String label){
        JRadioButton rb=new JRadioButton(label);
        rb.addActionListener(this);
        panelDessert.add(rb);
        return rb;
    }
    
    
    public DialogDessert(Shop shop){
       
        this.shop=shop; 
        
      Dimension size;
      size=new Dimension(400,200); 
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Desserts");
      
      
      panelDessert=new JPanel(); 
       
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);
      
      buttonCancel=new JButton("Cancel");
      buttonCancel.addActionListener(this);
      
      panelButton=new JPanel();
      
      panelButton.add(buttonOK);
      panelButton.add(buttonCancel);
     

     
      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
      GridLayout g12=new GridLayout(5,1);
      panelDessert.setLayout(g12);

      
      
      groupDessert=new ButtonGroup();
      radiobuttonICCone=makeRadioButton("Ice Cream Cone"); 
      radiobuttonICCone.addActionListener(this);
      radiobuttonICSundae=makeRadioButton("Ice Cream Sundae");
      radiobuttonICSundae.addActionListener(this);
      radiobuttonICSplit=makeRadioButton("Banana Split");
      radiobuttonICSplit.addActionListener(this);
      radiobuttonICSoda=makeRadioButton("Ice Cream Soda");
      radiobuttonICSoda.addActionListener(this);
      radiobuttonICRBF=makeRadioButton("Root Beer Float");
      radiobuttonICRBF.addActionListener(this);
      groupDessert.add(radiobuttonICCone);
      groupDessert.add(radiobuttonICSundae);
      groupDessert.add(radiobuttonICSplit);
      groupDessert.add(radiobuttonICSoda);
      groupDessert.add(radiobuttonICRBF);
      radiobuttonICCone.setSelected(true);
      
      
      panelMain=new JPanel();
      panelMain.add(panelDessert);
      panelMain.add(panelButton);
      
  

      
      this.add(panelMain);
      

      this.setVisible(true);
      
      
    }
      

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        if (arg0.getActionCommand()=="OK"){
            switch(temp){
                case 1:
                    DialogCone dc=new DialogCone(shop);
                      dispose();
                    break;
                case 2:
                    DialogBananaSplit dbs=new DialogBananaSplit(shop);
                      dispose();
                    break;
                case 3:
                    DialogSundae ds=new DialogSundae(shop);
                      dispose();
                    break;
                case 4:
                     DialogSoda dsoda=new DialogSoda(shop);
                       dispose();
                    break;
                case 5:
                        shop.createRBF();
                      dispose();
                     DialogDessert dd=new DialogDessert(shop);
                    break;
                    
            }
                           
        }
        else if(arg0.getActionCommand()=="Cancel"){
            if(shop.noScoops){
                    DialogErrorNotEnoughIceCream deneic=new DialogErrorNotEnoughIceCream();
                    dispose();
                    shop.noScoops=false;
                    }
            else{
            shop.createOrder();
            dispose();
        }
        }
        
        Object source=null;
        source=arg0.getSource();
        
        if(source==radiobuttonICCone){
            temp=1;
        }
        else if(source==radiobuttonICSplit){
            temp=2;
            
        }
        else if(source==radiobuttonICSundae){
            temp=3;
            
        }
        else if(source==radiobuttonICSoda){
            temp=4;
           
        }
        else if(source==radiobuttonICRBF){
            temp=5;
           
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
