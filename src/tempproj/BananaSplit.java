package tempproj;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mihika
 */
public class BananaSplit extends Serving {
    boolean nuts;
    ArrayList<String> syrups=new ArrayList<>();
    
    public BananaSplit(boolean nuts,ArrayList<IceCream> newScoops, ArrayList<String> syrups,double newPricePerServing) //Constructor of Child Class Banana Split 
    {
        super(newScoops,newPricePerServing);//Constructor Call to Parent Class Ice Cream Sundae 
    }
    
}
