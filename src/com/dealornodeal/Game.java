package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private String gameName = "Deal or No Deal";

    Briefcase briefcase = new Briefcase();
    Map<Integer, Double> availableCases = briefcase.createBriefcases();

    Prompter prompter = new Prompter(new Scanner(System.in));
    String startText = prompter.info("Welcome to " + getName());
    String pickCase = prompter.prompt("Pick your first case: " + availableCases.keySet());

    public Map<Integer, Double> storedBriefcase = contestantsStoredCase(pickCase);

    public Game() {
    }

    public Game(String name) {
        this.gameName = getName();
    }


    public String getName() {
        return gameName;
    }

    public Map<Integer, Double> getAvailableCases() {
        return availableCases;
    }

    public void startGame() {
        Contestant contestant = new Contestant();
        System.out.println(contestant.length);
    }


    private void endGame() {
        System.out.println("lastRound");
    }

    public Map<Integer, Double> contestantsStoredCase(String pickCase) {
        Map<Integer, Double> map = new HashMap<>();

        int chosenCase = Integer.parseInt(pickCase);

        if (availableCases.containsKey(chosenCase)) {
            double value = availableCases.get(chosenCase);
            map.put(chosenCase, value);
        }
        return map;
    }
}