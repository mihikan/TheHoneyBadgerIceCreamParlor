package tempproj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class DialogSundae extends JDialog implements ActionListener,ItemListener {
    
    JButton buttonOK;
    
    JLabel labelFirstScoop;
    JLabel labelSecondScoop;
    JLabel labelSyrup;
    JLabel labelHowManyScoops;
    JLabel labelDoYouWantNuts;
    
    JComboBox comboBoxFirstScoop=new JComboBox();
    JComboBox comboBoxSecondScoop=new JComboBox();
    JComboBox comboBoxSyrup=new JComboBox();
    
    JRadioButton radiobuttonOne;
    JRadioButton radiobuttonTwo;
    JRadioButton radiobuttonYes;
    JRadioButton radiobuttonNo;
    
    BorderLayout bl;
    
    JPanel panelButton;
    JPanel panelSundae;
    JPanel panelRadio=new JPanel();
    JPanel panelRadio2=new JPanel();
    JPanel panelMain=new JPanel();
    
    int temp;
    
    boolean nuts;
    
    ArrayList <String> scoops=new ArrayList<>();
    
    String extra_topping;
    
   ArrayList<IceCream> icecreamList;
   IceCream icTemp;
   
   Shop shop;
    
    private JRadioButton makeRadioButton(String label){
        JRadioButton rb=new JRadioButton(label);
        rb.addActionListener(this);
        panelRadio.add(rb);
        return rb;
    }
    
    private JRadioButton makeRadioButton2(String label){
        JRadioButton rb=new JRadioButton(label);
        rb.addActionListener(this);
        panelRadio2.add(rb);
        return rb;
    }
    public DialogSundae(Shop shop){
        Dimension size;
        size=new Dimension(350,300);
        
        buttonOK=new JButton("OK");
        buttonOK.addActionListener(this);
        
        bl = new BorderLayout();
        this.setLayout(bl);
        panelButton=new JPanel();
        GridLayout gl1=new GridLayout(1,1);
        panelButton.setLayout(gl1);
        
        panelButton.add(buttonOK);
        
        this.setSize(size);
        this.setLocationRelativeTo(null);
        this.setTitle("Ice Cream Sundae flavours");
        
        panelSundae=new JPanel();

        
        labelHowManyScoops=new JLabel("How Many Scoops Do You Want ?");
        labelFirstScoop=new JLabel("First Scoop");
        labelSecondScoop=new JLabel("Second Scoop");
        labelSyrup=new JLabel("Syrup");
        labelDoYouWantNuts=new JLabel("Do You want Nuts ?         ");
        
        this.shop=shop;
    
        panelRadio2.add(labelHowManyScoops);
        panelRadio.add(labelDoYouWantNuts);
        icecreamList=shop.sendIceCream();
       
        String line;
        int i=0;
           while(i<icecreamList.size())
           {
               icTemp=icecreamList.get(i);
               line=icTemp.getName();
               comboBoxFirstScoop.addItem(line);
               comboBoxSecondScoop.addItem(line);
                i++;
           }  
       
     comboBoxSyrup.addItem("Strawberry Syrup");
     comboBoxSyrup.addItem("Chocolate Syrup");
     comboBoxSyrup.addItem("Marshmallow Cream");
     comboBoxSyrup.addItem("Pineapple");
     comboBoxSyrup.addItem("Ketchup");
     comboBoxSyrup.addItem("Mustard");
     comboBoxSyrup.addItem("Pickle Relish");
     
     ButtonGroup groupNuts=new ButtonGroup();
     
    radiobuttonYes=makeRadioButton("Yes"); 
    radiobuttonNo=makeRadioButton("No");
    
    groupNuts.add(radiobuttonYes);
    groupNuts.add(radiobuttonNo);
    
    radiobuttonYes.setSelected(true);
    
    ButtonGroup groupScoop=new ButtonGroup();

    radiobuttonOne=makeRadioButton2("1");
    radiobuttonTwo=makeRadioButton2("2");

    groupScoop.add(radiobuttonOne);
    groupScoop.add(radiobuttonTwo);
    
    radiobuttonOne.setSelected(true);
      
      GridLayout g32=new GridLayout(3,2);
      panelSundae.setLayout(g32);
      
      panelSundae.add(labelFirstScoop);
      panelSundae.add(comboBoxFirstScoop);
      panelSundae.add(labelSecondScoop);
      panelSundae.add(comboBoxSecondScoop);
      panelSundae.add(labelSyrup);
      panelSundae.add(comboBoxSyrup);
      
      panelMain.add(panelRadio2);
      panelMain.add(panelSundae);
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
            Object result3=comboBoxSyrup.getSelectedItem();
            
            String FirstScoopName=result1.toString();
            String SecondScoopName=result2.toString();
            extra_topping=result3.toString();
            
            switch(temp){
            case 1:
              scoops.add(result1.toString()); 
              break;
            case 2:
               scoops.add(result1.toString());
               scoops.add(result2.toString());
               break;
            }
            
            shop.createSundae(nuts, extra_topping,scoops);
            
              dispose();
              DialogDessert dd=new DialogDessert(shop);
        }
       
       Object source=null;
        source=e.getSource();
        
        if(source==radiobuttonOne){
            temp=1;
            
        }
        else if(source==radiobuttonTwo){
            temp=2;
        } 
        switch(temp){
          case 1:
              this.comboBoxFirstScoop.setEnabled(true);
              this.comboBoxSecondScoop.setEnabled(false);
              break;
          case 2:
              this.comboBoxFirstScoop.setEnabled(true);
              this.comboBoxSecondScoop.setEnabled(true);
              break;
        }
        
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
