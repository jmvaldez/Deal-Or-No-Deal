package com.dealornodeal.model;

import java.util.*;

public class BriefcaseFactory {
    //Constructor
    private BriefcaseFactory() {
    }

    //TODO: Make static method w/ private ctor / static fields
    //initializes cases with rewards
    public static Map<Integer, Double> createBriefcases() {
        Map<Integer, Double> briefCases = new HashMap<>();
        int caseNumber = 1;
        final List<Double> rewards = Arrays.asList(.01, 1.0, 5.0, 10.0, 25.0, 50.0, 75.0, 100.0, 200.0,
                300.0, 400.0, 500.0, 750.0, 1_000.0, 5_000.0, 10_000.0, 25_000.0, 50_000.0, 75_000.0, 100_000.0,
                200_000.0, 300_000.0, 400_000.0, 500_000.0, 750_000.0, 1_000_000.0);

        //RewardValues rewardValues = new RewardValues();
        Collections.shuffle(rewards);
        for (double reward : rewards) {
            briefCases.put(caseNumber++, reward);
        }
        return briefCases;
    }
}