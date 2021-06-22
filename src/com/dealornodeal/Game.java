package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private String gameName = "Deal or No Deal";
    Bank bank = new Bank();

    Prompter prompter = new Prompter(new Scanner(System.in));
    String startText = prompter.info("Welcome to " + getName());
    String pickCase = prompter.prompt("Pick your first case: " + bank.getAllBriefcases().keySet());

    public Map<Integer, Double> storedBriefcase = contestantsStoredCase(pickCase);
    public Map<Integer, Double> availableBriefcases = bank.getAllBriefcases();

    public Game() {
    }

    public Game(String name) {
        this.gameName = getName();
    }


    public String getName() {
        return gameName;
    }

    public void startGame() {
        removeSelectedCase(pickCase);
        System.out.println("availablecases" + availableBriefcases);
    }

    private void endGame() {
        System.out.println("lastRound");
    }

    public Map<Integer, Double> contestantsStoredCase(String pickCase) {
        Map<Integer, Double> map = new HashMap<>();

        int chosenCase = Integer.parseInt(pickCase);

        if (bank.getAllBriefcases().containsKey(chosenCase)) {
            double value = bank.getAllBriefcases().get(chosenCase);
            map.put(chosenCase, value);
        }
        System.out.println(map);
        return map;
    }

    private void removeSelectedCase(String pickCase) {
        int chosenCase = Integer.parseInt(pickCase);
        availableBriefcases.remove(chosenCase);

    }
}