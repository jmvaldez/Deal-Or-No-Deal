package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private String gameName = "Deal or No Deal";
    private String replyToOffer;

    private final Host host = new Host("Jarvis");
    private final Contestant contestant = new Contestant("Joe");

    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final String startText = prompter.info("Welcome to " + getName());

    private final Map<Integer, Double> availableBriefcases = Bank.getAllBriefcases();
    private final String pickFirstCase = prompter.prompt("Pick your first case: " + availableBriefcases.keySet(),
            "\\b(0?[1-9]|1[0-9]|2[0-6])\\b","Choose a value from 1-26");

    //TODO: move to Contestant class
    public Map<Integer, Double> storedBriefcase = contestantsStoredCase(pickFirstCase);

    public Game() {
    }

    public String getName() {
        return gameName;
    }

    public void startGame() {
        String pickCase;
        removeSelectedCase(pickFirstCase);
        prompter.info("Choose 6 briefcases " + availableBriefcases.keySet());

        gameRounds();
    }

    private void offer() {
        prompter.info("Offer is: " + host.createOffer(availableBriefcases));
        replyToOffer = prompter.prompt("Do you want to accept this offer? Yes or No", "^(?:Yes\\b|No\\b)", "Must be 'Yes' or 'No'");
        contestant.acceptOffer(replyToOffer);
        if (replyToOffer.equals("Yes")) {
            endGame();
        }
    }

    private void endGame() {
//        if (offerAcceptedValue > valueOfYourCase) {
//            prompter.info("Congratulations! The offer was greater than you have in your case");
//        } else {
//            prompter.info("You made a bad decision! Your case had " + getSelectedCaseValue());
//        }
        System.exit(0);
    }

    private void finalRound() {
        prompter.info("If you want to keep your case type 'keep' \n If you want the remaining case type 'take'");
        String keepOrTake = prompter.prompt("keep or take?");
        if (keepOrTake.equals("keep")) {
            prompter.info(String.valueOf(storedBriefcase.values()));
        } else if (keepOrTake.equals("take")) {
            prompter.info(String.valueOf(availableBriefcases.values()));
        }
        endGame();
    }

    private void roundPrompt(int maxCaseCount) {
        String pickCase;
        int length;
        do {
            length = availableBriefcases.size();
            pickCase = prompter.prompt("Select case ","\\b(0?[1-9]|1[0-9]|2[0-6])\\b","Choose a value from the remaining cases");
            prompter.info("You chose case " + pickCase);
            if(availableBriefcases.containsKey(Integer.parseInt(pickCase))){
                prompter.info("The value of that case is " + availableBriefcases.get(Integer.parseInt(pickCase)));
                removeSelectedCase(pickCase);
            } else {
                prompter.info("That case has already been selected. Please pick a new case.");
            }
            prompter.info("Choose one of the following cases " + availableBriefcases.keySet());
        }
        while (length > maxCaseCount);
    }

    private void removeSelectedCase(String pickCase) {
        int chosenCase = Integer.parseInt(pickCase);
        availableBriefcases.remove(chosenCase);
    }

    //TODO: Move to Contestant class for storage
    public Map<Integer, Double> contestantsStoredCase(String pickCase) {
        Map<Integer, Double> map = new HashMap<>();

        int chosenCase = Integer.parseInt(pickCase);

        if (availableBriefcases.containsKey(chosenCase)) {
            double value = availableBriefcases.get(chosenCase);
            map.put(chosenCase, value);
        }
        prompter.info("Your case is " + map.keySet());
        return map;
    }

    private void gameRounds() {
        Round round = Round.ROUND_1;
        prompter.info(Round.ROUND_1.getFriendlyName());
        roundPrompt(20);
        offer();
        prompter.info(Round.ROUND_2.getFriendlyName());
        roundPrompt(15);
        offer();
        prompter.info(Round.ROUND_3.getFriendlyName());
        roundPrompt(11);
        offer();
        prompter.info(Round.ROUND_4.getFriendlyName());
        roundPrompt(8);
        offer();
        prompter.info(Round.ROUND_5.getFriendlyName());
        roundPrompt(6);
        offer();
        prompter.info(Round.ROUND_6.getFriendlyName());
        roundPrompt(5);
        offer();
        prompter.info(Round.ROUND_7.getFriendlyName());
        roundPrompt(4);
        offer();
        prompter.info(Round.ROUND_8.getFriendlyName());
        roundPrompt(3);
        offer();
        prompter.info(Round.ROUND_9.getFriendlyName());
        roundPrompt(2);
        offer();
        prompter.info(Round.ROUND_10.getFriendlyName());
        finalRound();
    }
}