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
//Mihika Naik
//1001097723
//09/16/2015
//CSE 1325-003

public class Stocker extends Worker {
    
    private int Stamina;
    private boolean Break;    
    

    public Stocker(long newID_number_of_worker,String newName_worker,long cServed,long sServed,double moneyTakenIn,int stamina) //Constructor Call to Child Class Stocker
    {
       
     
      super(newID_number_of_worker,newName_worker,cServed,sServed,moneyTakenIn); //Constructor Call to Parent Class Worker
    Stamina =stamina;
    if(Stamina==0){
        Break=true;
    }
    }
    
    //Function to set Stocker on Break
    public void OnBreak(){
        Break=true;
    }
    
    //Function to increase the Stamina of Stocker by 1
    public void IncreaseStamina(){
        if(Stamina<20){
        Stamina=Stamina+1;
        }
    }
    /**
     *
     */
    
    //Function to reduce the stamina of stocker by 1
    public void ReduceStamina(){
        Stamina=Stamina-1;
    }

 
    /**
     * @return the Stamina
     */
    public int getStamina() {
        return Stamina;
    }

    /**
     * @return the Break
     */
    public boolean isBreak() {
        return Break;
    }
}
