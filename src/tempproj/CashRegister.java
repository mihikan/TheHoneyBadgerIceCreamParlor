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
public class CashRegister {
private double current_money;
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int oneDollar;
    private int fiveDollar;
    private int tenDollar;
    private int twentyDollar;
    private int tpennies;//Temporary varibles
    private int tnickels;//Temporary varibles
    private int tdimes;//Temporary varibles
    private int tquarters;//Temporary varibles
    private int toneDollar;//Temporary varibles
    private int tfiveDollar;//Temporary varibles
    private int ttenDollar;//Temporary varibles
    private int ttwentyDollar;//Temporary varibles
    
    //Constructur for Cash Register
    public CashRegister()
    {
    current_money=48.8;
    pennies=50;
    nickels=40;
    dimes=50;
    quarters=40;
    oneDollar=10;
    fiveDollar=2;
    tenDollar=1;
    twentyDollar=0;
    
    /*   pennies=0;
    nickels=0;
    dimes=0;
    quarters=0;
    oneDollar=0;
    fiveDollar=0;
    tenDollar=0;
    twentyDollar=0;*/
    
    
}
    public void increase_money(double newMoney){
        current_money=current_money+newMoney;
    }
    //Function to calculate the change to be given back. 
    public void transaction(double cash,double price){
      double return_amount;
      int multiplier;
      double temp;
      return_amount=cash-price;
      if(return_amount!=0){
          if((return_amount/20.00)!=0){
            multiplier= (int)(return_amount/20.00);
            temp=20.00*multiplier;
            return_amount=return_amount-temp;
            twentyDollar=twentyDollar-multiplier;
            ttwentyDollar=getTtwentyDollar()+multiplier;
            if((return_amount/10.00)!=0){
                multiplier= (int)(return_amount/10.00);
                temp=10.00*multiplier;
                return_amount=return_amount-temp;
                tenDollar=tenDollar-multiplier;
                ttenDollar=getTtenDollar()+multiplier;
                if((return_amount/5.00)!=0){
                    multiplier= (int)(return_amount/5.00);
                    temp=5.00*multiplier;
                    return_amount=return_amount-temp;
                    fiveDollar=fiveDollar-multiplier;
                    tfiveDollar=getTfiveDollar()+multiplier;
                    if((return_amount/1.00)!=0){
                        multiplier= (int)(return_amount/1.00);
                        temp=1.00*multiplier;
                        return_amount=return_amount-temp;
                        oneDollar=oneDollar-multiplier;
                        toneDollar=getToneDollar()+multiplier;
                        if((return_amount/0.25)!=0){
                            multiplier= (int)(return_amount/0.25);
                            temp=0.25*multiplier;
                            return_amount=return_amount-temp;
                            quarters=quarters-multiplier;
                            tquarters=getTquarters()+multiplier;
                            if((return_amount/0.10)!=0){
                                multiplier= (int)(return_amount/0.10);
                                temp=0.10*multiplier;
                                return_amount=return_amount-temp;
                                dimes=dimes-multiplier;
                                tdimes=getTdimes()+multiplier;
                                if((return_amount/0.05)!=0){
                                    multiplier= (int)(return_amount/0.05);
                                    temp=0.05*multiplier;
                                    return_amount=return_amount-temp;
                                    nickels=nickels-multiplier;
                                    tnickels=getTnickels()+multiplier;
                                    if((return_amount/0.01)==0){
                                        multiplier= (int)(return_amount/0.01);
                                        temp=0.01*multiplier;
                                        return_amount=return_amount-temp;
                                        pennies=pennies-
                                                multiplier;
                                        pennies=pennies+multiplier;
                                                                               
                                    }

                                }
                            }
                        }
                    }
                }
                
             
            }
          }
      }
    }

    /**
     * @return the current_money
     */
    public double getCurrent_money() {
        return current_money;
    }

    /**
     * @param current_money the current_money to set
     */
    public void setCurrent_money(double current_money) {
        this.current_money = current_money;
    }

    /**
     * @return the pennies
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * @param pennies the pennies to set
     */
    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    /**
     * @return the nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * @param nickels the nickels to set
     */
    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /**
     * @return the dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * @param dimes the dimes to set
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * @return the quarters
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * @param quarters the quarters to set
     */
    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    /**
     * @return the oneDollar
     */
    public int getOneDollar() {
        return oneDollar;
    }

    /**
     * @param oneDollar the oneDollar to set
     */
    public void setOneDollar(int oneDollar) {
        this.oneDollar = oneDollar;
    }

    /**
     * @return the fiveDollar
     */
    public int getFiveDollar() {
        return fiveDollar;
    }

    /**
     * @param fiveDollar the fiveDollar to set
     */
    public void setFiveDollar(int fiveDollar) {
        this.fiveDollar = fiveDollar;
    }

    /**
     * @return the tenDollar
     */
    public int getTenDollar() {
        return tenDollar;
    }

    /**
     * @param tenDollar the tenDollar to set
     */
    public void setTenDollar(int tenDollar) {
        this.tenDollar = tenDollar;
    }

    /**
     * @return the twentyDollar
     */
    public int getTwentyDollar() {
        return twentyDollar;
    }

    /**
     * @param twentyDollar the twentyDollar to set
     */
    public void setTwentyDollar(int twentyDollar) {
        this.twentyDollar = twentyDollar;
    }

    /**
     * @return the tpennies
     */
    public int getTpennies() {
        return tpennies;
    }

    /**
     * @return the tnickels
     */
    public int getTnickels() {
        return tnickels;
    }

    /**
     * @return the tdimes
     */
    public int getTdimes() {
        return tdimes;
    }

    /**
     * @return the tquarters
     */
    public int getTquarters() {
        return tquarters;
    }

    /**
     * @return the toneDollar
     */
    public int getToneDollar() {
        return toneDollar;
    }

    /**
     * @return the tfiveDollar
     */
    public int getTfiveDollar() {
        return tfiveDollar;
    }

    /**
     * @return the ttenDollar
     */
    public int getTtenDollar() {
        return ttenDollar;
    }

    /**
     * @return the ttwentyDollar
     */
    public int getTtwentyDollar() {
        return ttwentyDollar;
    }
    
    
    
}
