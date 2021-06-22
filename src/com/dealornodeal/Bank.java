package com.dealornodeal;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    Briefcase briefcase = new Briefcase();
    Map<Integer, Double> availableCases = briefcase.createBriefcases();


    // Our new map
    public Map<Integer, Double> getAllBriefcases() {
        Map<Integer, Double> map = new HashMap<>();
        map.putAll(availableCases);
        //System.out.println("getAll" + map);
        return map;
    }

    public void setBriefcase(Briefcase briefcase) {
        setBriefcase(briefcase);
    }

    public void removeBriefcase() {

    }
}