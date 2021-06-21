package com.dealornodeal;

class Briefcase extends MoneyBoard{
    //Fields
    private int number;
    private int dollarAmount;

    //Constructor
    public Briefcase(int number, int dollarAmount) {
        this.number = number;
        this.dollarAmount = dollarAmount;
    }

    //Methods
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        setNumber(number);
    }

    public int getDollarAmount() {
        return dollarAmount;
    }

    public void setDollarAmount(int dollarAmount) {
        setDollarAmount(dollarAmount);
    }

    public void openCase(){
        //create method
        System.out.println("Case #" + getNumber() + " has $");
    }

}