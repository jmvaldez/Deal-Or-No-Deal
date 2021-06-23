package com.dealornodeal;

import java.util.Map;

class Host {
    private String name = "Jarvis";

    public Host(String name) {
        this.name = name;
    }

    public double createOffer(Map<Integer, Double> briefcases) {
        // Formulates offer based on the sum of the remaining cases
        // divided by the amount of available cases
        double sum = 0.0;
        int availCases = briefcases.size();
        for (double value : briefcases.values()) {
            sum += value;
        }
        return Math.round(sum / availCases);
    }
}