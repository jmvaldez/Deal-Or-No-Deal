package com.dealornodeal;

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

    public void removeBriefcase() {

    }
}