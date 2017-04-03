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
public class NotEnoughMoneyException extends Exception {
    Customer customer;
    Cashier cashier;
    CashRegister cashreg;
    
    public NotEnoughMoneyException(Customer customer){
        this.customer = customer;
    
        this.customer.Level_of_Happiness-=1;
    }
    
     public NotEnoughMoneyException(Cashier cashier,CashRegister cashreg){
        this.cashier=cashier;
        this.cashier.Patience-=2;
        cashreg.setCurrent_money(cashreg.getCurrent_money()+48.8);
        cashreg.setPennies(cashreg.getPennies()+50);
        cashreg.setNickels(cashreg.getNickels()+40);
        cashreg.setDimes(cashreg.getDimes()+50);
        cashreg.setQuarters(cashreg.getQuarters()+40);
        cashreg.setOneDollar(cashreg.getOneDollar()+10);
        cashreg.setFiveDollar(cashreg.getFiveDollar()+2);
        cashreg.setTenDollar(cashreg.getTenDollar()+1);
        cashreg.setTwentyDollar(cashreg.getTwentyDollar()+0);
        
    }
}
