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
public class DialogWorker extends JDialog implements ActionListener, ItemListener {

   JButton buttonOK; 
   
   JLabel  labelWorker;
   
   BorderLayout bl;
   
   JPanel panelButton;
   JPanel panelWorker;
   JPanel panelMain=new JPanel();

      
      
   JComboBox comboBoxWorker = new JComboBox();
   
    Shop shop;
    
    ArrayList<Worker> workerList;
    
    Worker worTemp;
   
   public DialogWorker(Shop shop){
      Dimension size;
      size=new Dimension(250,250); 
      Dimension sizeButton;
      //sizeButton=new Dimension(75,75); 
      Dimension sizeLabel;
      //sizeLabel=new Dimension(75,75); 
      
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
      this.setTitle("Worker");
      
      panelWorker=new JPanel();
      GridLayout g12=new GridLayout(1,2);
      panelWorker.setLayout(g12);
      panelMain.add(panelWorker);
      
      labelWorker=new JLabel("Worker            ");
      
      this.shop=shop;
      
       
      String line;
      int i=0;
      workerList=shop.sendWorker();
      
           while(i<workerList.size()){
               worTemp=workerList.get(i);
               line=worTemp.getName_worker();
               comboBoxWorker.addItem(line);
               i++;
           }

             
           
       


       comboBoxWorker.setBounds(2, 2, 75,75);

      panelWorker.add(labelWorker);
      panelWorker.add(comboBoxWorker);
      
      this.add(panelMain);
      this.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="OK")
        {
            Object result=comboBoxWorker.getSelectedItem();
            String WorkerName=result.toString();
            shop.getWorkerName(WorkerName);
        }
          dispose();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*  public static void main(String []args){
    DialogWorker dw=new DialogWorker();
    }
    */
}
