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
public class DialogSoda extends JDialog implements ActionListener, ItemListener {

   JButton buttonOK; 
   
   JLabel  labelScoop;
     
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelSplit;
   JPanel panelMain=new JPanel();
   
   JComboBox comboBoxScoop = new JComboBox();
   
      ArrayList<IceCream> icecreamList;
   IceCream icTemp;
   
   Shop shop;
   
   ArrayList <String> scoops=new ArrayList<>();
   
   public DialogSoda(Shop shop){
      Dimension size;
      size=new Dimension(300,220); 

       panelButton=new JPanel();
      GridLayout gl1=new GridLayout(1,2);
      panelButton.setLayout(gl1);
      
        
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);
      
      panelButton.add(buttonOK);
    

      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
     
      
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Ice Cream Soda flavours");
      
      panelSplit=new JPanel();
      GridLayout g12=new GridLayout(1,2);
      panelSplit.setLayout(g12);
      
      this.shop=shop;
      
       labelScoop=new JLabel("Scoop                           ");
       
 icecreamList=shop.sendIceCream();
       
        String line;
        int i=0;
           while(i<icecreamList.size())
           {
               icTemp=icecreamList.get(i);
               line=icTemp.getName();
               comboBoxScoop.addItem(line);
               i++;
           }   

       comboBoxScoop.setBounds(2, 2, 75,75);
      

      panelSplit.add(labelScoop);
      panelSplit.add(comboBoxScoop);
      
      panelMain.add(panelSplit);
       panelMain.add(panelButton);
      
       this.add(panelMain);
               
      this.setVisible(true);
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
            Object result1=comboBoxScoop.getSelectedItem();
            String ScoopName=result1.toString();
            
            scoops.add(ScoopName);
            
        }
        
        shop.createSoda(scoops);
          dispose();
          DialogDessert dd=new DialogDessert(shop);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
 
}

