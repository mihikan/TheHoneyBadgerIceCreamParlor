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
public class Customer {
    private long ID_number_of_customer;
    private String Name;
    int Level_of_Happiness;
    private double Money;
    private int Pennies;
    private int Nickels;
    private int Dimes;
    private int Quarters;
    private int Ones;
    private int Fives;
    private int Tens;
    private int Twentys;
    
    //Default constructor for Class Customer
    public Customer(){
        
    }
    //Parametrized constructor for Class Customer.
    public Customer(int newLevel_of_Happiness,int pennies,int nickels,int dimes,int quarters, int oneDollar,int fiveDollar, int tenDollar, int twentyDollar,long newID_number_of_customer, String newName,double newMoney ){
      ID_number_of_customer=newID_number_of_customer;
      Name=newName;
      Level_of_Happiness=newLevel_of_Happiness;
      Money=newMoney;
      Pennies=pennies;
      Nickels=nickels;
      Dimes=dimes;
      Quarters=quarters;
      Ones=oneDollar;
      Fives=fiveDollar;
      Tens=tenDollar;
      Twentys=twentyDollar;
    }

    /**
     * @return the ID_number_of_customer
     */
    public long getID_number_of_customer() {
        return ID_number_of_customer;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @return the Level_of_Happiness
     */
    public int getLevel_of_Happiness() {
        return Level_of_Happiness;
    }

    /**
     * @return the Money
     */
    public double getMoney() {
        return Money;
    }

    /**
     * @return the Pennies
     */
    public int getPennies() {
        return Pennies;
    }

    /**
     * @return the Nickels
     */
    public int getNickels() {
        return Nickels;
    }

    /**
     * @return the Dimes
     */
    public int getDimes() {
        return Dimes;
    }

    /**
     * @return the Quarters
     */
    public int getQuarters() {
        return Quarters;
    }

    /**
     * @return the Ones
     */
    public int getOnes() {
        return Ones;
    }

    /**
     * @return the Fives
     */
    public int getFives() {
        return Fives;
    }

    /**
     * @return the Tens
     */
    public int getTens() {
        return Tens;
    }

    /**
     * @return the Twenties
     */
    public int getTwentys() {
        return Twentys;
    }
    
     public void increaseLOH(int count) {
        setLevel_of_Happiness(Level_of_Happiness+count);
       
    }
    public void subMoney(double total) {
        setMoney(Money-total);
    }

    /**
     * @param ID_number_of_customer the ID_number_of_customer to set
     */
    public void setID_number_of_customer(long ID_number_of_customer) {
        this.ID_number_of_customer = ID_number_of_customer;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @param Level_of_Happiness the Level_of_Happiness to set
     */
    public void setLevel_of_Happiness(int Level_of_Happiness) {
        this.Level_of_Happiness = Level_of_Happiness;
    }

    /**
     * @param Money the Money to set
     */
    public void setMoney(double Money) {
        this.Money = Money;
    }

    /**
     * @param Pennies the Pennies to set
     */
    public void setPennies(int Pennies) {
        this.Pennies = Pennies;
    }

    /**
     * @param Nickels the Nickels to set
     */
    public void setNickels(int Nickels) {
        this.Nickels = Nickels;
    }

    /**
     * @param Dimes the Dimes to set
     */
    public void setDimes(int Dimes) {
        this.Dimes = Dimes;
    }

    /**
     * @param Quarters the Quarters to set
     */
    public void setQuarters(int Quarters) {
        this.Quarters = Quarters;
    }

    /**
     * @param Ones the Ones to set
     */
    public void setOnes(int Ones) {
        this.Ones = Ones;
    }

    /**
     * @param Fives the Fives to set
     */
    public void setFives(int Fives) {
        this.Fives = Fives;
    }

    /**
     * @param Tens the Tens to set
     */
    public void setTens(int Tens) {
        this.Tens = Tens;
    }

    /**
     * @param Twentys the Twentys to set
     */
    public void setTwentys(int Twentys) {
        this.Twentys = Twentys;
    }

    public void ReduceLOH() {
      Level_of_Happiness=Level_of_Happiness-1;
    }
    
    public boolean validate(int pennies, int nickles, int dimes, int quarters, int oneDollar, int fiveDollar, int tenDollar, int twentyDollar) {
        if (this.Pennies < pennies || this.Nickels < nickles || this.Dimes < dimes || this.Quarters < quarters
            || this.Ones < oneDollar || this.Fives < fiveDollar || this.Tens < tenDollar || this.Twentys < twentyDollar) {
            return true;
        }
        else return false;
    }
}


