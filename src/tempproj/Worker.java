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
public class Worker {
    String Name_worker;
    long ID_number_of_worker;
    long Customers_serverd;
    long No_of_scoops_served;
    double Money_taken_in;
    
    
    //Default Constructor for Class Worker
    public Worker(){
        
    }
    
    //Parametrized constructor for Class Worker.
    public Worker(long newID_number_of_worker,String newName_worker,long Customers_serverd,long No_of_scoops_served,double moneyEarned){
      ID_number_of_worker=newID_number_of_worker;
      Customers_serverd=Customers_serverd;
      No_of_scoops_served=No_of_scoops_served;
      Name_worker=newName_worker;
      Money_taken_in=moneyEarned;
    }
    
    //Function to increase the money taken in by a worker.
    public void increaseMoneyTakenIn(double FindTotal) {
        Money_taken_in=getMoney_taken_in()+FindTotal;
    }
    //Function to increase the number of Scoops served by a worker.
    public void increaseScoops() {
       No_of_scoops_served=getNo_of_scoops_served()+1; 
    }

    /**
     * @return the Name_worker
     */
    public String getName_worker() {
        return Name_worker;
    }

    /**
     * @return the ID_number_of_worker
     */
    public long getID_number_of_worker() {
        return ID_number_of_worker;
    }

    /**
     * @return the Customers_served
     */
    public long getCustomers_serverd() {
        return Customers_serverd;
    }

    /**
     * @return the No_of_scoops_served
     */
    public long getNo_of_scoops_served() {
        return No_of_scoops_served;
    }

    /**
     * @return the Money_taken_in
     */
    public double getMoney_taken_in() {
        return Money_taken_in;
    }

    void increseCustomersServed() {
        Customers_serverd=Customers_serverd+1;
    }
}
