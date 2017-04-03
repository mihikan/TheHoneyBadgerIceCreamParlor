/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

import java.util.ArrayList;

/**
 *
 * @author Mihika
 */
public class Order {
    private int Order_Number;
    private boolean Status;
    private Customer Customer_order;
    private Worker Worker_order;
    private boolean Payment_Type;
    private ArrayList <Serving> servingList;
    private double total;
    private Serving serving;
    
    //Parametrized constructor to class Order
    public Order(Customer newCustomer_order, Worker newWorker_order, ArrayList<Serving> newservingList,int newOrder_Number,boolean newStatus){
      Customer_order=newCustomer_order;
      Worker_order=newWorker_order;
      servingList=newservingList;
      Order_Number=newOrder_Number;
      Status=newStatus; 
          
    }

    
    /**
     * @return the Order_Number
     */
    public int getOrder_Number() {
        return Order_Number;
    }

    /**
     * @return the Status
     */
    public boolean isStatus() {
        return Status;
    }

    /**
     * @return the Customer_order
     */
    public Customer getCustomer_order() {
        return Customer_order;
    }

    /**
     * @return the Worker_order
     */
    public Worker getWorker_order() {
        return Worker_order;
    }

    /**
     * @return the Payment_Type
     */
    public boolean isPayment_Type() {
        return Payment_Type;
    }

    /**
     * @return the servingList
     */
    public ArrayList <Serving> getServingList() {
        return servingList;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        total=FindTotal();
        return total;
    }
    
    //Function to change status of payment of order
    public void change_Status(){
       Status=true; 
    }
    
    /**
     * @return the serving
     */
    public Serving getServing() {
        return serving;
    }
    //Function to find the total of the various servings within the order.
        public double FindTotal(){
        int loop;
        total=0.0;
        for(loop=0;loop<servingList.size();loop++){
        serving=servingList.get(loop);
        total=total+serving.getPricePerServing();
        }
          return total;
        }

  
}
