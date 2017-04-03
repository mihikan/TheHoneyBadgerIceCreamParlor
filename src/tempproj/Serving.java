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
public class Serving {
    double PricePerServing;
    ArrayList <IceCream> Scoops;
    
    //Parametrized constructor for class Serving
    public Serving(ArrayList<IceCream> newScoops, double newPricePerServing)
    {
    Scoops=newScoops;
    PricePerServing=newPricePerServing;
        
    }

    /**
     * @return the PricePerServing
     */
    public double getPricePerServing() {
        return PricePerServing;
    }

    /**
     * @return the Scoops
     */
    public ArrayList <IceCream> getScoops() {
        return Scoops;
    }


}
