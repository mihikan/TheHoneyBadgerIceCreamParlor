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
public class DialogBananaSplit extends JDialog implements ActionListener, ItemListener {

   JButton buttonOK;
   
   JLabel  labelFirstScoop;
   JLabel  labelSecondScoop;
   JLabel  labelThirdScoop;
   JLabel  labelFirstSyrup;
   JLabel  labelSecondSyrup;
   JLabel  labelThirdSyrup;
   JLabel labelDoYouWantNuts;
   
   
   BorderLayout bl;
   
    JRadioButton radiobuttonYes;
    JRadioButton radiobuttonNo;
   
   JPanel panelButton;
   JPanel panelSplit;
   JPanel panelRadio=new JPanel();
   JPanel panelMain=new JPanel();
   
   boolean nuts;
   
   
   JComboBox comboBoxFirstScoop = new JComboBox();
   JComboBox comboBoxSecondScoop = new JComboBox();
   JComboBox comboBoxThirdScoop = new JComboBox();
   JComboBox comboBoxFirstSyrup = new JComboBox();
   JComboBox comboBoxSecondSyrup = new JComboBox();
   JComboBox comboBoxThirdSyrup = new JComboBox();
   
   ArrayList<IceCream> icecreamList;
   IceCream icTemp;
   
   ArrayList <String> scoops=new ArrayList<>();
   ArrayList <String> syrups=new ArrayList<>();
   
   Shop shop;
   
   private JRadioButton makeRadioButton(String label){
        JRadioButton rb=new JRadioButton(label);
        rb.addActionListener(this);
        panelRadio.add(rb);
        return rb;
    }
   
   public DialogBananaSplit(Shop shop){
      Dimension size;
      size=new Dimension(400,270); 

      
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
      this.setTitle("Banana Split flavours"); 
      
      panelSplit=new JPanel();
      GridLayout g12=new GridLayout(6,2);
      panelSplit.setLayout(g12);
      
       labelFirstScoop=new JLabel("First Scoop");
       labelSecondScoop=new JLabel("Second Scoop");
       labelThirdScoop=new JLabel("Third Scoop");
       
       labelFirstSyrup=new JLabel("First Syrup");
       labelSecondSyrup=new JLabel("Second Syrup");
       labelThirdSyrup=new JLabel("Third Syrup");
       
       labelDoYouWantNuts=new JLabel("Do You want Nuts ?");
       GridLayout g13=new GridLayout(1,3);
       panelRadio.setLayout(g13);
       panelRadio.add(labelDoYouWantNuts);
       
       this.shop=shop;
       
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

       comboBoxFirstScoop.setBounds(2, 2, 75,75);
       comboBoxThirdScoop.setBounds(2, 2, 75,75);

     comboBoxFirstSyrup.addItem("Strawberry Syrup");
     comboBoxFirstSyrup.addItem("Chocolate Syrup");
     comboBoxFirstSyrup.addItem("Marshmallow Cream");
     comboBoxFirstSyrup.addItem("Pineapple");
     comboBoxFirstSyrup.addItem("Ketchup");
     comboBoxFirstSyrup.addItem("Mustard");
     comboBoxFirstSyrup.addItem("Pickle Relish");
     
     comboBoxSecondSyrup.addItem("Strawberry Syrup");
     comboBoxSecondSyrup.addItem("Chocolate Syrup");
     comboBoxSecondSyrup.addItem("Marshmallow Cream");
     comboBoxSecondSyrup.addItem("Pineapple");
     comboBoxSecondSyrup.addItem("Ketchup");
     comboBoxSecondSyrup.addItem("Mustard");
     comboBoxSecondSyrup.addItem("Pickle Relish");
     
     comboBoxThirdSyrup.addItem("Strawberry Syrup");
     comboBoxThirdSyrup.addItem("Chocolate Syrup");
     comboBoxThirdSyrup.addItem("Marshmallow Cream");
     comboBoxThirdSyrup.addItem("Pineapple");
     comboBoxThirdSyrup.addItem("Ketchup");
     comboBoxThirdSyrup.addItem("Mustard");
     comboBoxThirdSyrup.addItem("Pickle Relish");
     
    ButtonGroup groupNuts=new ButtonGroup();
     
    radiobuttonYes=makeRadioButton("Yes"); 
    radiobuttonNo=makeRadioButton("No");
    
    groupNuts.add(radiobuttonYes);
    groupNuts.add(radiobuttonNo);
    
    radiobuttonYes.setSelected(true);
     
     
      panelSplit.add(labelFirstScoop);
      panelSplit.add(comboBoxFirstScoop);
      panelSplit.add(labelSecondScoop);
      panelSplit.add(comboBoxSecondScoop);
      panelSplit.add(labelThirdScoop);
      panelSplit.add(comboBoxThirdScoop);
      panelSplit.add(labelFirstSyrup);
      panelSplit.add(comboBoxFirstSyrup);
      panelSplit.add(labelSecondSyrup);
      panelSplit.add(comboBoxSecondSyrup);
      panelSplit.add(labelThirdSyrup);
      panelSplit.add(comboBoxThirdSyrup);
      
      panelMain.add(panelSplit);
      panelMain.add(panelRadio);
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
            Object result4=comboBoxFirstSyrup.getSelectedItem();
            Object result5=comboBoxSecondSyrup.getSelectedItem();
            Object result6=comboBoxThirdSyrup.getSelectedItem();
            scoops.add(result1.toString());
            scoops.add(result2.toString());
            scoops.add(result3.toString());
            syrups.add(result4.toString());
            syrups.add(result5.toString());
            syrups.add(result6.toString());

                        
        
        shop.createSplit(nuts,scoops,syrups);
          dispose();
          DialogDessert dd=new DialogDessert(shop);
          
          
    }
        else if(e.getActionCommand()=="Cancel"){
            dispose();
        }
        Object source=null;
        source=e.getSource();
        
        source=e.getSource();
         if(source==radiobuttonYes){
            nuts=true;
            
        }
        else if(source==radiobuttonNo){
            nuts=false;

        } 
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  

}