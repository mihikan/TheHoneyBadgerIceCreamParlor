/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempproj;

import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class NotEnoughIceCreamException  
{
    Customer customer;
    ArrayList<Order> orders;

    public NotEnoughIceCreamException(Customer customer) 
    {
        //super("There is not enough Icecream to place the order");
        this.customer = customer;
    
        this.customer.Level_of_Happiness-=2;
       // System.out.println(this.getMessage());
    }
}
