/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

//Mihika Naik
//1001097723
//09/16/2015
//CSE 1325-003

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mihika
 */


public class Shop {
      //Storing the Information
   private ArrayList <IceCream> icecreamList,tempIC; //An attriubte of type IceCream
   private Serving serving; //An attriubte of type Serving
   private ArrayList <Customer> customerList; //An attriubte of type Customer
   private ArrayList <Order> orderList; //An attriubte of type Order
   private CashRegister cashregister; //An attriubte of type CashRegister
   private ArrayList <Worker> workerList; //An attriubte of type Worker
   ArrayList <Cashier> cashierList; //An attriubte of type Worker
   ArrayList <Stocker> stockerList; //An attriubte of type Worker
   private Scanner keyboard;
   private IceCream tempIceCream,icTemp;
   private Worker tempWorker;
   private Customer tempCustomer; 
   private ArrayList <Serving> servings;
   private Order order;
   private Serving serTemp;
    private String answer;
    int order_count;
    private IceCreamCone Cone;
    private IceCreamSundae Sundae;
    private BananaSplit Split;
    private IceCreamSoda ICSoda;
    private RootBeerFloat RBF;
    static double priceRBF=1.25;
    boolean Rbf;
    boolean soda;
    private Cashier cash;
    private Stocker stock;
    public static Stocker Active_Stocker; 
    public static Cashier Active_Cashier;
    
    boolean noScoops;

    
   
   //Default constructor for Class Shop(SubController)
   public Shop(){
     icecreamList=new ArrayList<>(16);
     customerList=new ArrayList<>();
     orderList=new ArrayList<>();
     workerList=new ArrayList<>();
     cashierList=new ArrayList<>();
     stockerList=new ArrayList<>();
     cashregister=new CashRegister();
     keyboard=new Scanner(System.in);
     order_count=0;
     tempCustomer=new Customer();
     tempWorker=new Worker();
     tempIC=new ArrayList<>();
     servings=new ArrayList<>();
     
   }
   //Function to Load all the data from IceCream.txt to its corresponding ArrayList.
    public void LoadIceCream(ArrayList<String> dataStrings) {
        String line;
        String tokens[];
        long iTemp;
        String sNameTemp,sFlavorTemp,sDescriptionTemp;
        double dMoneyTemp;
        IceCream icTemp;
        int scoopsAvailable;
       int i=0;
           while(i<dataStrings.size())
           {
               line=dataStrings.get(i);
               line=line.replace(" ","");
               tokens=line.split(",");
               iTemp=Long.parseLong(tokens[0]);
               sNameTemp=tokens[2];
               dMoneyTemp=Double.parseDouble(tokens[1]);
               sFlavorTemp=tokens[3];
               sDescriptionTemp=tokens[4];
               scoopsAvailable=Integer.parseInt(tokens[5]);
               
               
               icTemp=new IceCream(scoopsAvailable,iTemp,sNameTemp,sFlavorTemp,sDescriptionTemp,dMoneyTemp);
               icecreamList.add(icTemp);    
               i++;
           }   
    

    }
    //Function to load all the data from Worker.txt to its corresponding ArrayList.
    public void LoadWorker(ArrayList<String> dataStrings) {

      String line;
      String tokens[];
      long lIDTemp;
      String type;
      String sNameTemp;
      Worker worTemp;
      long cServed;
      long sServed;
      double moneyEarned;
      int Patience;
      int Stamina;
      int i=0;
      while(i<dataStrings.size()){
                line=dataStrings.get(i);
                line=line.replace(" ","");
               tokens=line.split(",");
               type=tokens[1];
               if(type.equals("Worker")){
               lIDTemp=Long.parseLong(tokens[0]);
               sNameTemp=tokens[2];
               cServed=Long.parseLong(tokens[3]);
               sServed=Long.parseLong(tokens[4]);
               moneyEarned=Double.parseDouble(tokens[5]);
               worTemp=new Worker(lIDTemp,sNameTemp,cServed,sServed,moneyEarned);
               workerList.add(worTemp);

               }

               if(type.equals("Cashier")){
                lIDTemp=Long.parseLong(tokens[0]);
               sNameTemp=tokens[2];
               cServed=Long.parseLong(tokens[3]);
               sServed=Long.parseLong(tokens[4]);
               moneyEarned=Double.parseDouble(tokens[5]);
               Patience=Integer.parseInt(tokens[6]);
               cash=new Cashier(lIDTemp,sNameTemp,cServed,sServed,moneyEarned,Patience);
               workerList.add(cash);
               cashierList.add(cash);
              
               }

               if(type.equals("Stocker")){
                
               lIDTemp=Long.parseLong(tokens[0]);
               sNameTemp=tokens[2];
               cServed=Long.parseLong(tokens[3]);
               sServed=Long.parseLong(tokens[4]);
               moneyEarned=Double.parseDouble(tokens[5]);
               Stamina=Integer.parseInt(tokens[6]);
               stock=new Stocker(lIDTemp,sNameTemp,cServed,sServed,moneyEarned,Stamina);
               workerList.add(stock);
               stockerList.add(stock);

               }
               i++;

      } 
      
    }
    //Function to load all the data from Customer.txt to its correspongding ArrayList.
    public void LoadCustomer(ArrayList<String> dataStrings) {
        String line;
        String tokens[];
        long lIDTemp;
        String sNameTemp;
        double dMoneyTemp;
        int iLOHTemp;
        int Pennies;
        int Nickels;
        int Dimes;
        int Quarters;
        int Ones;
        int Fives;
        int Tens;
        int Twentys;
        Customer cusTemp;
       int i=0;
       while(i < dataStrings.size()){
           line=dataStrings.get(i);
           line=line.replace(" ","");
           tokens=line.split(",");
           lIDTemp=Long.parseLong(tokens[0]);
           sNameTemp=tokens[1];
           dMoneyTemp=Double.parseDouble(tokens[2]);
           iLOHTemp=Integer.parseInt(tokens[3]);
           Pennies=Integer.parseInt(tokens[4]);
           Nickels=Integer.parseInt(tokens[5]);
           Dimes=Integer.parseInt(tokens[6]);
           Quarters=Integer.parseInt(tokens[7]);
           Ones=Integer.parseInt(tokens[8]);
           Fives=Integer.parseInt(tokens[9]);
           Tens=Integer.parseInt(tokens[10]);
           Twentys=Integer.parseInt(tokens[11]);
           cusTemp=new Customer(iLOHTemp,Pennies,Nickels,Dimes,Quarters,Ones,Fives,Tens,Twentys,lIDTemp,sNameTemp,dMoneyTemp);
           customerList.add(cusTemp);
           i++;
          
        }

    }
    
   public void SetActiveStocker(String stockName){
     int iSize=stockerList.size();
       int loop;
       for(loop=0;loop<iSize;loop++){
           if(stockName.equals(stockerList.get(loop).getName_worker())){
               Active_Stocker=(Stocker) stockerList.get(loop);
           }
   }}
   
   public void SetActiveCashier(String cashName){
     int iSize=cashierList.size();
       int loop;
       for(loop=0;loop<iSize;loop++){
           if(cashName.equals(cashierList.get(loop).getName_worker())){
               Active_Cashier=(Cashier) cashierList.get(loop);
           }
   }
   }
   
    

   public void PayCredit(int loop) {
   
        order=orderList.get(loop);
        cashregister.increase_money(order.FindTotal());
        tempCustomer=order.getCustomer_order();
        tempWorker=order.getWorker_order();
        tempWorker.increaseMoneyTakenIn(order.FindTotal());
        tempWorker.increseCustomersServed();
        Active_Cashier.ReducePatience();
        if(Active_Cashier.getPatience()==0){
            Active_Cashier.OnBreak();
        }        
        servings=order.getServingList();
        order.change_Status();
        int count=servings.size();
        tempCustomer.increaseLOH(count);
   
   }

    //Function to process the payment as a cash and create change to be given back.
    //Also this function will make the necessary changes in customer and worker as well.
   
   public void PayCash(int loop,int penny,int nickel,int dime,int quarter,int one,int five,int ten,int twenty) {
   order=orderList.get(loop);
   tempCustomer=order.getCustomer_order();
   tempCustomer.subMoney(order.FindTotal());
   
   
   double totalMoney=(0.01*penny)+(0.05*nickel)+(0.1*dime)+(0.25*quarter)+one+(5*five)+(10*ten)+(20*twenty); 
   boolean mainLoop;
   mainLoop = true;
   String ans1;
   int change;
   change=cashregister.getPennies()+penny;
   cashregister.setPennies(change);
   change=cashregister.getNickels()+nickel;
   cashregister.setNickels(change);
   change=cashregister.getDimes()+dime;
   cashregister.setDimes(change);
   change=cashregister.getQuarters()+quarter;
   cashregister.setQuarters(change);
   change=cashregister.getOneDollar()+one;
   cashregister.setOneDollar(change);
   change=cashregister.getFiveDollar()+five;
   cashregister.setFiveDollar(change);
   change=cashregister.getTenDollar()+ten;
   cashregister.setTenDollar(change);
   change=cashregister.getTwentyDollar()+twenty;
   cashregister.setTwentyDollar(change);
   
   change=tempCustomer.getPennies()-penny;
   tempCustomer.setPennies(change);
   change=tempCustomer.getNickels()-nickel;
   tempCustomer.setNickels(change);
   change=tempCustomer.getDimes()-dime;
   tempCustomer.setDimes(change);
   change=tempCustomer.getQuarters()-quarter;
   tempCustomer.setQuarters(change);
   change=tempCustomer.getOnes()-one;
   tempCustomer.setOnes(change);
   change=tempCustomer.getFives()-five;
   tempCustomer.setFives(change);
   change=tempCustomer.getTens()-ten;
   tempCustomer.setTens(change);
   change=tempCustomer.getTwentys()-twenty;
   tempCustomer.setTwentys(change);
   
   double remainingAmount=totalMoney-order.getTotal();
  
  double temp;
  int temp2;
  double temp3;
  
  temp=remainingAmount/0.01;
  temp2=(int)temp;
  temp3=remainingAmount%0.01;
  
  if(temp2!=0&&temp2<=cashregister.getPennies()&&temp3==0.0){
     change=cashregister.getPennies()-temp2;
     cashregister.setPennies(change);
     change=tempCustomer.getPennies()+temp2;
       tempCustomer.setPennies(change);
       remainingAmount=remainingAmount-temp*0.01;    
  }
  
  temp=remainingAmount/0.05;
  temp2=(int)temp;
    temp3=remainingAmount%0.05;
  if(temp2!=0&&temp2<=cashregister.getNickels()&&temp3==0.0){
     change=cashregister.getNickels()-temp2;
     cashregister.setNickels(change);
     change=tempCustomer.getNickels()+temp2;
      tempCustomer.setNickels(change);
       remainingAmount=remainingAmount-temp*0.05;    
  }
  
   temp=remainingAmount/0.1;
  temp2=(int)temp;
    temp3=remainingAmount%0.1;
  if(temp2!=0&&temp2<=cashregister.getDimes()&&temp3==0.0){
     change=cashregister.getDimes()-temp2;
     cashregister.setDimes(change);
     change=tempCustomer.getDimes()+temp2;
      tempCustomer.setDimes(change);
       remainingAmount=remainingAmount-temp*0.1;    
  }
  
  temp=remainingAmount/0.25;
  temp2=(int)temp;
    temp3=remainingAmount%0.25;
  if(temp2!=0&&temp2<=cashregister.getQuarters()&&temp3==0.0){
     change=cashregister.getQuarters()-temp2;
     cashregister.setQuarters(change);
     change=tempCustomer.getQuarters()+temp2;
      tempCustomer.setQuarters(change);
       remainingAmount=remainingAmount-temp*0.25;    
  }
   
   temp=remainingAmount/1.0;
  temp2=(int)temp;
    temp3=remainingAmount%1.0;
  if(temp2!=0&&temp2<=cashregister.getOneDollar()&&temp3==0.0){
     change=cashregister.getOneDollar()-temp2;
     cashregister.setOneDollar(change);
     change=tempCustomer.getOnes()+temp2;
      tempCustomer.setOnes(change);
       remainingAmount=remainingAmount-temp*1.0;    
  }
  
    temp=remainingAmount/5.0;
  temp2=(int)temp;
    temp3=remainingAmount%5.0;
  if(temp2!=0&&temp2<=cashregister.getFiveDollar()&&temp3==0.0){
     change=cashregister.getFiveDollar()-temp2;
     cashregister.setFiveDollar(change);
     change=tempCustomer.getFives()+temp2;
      tempCustomer.setFives(change);
       remainingAmount=remainingAmount-temp*5.0;    
  }
   
  temp=remainingAmount/10.00;
  temp2=(int)temp;
    temp3=remainingAmount%10.00;
  if(temp2!=0&&temp2<=cashregister.getTenDollar()&&temp3==0.0){
     change=cashregister.getTenDollar()-temp2;
     cashregister.setTenDollar(change);
     change=tempCustomer.getTens()+temp2;
      tempCustomer.setTens(change);
       remainingAmount=remainingAmount-temp*10.00;    
  }
  
  temp=remainingAmount/20.00;
  temp2=(int)temp;
    temp3=remainingAmount%20.00;
  if(temp2!=0&&temp2<=cashregister.getTwentyDollar()&&temp3==0.0){
     change=cashregister.getTwentyDollar()-temp2;
     cashregister.setTwentyDollar(change);
     change=tempCustomer.getTwentys()+temp2;
      tempCustomer.setTwentys(change);
       remainingAmount=remainingAmount-temp*20.00;    
  }
  
   this.PayCredit(loop);
   
   }
   

   

    /**
     *
     * @return
     */
    
      public ArrayList sendCustomer(){
       return customerList;
   }
   /**
     *
     * @return
     */
    
      public ArrayList sendWorker(){
       return workerList;
   }
      /**
     *
     * @return
     */
    
         public ArrayList sendIceCream(){
       return icecreamList;
   }
         
        public ArrayList sendOrders(){
            return orderList;
        }
    
    public void getCustomerName(String cName){
        servings=new ArrayList<>();
        int iSize=customerList.size();
        Customer cusTemp;
        int loop;
        for(loop=0;loop<iSize;loop++){
        cusTemp=customerList.get(loop);
        if(cusTemp.getName().equals(cName)){

        tempCustomer=cusTemp;
        }
        }
        servings=new ArrayList<>();
        
    }
    
    public void getWorkerName(String wName){
       int iSize=workerList.size();
        Worker worTemp;
        int loop;
        for(loop=0;loop<iSize;loop++){
        worTemp=workerList.get(loop);
        if(worTemp.getName_worker().equals(wName)){

        tempWorker=worTemp;
        }
        } 
    }
        
    public void createCone(String cone,ArrayList<String> scoops){
       int iSize=icecreamList.size();
       double total=0.0;
       int i,j;
       for(i=0;i<scoops.size();i++){
           for(j=0;j<iSize;j++){
              icTemp=icecreamList.get(j);
              if(icTemp.getName().equals(scoops.get(i))){
                  if(icTemp.getScoops_Remaining()<=0){
                      noScoops=true;
                      NotEnoughIceCreamException neice=new NotEnoughIceCreamException(tempCustomer);
                  }
                  tempIC.add(icTemp);
                        if(Active_Stocker.isBreak()==true){
                           icTemp.ReduceScoops(); 
                        }
                        else{
                           Active_Stocker.ReduceStamina(); 
                           Active_Stocker.increaseScoops();
                           if(Active_Stocker.getStamina()==0){
                            Active_Stocker.OnBreak();
                            }
                        }         
                  total=total+icTemp.getPrice();
              }
           }  
       }
   Cone=new IceCreamCone(cone,tempIC,total);
   servings.add(Cone);

    }
    
    public void createSplit(boolean nuts, ArrayList<String> scoops,ArrayList<String> syrups){
        int iSize=icecreamList.size();
       double total=2.0;
       int i,j;
       for(i=0;i<scoops.size();i++){
           for(j=0;j<iSize;j++){
              icTemp=icecreamList.get(j);
              if(icTemp.getName().equals(scoops.get(i))){
                  if(icTemp.getScoops_Remaining()<=0){
                      noScoops=true;
                      NotEnoughIceCreamException neice=new NotEnoughIceCreamException(tempCustomer);
                  }
                  tempIC.add(icTemp);
                        if(Active_Stocker.isBreak()==true){
                           icTemp.ReduceScoops(); 
                        }
                        else{
                           Active_Stocker.ReduceStamina(); 
                           Active_Stocker.increaseScoops();
                           if(Active_Stocker.getStamina()==0){
                            Active_Stocker.OnBreak();
                            }
                        }         
                  total=total+icTemp.getPrice();
              }
           }  
       }
   Split=new BananaSplit(nuts,tempIC,syrups,total);
       servings.add(Split);
    }
    
    public void createSundae( boolean nuts,String topping, ArrayList<String> scoops){
       int iSize=icecreamList.size();
       double total=1.0;
       int i,j;
       for(i=0;i<scoops.size();i++){
           for(j=0;j<iSize;j++){
              icTemp=icecreamList.get(j);
              if(icTemp.getName().equals(scoops.get(i))){
                  if(icTemp.getScoops_Remaining()<=0){
                      noScoops=true;
                      NotEnoughIceCreamException neice=new NotEnoughIceCreamException(tempCustomer);
                  }
                  tempIC.add(icTemp);
                        if(Active_Stocker.isBreak()==true){
                           icTemp.ReduceScoops(); 
                        }
                        else{
                           Active_Stocker.ReduceStamina(); 
                           Active_Stocker.increaseScoops();
                           if(Active_Stocker.getStamina()==0){
                            Active_Stocker.OnBreak();
                            }
                        }         
                  total=total+icTemp.getPrice();
              }
           }  
       }
   Sundae=new IceCreamSundae(nuts,topping,tempIC,total);
   servings.add(Sundae);

        
        
    }
    
    public void createSoda(ArrayList<String> scoops){
       int iSize=icecreamList.size();
       double total=0.05;
       int i,j;
       for(i=0;i<scoops.size();i++){
           for(j=0;j<iSize;j++){
              icTemp=icecreamList.get(j);
              if(icTemp.getName().equals(scoops.get(i))){
                  if(icTemp.getScoops_Remaining()<=0){
                      noScoops=true;
                      NotEnoughIceCreamException neice=new NotEnoughIceCreamException(tempCustomer);
                  }
                  tempIC.add(icTemp);
                        if(Active_Stocker.isBreak()==true){
                           icTemp.ReduceScoops(); 
                        }
                        else{
                           Active_Stocker.ReduceStamina(); 
                           Active_Stocker.increaseScoops();
                           if(Active_Stocker.getStamina()==0){
                            Active_Stocker.OnBreak();
                            }
                        }         
                  total=total+icTemp.getPrice();
                  total=total+icTemp.getPrice();
              }
           }  
       }
   ICSoda=new IceCreamSoda(tempIC,total);
   servings.add(ICSoda);

    }
    
    public void createRBF(){
            icTemp=icecreamList.get(0);
            if(icTemp.getScoops_Remaining()<=0){
                      noScoops=true;
                      NotEnoughIceCreamException neice=new NotEnoughIceCreamException(tempCustomer);
                  }
            tempIC.add(icTemp);
            double total;
            total =1.25;
            RBF=new RootBeerFloat(tempIC,total);
            servings.add(RBF);
    }
    
    public  void createOrder(){
        order=new Order(tempCustomer,tempWorker,servings,order_count+1001,false);
        orderList.add(order);
        order_count=order_count+1;
        if(Active_Stocker.isBreak()==true){
            Active_Stocker.IncreaseStamina();
        } 
        
        for(int j=0;j<orderList.size();j++){
            Order temporder=orderList.get(j);

        }
    }
    
    public void ReduceLOH(int loop){
        order=orderList.get(loop);
        tempCustomer=order.getCustomer_order();
        tempCustomer.ReduceLOH();

    }
    public boolean CashierOnBreak(){
        return Active_Cashier.isBreak();
    }
    
    public boolean StockerOnBreak(){
        return Active_Stocker.isBreak();
    }
    public void SetCashierOnBreak(){
        Active_Cashier.OnBreak();
    }
    
    public void SetStockerOnBreak(){
        Active_Stocker.OnBreak();
    }
    
    public String Cashier(){
        return Active_Cashier.getName_worker();
    }
    
    public String Stocker(){
        return Active_Stocker.getName_worker();
    }
    
    public double sendCashInfo(){
        return cashregister.getCurrent_money();
    }
    
    public CashRegister sendCashRegister(){
        return cashregister;
    }
    
    public Cashier sendActiveCashier(){
        return Active_Cashier;
    }
    
    public Customer sendTempCustomer(){
        return tempCustomer;
}
}
    



   