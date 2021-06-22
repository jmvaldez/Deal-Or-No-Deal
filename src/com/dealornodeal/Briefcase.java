package com.dealornodeal;

import java.util.*;

public class Briefcase {
    //Fields
    private int caseNumber = 1;
    private double rewardAmount;
    public Map<Integer, Double> briefCases = new HashMap<>();

    //Constructor
    public Briefcase() {
    }

    public Briefcase(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }


    //initializes cases with rewards
    public Map<Integer, Double> createBriefcases() {
        RewardValues rewardValues = new RewardValues();
        Collections.shuffle(rewardValues.rewards);
        for (double reward : rewardValues.rewards) {
            briefCases.put(caseNumber++, reward);
        }
        System.out.println(briefCases);
        return briefCases;
    }

    //setDollarAmount is going match the rewards into a case
    public void setRewardAmount(double rewardAmount) {
        setRewardAmount(rewardAmount);
    }



    class RewardValues {
        //Fields
        private List<Double> rewards = Arrays.asList(.01, 1.0, 5.0, 10.0, 25.0, 50.0, 75.0, 100.0, 200.0,
                300.0, 400.0, 500.0, 750.0, 1_000.0, 5_000.0, 10_000.0, 25_000.0, 50_000.0, 75_000.0, 100_000.0,
                200_000.0, 300_000.0, 400_000.0, 500_000.0, 750_000.0, 1_000_000.0);

        //Constructor
        RewardValues() {
            //No-Arg
        }


        public List<Double> getAllRewards() {
            return Collections.unmodifiableList(rewards);
        }
    }
}