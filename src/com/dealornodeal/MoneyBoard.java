package com.dealornodeal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class MoneyBoard {
    //Fields
    private double dollarAmount;
    private Collection<Double> rewards = new ArrayList<>();

    //Constructor
    public MoneyBoard(){
    }

    public MoneyBoard(double dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    //Methods
    public double getDollarAmount() {
        return dollarAmount;
    }

    public void setDollarAmount(double dollarAmount) {
        setDollarAmount(dollarAmount);
    }

    public void displayAmount(){
        //
    }

//    private List<MoneyRewards> rewards = new ArrayList(Arrays.asList( new MoneyBoard(.01), new MoneyBoard(1), new MoneyBoard(5), new MoneyBoard(10)));


    static {
        
    }
}