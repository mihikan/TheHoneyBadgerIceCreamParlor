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
public class IceCream {
    long ID_Number; 
    String Flavor; //This is an attribute in IceCream
    String Description; //This is an attribute in IceCream
    double Price; //This is an attribute in IceCream
    String Name; //This is an attribute in IceCream
    int Scoops_Remaining;
    
    //Default constructor for Class Ice Cream
    public IceCream()
    {   
    }
 
    //Parametrized constructor for Class Ice Cream.
    public IceCream(int Scoops_Remaining,long newID_Number,String newName,String newFlavor,String newDescription,double newPrice ){
        
      ID_Number=newID_Number;
      Name=newName;
      Description=newDescription;
      Flavor=newFlavor;
      Price=newPrice;
      this.Scoops_Remaining=Scoops_Remaining;
    }
    
    public void ReduceScoops(){
        Scoops_Remaining=Scoops_Remaining-1;
    }

    /**
     * @return the ID_Number
     */
    public long getID_Number() {
        return ID_Number;
    }

    /**
     * @return the Flavor
     */
    public String getFlavor() {
        return Flavor;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @return the Scoops_Remaining
     */
    public int getScoops_Remaining() {
        return Scoops_Remaining;
    }

    
}
