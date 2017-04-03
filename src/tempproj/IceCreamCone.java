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
public class IceCreamCone extends Serving{
    String cone;

    public IceCreamCone(String cone,ArrayList<IceCream> newScoops, double newPricePerServing) //Constructor Call to Child Class Ice Cream Cone.
    {
        
        super(newScoops, newPricePerServing);//Constructor Call to Parent Class Serving
    }
    
}
