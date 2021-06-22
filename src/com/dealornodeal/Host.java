package com.dealornodeal;

import java.util.Collection;
import java.util.List;
import java.util.Map;

class Host {
    private String name = "Jarvis";


    public Host(String name) {
        this.name = name;
    }

    public double createOffer() {
        // Formulates offer based on the sum of the remaining cases
        // divided by the amount of available cases
        Game game = new Game();
        Collection<Double> offerFromSum = game.availableCases.values();
        double availCases = game.availableCases.size();
        double sum = 0.0;
        for (Double value : offerFromSum){
            sum += value;
        }
        System.out.println(sum/availCases);
        return sum/availCases;
        //for (Map.Entry<Integer, Double> entry : )
    }

    public double presentOffer() {
        return 0.0;
    }

}