package com.dealornodeal.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Briefcase briefcase = new Briefcase();
    public static Map<Integer, Double> availableCases = briefcase.createBriefcases();

    // Our new map
    public static Map<Integer, Double> getAllBriefcases() {
        Map<Integer, Double> map = new HashMap<>();
        map.putAll(availableCases);
        //System.out.println("getAll" + map);
        return map;
    }

    public static double createOffer(Map<Integer, Double> briefcases) {
        // Formulates offer based on the sum of the remaining cases
        // divided by the amount of available cases
        double sum = 0.0;
        int availCases = briefcases.size();
        for (double value : briefcases.values()) {
            sum += value;
        }
        return Math.round(sum / availCases) + 125000;
    }
}