/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Mihika
 */
public class OurGui extends JFrame implements ActionListener{
    JMenuBar miniMenuBar;
    
    JMenu menuPlaceOrder;
    JMenu menuPayOrder;
    JMenu menuActiveWorker;
    JMenu menuCharts;
    JMenu menuLoads;
   
    JMenuItem itemLoadCustomer;
    JMenuItem itemLoadWorker;
    JMenuItem itemLoadIceCream;
    JMenuItem itemAbout;
    JMenuItem itemCustomer;
    JMenuItem itemWorker;
    JMenuItem itemDessert;
    JMenuItem itemSelectOrder;
    JMenuItem itemCashier;
    JMenuItem itemStocker;
    JMenuItem itemCashierOnBreak;
    JMenuItem itemStockerOnBreak;
    JMenuItem itemHappinessPie;
    JMenuItem itemHappinessBar;
    JMenuItem itemMoneyPie;
    JMenuItem itemMoneyBar;
    JMenuItem itemOrders;
    JMenuItem itemPeople;
    JMenuItem itemRegisters;
    JMenuItem itemInventory;
    
    JTextPane miniDocument;
    
    JPanel panelScreen=new JPanel();
    
    Shop shop=new Shop();
    
    JFileChooserDemo jfc;
    
    ArrayList<Order> orders;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public OurGui() throws IOException{
        
         this.setSize(750,460);
        
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //read image file in my HardDisk using imageIO and assign it to buffered image reference
         BufferedImage bf = ImageIO.read(new File("hb.png"));
         // adding created component to the JFrame using my backImage class
         this.setContentPane(new backImage(bf));
         //Set the Default Close
         this.setTitle("The Honey Badger Ice Cream Parlor");
         //Put on a MenuBar
        miniMenuBar=new JMenuBar();
        this.setJMenuBar(miniMenuBar);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        this.setLocation(x, y);


        //Mini Menu
        menuLoads=new JMenu("File");
        menuPlaceOrder=new JMenu("Place an Order");
        menuPayOrder=new JMenu("Pay for an Order");
        menuActiveWorker=new JMenu("Set Active Workers");
        menuCharts=new JMenu("Charts");
        
        //Add Menu
        miniMenuBar.add(menuLoads);
        miniMenuBar.add(menuPlaceOrder);
        miniMenuBar.add(menuPayOrder);
        miniMenuBar.add(menuActiveWorker);
        miniMenuBar.add(menuCharts);
        
        //Add Menu Item
        itemLoadCustomer= new JMenuItem("Load Customer");
        menuLoads.add(itemLoadCustomer);
        itemLoadCustomer.addActionListener(this);
        
        itemLoadWorker= new JMenuItem("Load Worker");
        menuLoads.add(itemLoadWorker);
        itemLoadWorker.addActionListener(this);
        
        itemLoadIceCream= new JMenuItem("Load Ice Cream");
        menuLoads.add(itemLoadIceCream);
        itemLoadIceCream.addActionListener(this);
        
        itemAbout=new JMenuItem("About");
        miniMenuBar.add(itemAbout);
        itemAbout.addActionListener(this);
        
        //Add Menu Item
        itemCustomer=new JMenuItem("Create Customer");
        menuPlaceOrder.add(itemCustomer);
        itemCustomer.addActionListener(this);
        
        //Add Menu Item
        itemWorker=new JMenuItem("Create Worker");
        menuPlaceOrder.add(itemWorker);
        itemWorker.addActionListener(this);
        
        //Add Menu Item
        itemDessert=new JMenuItem("Create Dessert");
        menuPlaceOrder.add(itemDessert);
        itemDessert.addActionListener(this);
        
        //Add Menu Item
        itemSelectOrder=new JMenuItem("Select Order");
        menuPayOrder.add(itemSelectOrder);
        itemSelectOrder.addActionListener(this);
        
        
        //Add Menu Item
        itemCashier=new JMenuItem("Set Active Chashier");
        menuActiveWorker.add(itemCashier);
        itemCashier.addActionListener(this);
        
        
        //Add Menu Item
        itemStocker=new JMenuItem("Set Active Stocker");
        menuActiveWorker.add(itemStocker);
        itemStocker.addActionListener(this);
        
        //Add Menu Item
        itemCashierOnBreak=new JMenuItem("Cashier on Break");
        menuActiveWorker.add(itemCashierOnBreak);
        itemCashierOnBreak.addActionListener(this);
        
        //Add Menu Item
        itemStockerOnBreak=new JMenuItem("Stocker on Break");
        menuActiveWorker.add(itemStockerOnBreak);
        itemStockerOnBreak.addActionListener(this);
        
        
        //Add Menu Item
        itemHappinessPie=new JMenuItem("Happiness Pie Chart");
        menuCharts.add(itemHappinessPie);
        itemHappinessPie.addActionListener(this);
        
        
        //Add Menu Item
        itemMoneyPie=new JMenuItem("Money Pie Chart");
        menuCharts.add(itemMoneyPie);
        itemMoneyPie.addActionListener(this);
        
        
        //Add Menu Item
        itemHappinessBar=new JMenuItem("Happiness Bar Chart");
        menuCharts.add(itemHappinessBar);
        itemHappinessBar.addActionListener(this);
        
        
        //Add Menu Item
        itemMoneyBar=new JMenuItem("Money Bar Chart");
        menuCharts.add(itemMoneyBar);
        itemMoneyBar.addActionListener(this);
        

        
        miniDocument=new JTextPane();

        this.add(miniDocument);
        
        //Set the Size
    
        //Turn on the Frame
        this.setVisible(true);
    
    }
   
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command=e.getActionCommand();
        switch(command){
            case"About":
                DialogAbout da=new DialogAbout();
                putLine("action:"+e.getActionCommand()+"\n"); 
                break;
            case "Load Customer":
                jfc=new JFileChooserDemo();
                ArrayList<String> data=jfc.doFileChooser();
                jfc.dispose();
                shop.LoadCustomer(data);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Load Worker":
                jfc=new JFileChooserDemo();
                ArrayList<String> data2=jfc.doFileChooser();
                jfc.dispose();
                shop.LoadWorker(data2);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Load Ice Cream":
                jfc=new JFileChooserDemo();
                ArrayList<String> data3=jfc.doFileChooser();
                jfc.dispose();
               shop.LoadIceCream(data3);
               putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Set Active Chashier":
                DialogActiveCashier dac=new DialogActiveCashier(shop);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Set Active Stocker":
                DialogActiveStocker das=new DialogActiveStocker(shop);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Cashier on Break":
                DialogCashierOnBreak dcob=new DialogCashierOnBreak(shop);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Stocker on Break":
                DialogStockerOnBreak dsob=new DialogStockerOnBreak(shop);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Happiness Pie Chart":
                HappinessPieChart demo = new HappinessPieChart("Happiness Pie Chart", "Happiness Pie Chart", shop);
                demo.pack();
                demo.setVisible(true);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Money Pie Chart":
                MoneyPieChart moneyPieChart = new MoneyPieChart("Money Pie Chart", "Money Pie Chart", shop);
                moneyPieChart.pack();
                moneyPieChart.setVisible(true);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Happiness Bar Chart":
                HappinessBarChart hbc = new HappinessBarChart("Money Pie Chart", "Happiness Bar Chart", shop, "Customer Name", "Level of Happiness");
                hbc.pack();
                hbc.setVisible(true);
                putLine("action:"+e.getActionCommand()+"\n");
                break;
            case "Money Bar Chart":
                MoneyBarChart mbc = new MoneyBarChart("Money Bar Chart", "Money Bar Chart", shop, "Worker Name", "Money Earned");
                mbc.pack();
                mbc.setVisible(true);
                putLine("action:"+e.getActionCommand()+"\n");
                break;                
        }
        switch(command){
        case "Create Customer":
                DialogCustomer dc=new DialogCustomer(shop);
                putLine("action:"+command+"\n");
                break;
        case "Create Worker":
                DialogWorker dw=new DialogWorker(shop);
                putLine("action:"+command+"\n");
                break;
        case "Create Dessert":
                DialogDessert dd=new DialogDessert(shop);
                putLine("action:"+command+"\n");
                break;
        case "Select Order":
                DialogSelectOrder dso=new DialogSelectOrder(shop);
                putLine("action:"+command+"\n");
                break;
        }
        
        
    }
    
    private void putLine(String line) {
        miniDocument.setText(miniDocument.getText()+line);
    }
    
    public static void main(String []args) throws IOException{
       OurGui og=new OurGui(); 
    }
}