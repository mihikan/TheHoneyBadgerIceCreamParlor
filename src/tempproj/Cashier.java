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
public class Cashier extends Worker{

    int Patience;
    private boolean Break;
    

    public Cashier(long newID_number_of_worker,String newName_worker,long cServed,long sServed,double moneyTakenIn,int patience) //Constructor call to Child class Cashier
    {
        
     
      super(newID_number_of_worker,newName_worker,cServed,sServed,moneyTakenIn); //Constructor Call to Parent Class Worker
    Patience=patience;
    if(Patience==0){
        Break=true;
    }
    }
    
    
    //Function to set Cashier on Break
    public void OnBreak(){
        Break=true;
    }
    
    //Function to Reduce the Patience of Cashier by 1
    public void ReducePatience(){
        
        Patience=Patience-1;
        
    }

   

    /**
     * @return the Patience
     */
    public int getPatience() {
        return Patience;
    }

    //Function to increase the patience of Cashier by 1
    public void IncreasePatience() {
        if(Patience<20){
        Patience=Patience+1;
    }}

    /**
     * @return the Break
     */
    public boolean isBreak() {
        return Break;
    }
    
}
