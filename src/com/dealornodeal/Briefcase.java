package com.dealornodeal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Briefcase extends MoneyBoard {
    //Fields
    private int caseNumber = 1;
    private double rewardAmount;
    public Map<Integer, Double> briefCases = new HashMap<>();

    //Constructor
    public Briefcase() {
    }

    public Briefcase(int caseNumber, int rewardAmount) {
        this.caseNumber = caseNumber;
        this.rewardAmount = rewardAmount;
    }

    //Methods
    public int getCaseNumber() {
        return caseNumber;
    }

    //initializes cases with rewards
    public void createBriefcases() {
        Collections.shuffle(rewards);
        for (double reward : rewards) {
            briefCases.put(caseNumber++, reward);
        }
        //System.out.println(briefCases);
    }

    //setDollarAmount is going match the rewards into a case
    public void setRewardAmount(double rewardAmount) {
        setRewardAmount(rewardAmount);
    }

    public void openCase() {
        //create method
        System.out.println("Case #" + getCaseNumber() + " has $");
    }
}