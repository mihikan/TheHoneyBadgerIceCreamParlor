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
public class IceCreamSundae extends Serving{
    
    boolean Nuts;
    String extra_topping;
    public IceCreamSundae(boolean Nuts,String extra_topping,ArrayList<IceCream> newScoops, double newPricePerServing) //Constructor Call to Child Class Ice Cream Sundae.
    {
        super(newScoops, newPricePerServing);//Constructor Call to Parent Class Serving
    }
    
}
