package com.dealornodeal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoneyBoard {
    //Fields
    public List<Double> rewards = Arrays.asList(.01, 1.0, 5.0, 10.0, 25.0, 50.0, 75.0, 100.0, 200.0,
            300.0, 400.0, 500.0, 750.0, 1_000.0, 5_000.0, 10_000.0, 25_000.0, 50_000.0, 75_000.0, 100_000.0,
            200_000.0, 300_000.0, 400_000.0, 500_000.0, 750_000.0, 1_000_000.0);

    //Constructor
    public MoneyBoard() {
        //No-Arg
    }

    public List<Double> getAllRewards() {
        return Collections.unmodifiableList(rewards);
    }
}