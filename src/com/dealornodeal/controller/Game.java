package com.dealornodeal.controller;

import com.apps.util.Prompter;
import com.dealornodeal.model.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Prompter prompter = new Prompter(new Scanner(System.in));
    private final String startText = prompter.info("Welcome to Deal or No Deal!!");

    private final Map<Integer, Double> mapAvailableBriefcases = Bank.getAllBriefcases();
    private final String pickFirstCase = prompter.prompt("Pick your first case: \n" + mapAvailableBriefcases.keySet(),
            "\\b(0?[1-9]|1[0-9]|2[0-6])\\b", "Choose a value from 1-26");

    public Map<Integer, Double> storedBriefcase = contestantsStoredCase(pickFirstCase);
    StringBuilder availableCases;

    public Game() {
    }

    public void startGame() {
        String pickCase;
        removeSelectedCase(pickFirstCase);
        availableCases = new StringBuilder(String.valueOf(mapAvailableBriefcases.keySet()).toString().replaceAll(",", " ] [ "));
        prompter.info("Choose 6 briefcases: \n" + availableCases);
        gameRounds();
    }

    private void offer() {
        prompter.info("Offer is: " + Bank.createOffer(mapAvailableBriefcases));
        String replyToOffer = prompter.prompt("Do you want to accept this offer? Deal or No Deal", "^(?:Deal\\b|No Deal\\b)", "Must be 'Deal' or 'No Deal'");
        acceptOffer(replyToOffer);
        if (replyToOffer.equals("Deal")) {
            endGame();
        } else {
            availableCases = new StringBuilder(String.valueOf(mapAvailableBriefcases.keySet()).toString().replaceAll(",", " ] [ "));
            prompter.info("\nChoose one of the following cases: \n" + availableCases);
        }
    }

    public boolean acceptOffer(String offerReply) {
        boolean acceptance = false;

        if (offerReply.equals("Deal")) {
            acceptance = true;
        } else if (offerReply.equals("No Deal")) {
            acceptance = false;
        }
        return acceptance;
    }

    private void endGame() {
        double hostOffer = Bank.createOffer(mapAvailableBriefcases);
        double contestantBriefCase = storedBriefcase.get(Integer.parseInt(pickFirstCase));

        if (contestantBriefCase > hostOffer) {
            //accepting the offer if your case is bigger than the offer
            prompter.info("Bad choice! You had the larger reward " + contestantBriefCase);
            prompter.info("Your case was worth $" + contestantBriefCase);
            prompter.info("The offer amount was $" + hostOffer);
        } else {
            //accepting the offer if your case is smaller than the offer
            prompter.info("You made the right choice! Your case had the smaller reward " + contestantBriefCase);
            prompter.info("Your case was worth $" + contestantBriefCase);
            prompter.info("The offer amount was $" + hostOffer);

        }
        System.exit(0);
    }

    private void finalRound() {
        prompter.info("If you want to keep your case " + storedBriefcase.keySet() + " type 'Keep' \n If you want the remaining case " +
                mapAvailableBriefcases.keySet() + " type 'Take'");
        String keepOrTake = prompter.prompt("Keep or Take?");
        if (keepOrTake.equals("Keep")) {
            prompter.info("You won" + String.valueOf(storedBriefcase.values()));
        } else if (keepOrTake.equals("Take")) {
            prompter.info("You won" + String.valueOf(mapAvailableBriefcases.values()));
        }
        prompter.info("Thanks for playing.");
        System.exit(0);
    }

    private void roundPrompt(int maxCaseCount) {
        String pickCase;
        int length;
        do {
            length = mapAvailableBriefcases.size();
            pickCase = prompter.prompt("Select case ", "\\b(0?[1-9]|1[0-9]|2[0-6])\\b", "Choose one of the remaining cases.");
            prompter.info("You chose case " + pickCase);

            if (mapAvailableBriefcases.containsKey(Integer.parseInt(pickCase))) {
                prompter.info("The value of that case is $" + mapAvailableBriefcases.get(Integer.parseInt(pickCase)) + "\n");
                removeSelectedCase(pickCase);
            } else {
                prompter.info("That case has already been selected. Please pick a new case.");
            }

            // When on offer Round do not prompt contestant to pick a case
            if (length != maxCaseCount) {
                availableCases = new StringBuilder(String.valueOf(mapAvailableBriefcases.keySet()).toString().replaceAll(",", " ] [ "));
                prompter.info("Choose one of the following cases: \n" + availableCases);
            }
        }
        while (length > maxCaseCount);
    }

    private void removeSelectedCase(String pickCase) {
        int chosenCase = Integer.parseInt(pickCase);
        mapAvailableBriefcases.remove(chosenCase);
    }

    public Map<Integer, Double> contestantsStoredCase(String pickCase) {
        Map<Integer, Double> map = new HashMap<>();

        int chosenCase = Integer.parseInt(pickCase);

        if (mapAvailableBriefcases.containsKey(chosenCase)) {
            double value = mapAvailableBriefcases.get(chosenCase);
            map.put(chosenCase, value);
        }
        prompter.info("Your case is " + map.keySet());
        return map;
    }

    private void gameRounds() {
        prompter.info("Round 1");
        roundPrompt(20);
        offer();

        prompter.info("\nRound 2");
        roundPrompt(15);
        offer();

        prompter.info("Round 3");
        roundPrompt(11);
        offer();

        prompter.info("Round 4");
        roundPrompt(8);
        offer();

        prompter.info("Round 5");
        roundPrompt(6);
        offer();

        prompter.info("Round 6");
        roundPrompt(5);
        offer();

        prompter.info("Round 7");
        roundPrompt(4);
        offer();

        prompter.info("Round 8");
        roundPrompt(3);
        offer();

        prompter.info("Round 9");
        roundPrompt(2);

        prompter.info("Round 10");
        finalRound();
    }
}