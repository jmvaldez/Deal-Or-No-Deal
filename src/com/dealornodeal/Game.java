package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private String gameName = "Deal or No Deal";
    Bank bank = new Bank();
    int round = 1;


    Prompter prompter = new Prompter(new Scanner(System.in));
    String startText = prompter.info("Welcome to " + getName());
    String pickFirstCase = prompter.prompt("Pick your first case: " + bank.getAllBriefcases().keySet());

    public Map<Integer, Double> storedBriefcase = contestantsStoredCase(pickFirstCase);
    public Map<Integer, Double> availableBriefcases = bank.getAllBriefcases();
    //public int length = availableBriefcases.size();

    public Game() {
    }

    public Game(String name) {
        this.gameName = getName();
    }


    public String getName() {
        return gameName;
    }

    public void startGame() {
//        if (length == 25){
//            while(length > 19)
//        }
        String pickCase;
        removeSelectedCase(pickFirstCase);
        prompter.info("Choose 6 briefcases " + availableBriefcases.keySet());
        //System.out.println("availablecases" + availableBriefcases.keySet());

        int length;
        Round round = Round.ROUND_1;
        prompter.info(Round.ROUND_1.getFriendlyName());
        roundPrompt(20);


        Round.ROUND_1.nextRound();
        prompter.info(Round.ROUND_2.getFriendlyName());
        roundPrompt(15);
        prompter.info(Round.ROUND_3.getFriendlyName());
        roundPrompt(11);
        prompter.info(Round.ROUND_4.getFriendlyName());
        roundPrompt(8);
        prompter.info(Round.ROUND_5.getFriendlyName());
        roundPrompt(6);
        prompter.info(Round.ROUND_6.getFriendlyName());
        roundPrompt(5);
        prompter.info(Round.ROUND_7.getFriendlyName());
        roundPrompt(4);
        prompter.info(Round.ROUND_8.getFriendlyName());
        roundPrompt(3);
        length = 4;
        prompter.info(Round.ROUND_9.getFriendlyName());
        roundPrompt(2);
        prompter.info(Round.ROUND_10.getFriendlyName());

    }

    private void roundPrompt(int maxCaseCount) {
        String pickCase;
        int length;
        do {
            length = availableBriefcases.size();
            pickCase = prompter.prompt("Select case ");
            prompter.info("You chose case " + pickCase);
            removeSelectedCase(pickCase);
            prompter.info("Choose one of the following cases " + availableBriefcases.keySet());
        }
        while (length > maxCaseCount);
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
        prompter.info("Your case is " + map.keySet());
        return map;
    }

    private void removeSelectedCase(String pickCase) {
        int chosenCase = Integer.parseInt(pickCase);
        availableBriefcases.remove(chosenCase);

    }
}