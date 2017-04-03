/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Mihika
 */
public class DialogCone extends JDialog implements ActionListener, ItemListener {

   JButton buttonOK;
   
   JLabel  labelFirstScoop;
   JLabel  labelSecondScoop;
   JLabel  labelThirdScoop;
   JLabel  labelFirstSyrup;
   JLabel  labelSecondSyrup;
   JLabel  labelThirdSyrup;
   JLabel  labelConeType;
   JLabel labelHowManyScoops;
   
   JRadioButton radiobuttonOneScoop;
   JRadioButton radiobuttonTwoScoops;
   JRadioButton radiobuttonThreeScoops;
    
   BorderLayout bl;
   ButtonGroup coneDessert;
   
   JPanel panelButton;
   JPanel panelCone;
   JPanel panelRadio=new JPanel();
   JPanel panelMain=new JPanel();
   
   JComboBox comboBoxFirstScoop = new JComboBox();
   JComboBox comboBoxSecondScoop = new JComboBox();
   JComboBox comboBoxThirdScoop = new JComboBox();
   JComboBox comboBoxConeType = new JComboBox();
   
   int temp;
   
   Shop shop;
   
   ArrayList <String> scoops=new ArrayList<>();
   
   ArrayList<IceCream> icecreamList=new ArrayList<>();
   IceCream icTemp;
   
      
   
   private JRadioButton makeRadioButton(String label){
        JRadioButton rb=new JRadioButton(label);
        rb.addActionListener(this);
        panelRadio.add(rb);
        return rb;
    }
   public DialogCone(Shop shop){
       this.shop=shop;
       
      Dimension size;
      size=new Dimension(300,220); 

      
      buttonOK=new JButton("OK");
      buttonOK.addActionListener(this);


      
      bl=new BorderLayout();//LayoutManager
      this.setLayout(bl);
      
       panelButton=new JPanel();
      GridLayout gl1=new GridLayout(1,2);
      panelButton.setLayout(gl1);
      
      panelButton.add(buttonOK);
      
      
      this.setSize(size);
      this.setLocationRelativeTo(null);
      this.setTitle("Ice Cream Cone flavours");
      
      panelCone=new JPanel();
      GridLayout g12=new GridLayout(4,2);
      panelCone.setLayout(g12);
      
       labelFirstScoop=new JLabel("First Scoop");
       labelSecondScoop=new JLabel("Second Scoop");
       labelThirdScoop=new JLabel("Third Scoop");
       
       
       
      icecreamList=shop.sendIceCream();
        String line;
        int i=0;
           while(i<icecreamList.size())
           {
               icTemp=icecreamList.get(i);
               line=icTemp.getName();
               comboBoxFirstScoop.addItem(line);
               comboBoxSecondScoop.addItem(line);
               comboBoxThirdScoop.addItem(line);
               i++;
           }  
           
        
	
	labelConeType=new JLabel("Cone Type");
        comboBoxConeType.addItem("Cake Cone");
        comboBoxConeType.addItem("Sugar Cone");
        comboBoxConeType.addItem("Waffle Cone");
       
       comboBoxFirstScoop.setBounds(2, 2, 90,90);
       comboBoxThirdScoop.setBounds(2, 2, 90,90);
       
      coneDessert=new ButtonGroup(); 
      GridLayout glr=new GridLayout(1,4);
      panelRadio.setLayout(glr);
      labelHowManyScoops=new JLabel("Scoops");

      panelRadio.add(labelHowManyScoops);
      
      radiobuttonOneScoop=makeRadioButton("1"); 
      radiobuttonOneScoop.addActionListener(this);
      radiobuttonTwoScoops=makeRadioButton("2");
      radiobuttonTwoScoops.addActionListener(this);
      radiobuttonThreeScoops=makeRadioButton("3");
      radiobuttonThreeScoops.addActionListener(this);
      coneDessert.add(radiobuttonOneScoop);
      coneDessert.add(radiobuttonTwoScoops);
      coneDessert.add(radiobuttonThreeScoops);

      panelCone.add(labelFirstScoop);
      panelCone.add(comboBoxFirstScoop);
      panelCone.add(labelSecondScoop);
      panelCone.add(comboBoxSecondScoop);
      panelCone.add(labelThirdScoop);
      panelCone.add(comboBoxThirdScoop);
      panelCone.add(labelConeType);
      panelCone.add(comboBoxConeType);
      
      
      panelMain.add(panelRadio);
      panelMain.add(panelCone);
      panelMain.add(panelButton);
      
      this.add(panelMain);
      this.setVisible(true);
      
      

      
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
            Object result1=comboBoxFirstScoop.getSelectedItem();
            Object result2=comboBoxSecondScoop.getSelectedItem();
            Object result3=comboBoxThirdScoop.getSelectedItem();
	    Object result4=comboBoxConeType.getSelectedItem();
	    String ConeTypeName=result4.toString();
            
            switch(temp){
            case 1:
              scoops.add(result1.toString()); 
              break;
            case 2:
               scoops.add(result1.toString());
               scoops.add(result2.toString());
               break;
            case 3:
               scoops.add(result1.toString());
               scoops.add(result2.toString());
               scoops.add(result3.toString());
               break;
            }
            
            shop.createCone(ConeTypeName,scoops);
              dispose();
            DialogDessert dd=new DialogDessert(shop);
        }
        
        Object source=null;
        source=e.getSource();
        
        if(source==radiobuttonOneScoop){
            temp=1;
            
        }
        else if(source==radiobuttonTwoScoops){
            temp=2;
        }
        else if(source==radiobuttonThreeScoops){
            temp=3;
        }
        switch(temp){
          case 1:
              this.comboBoxFirstScoop.setEnabled(true);
              this.comboBoxSecondScoop.setEnabled(false);
              this.comboBoxThirdScoop.setEnabled(false);
              break;
          case 2:
              this.comboBoxFirstScoop.setEnabled(true);
              this.comboBoxSecondScoop.setEnabled(true);
              this.comboBoxThirdScoop.setEnabled(false);
              break;
          case 3:
              this.comboBoxFirstScoop.setEnabled(true);
              this.comboBoxSecondScoop.setEnabled(true);
              this.comboBoxThirdScoop.setEnabled(true);
              break;
          
      }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

