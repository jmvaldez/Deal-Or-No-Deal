package com.dealornodeal.model;

import java.util.Map;

public class Bank {
    private static final Map<Integer, Double> availableCases = BriefcaseFactory.createBriefcases();

    public static Map<Integer, Double> getAllBriefcases() {
        return availableCases;
    }

    public static double createOffer(Map<Integer, Double> briefcases) {
        // Formulates offer based on the sum of the remaining cases
        // divided by the amount of available cases and adds an extra amount
        double sum = 0.0;
        int availCases = briefcases.size();
        for (double value : briefcases.values()) {
            sum += value;
        }
        return Math.round(sum / availCases) + 125000;
    }
}