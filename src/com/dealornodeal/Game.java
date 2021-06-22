package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.Map;
import java.util.Scanner;

public class Game {
    private String gameName = "Deal or No Deal";
    private Map<Integer, Double> firstSelectedCase;

    Briefcase briefcase = new Briefcase();
    Map<Integer, Double> availableCases = briefcase.createBriefcases();

    Prompter prompter = new Prompter(new Scanner(System.in));
    String startText = prompter.info("Welcome to " + getName());
    String pickCase = prompter.prompt("Pick your first case: " + availableCases.keySet());

    public Game() {
    }

    public Game(String name) {
        this.gameName = getName();
    }

    public String getName() {
        return gameName;
    }

    public void startGame() {

    }

    private void endGame() {
        System.out.println("lastRound");
    }

    public int contestantInput(String pickCase) {
        int chosenCase = Integer.parseInt(pickCase);
        System.out.println(chosenCase);
        return chosenCase;
    }
}