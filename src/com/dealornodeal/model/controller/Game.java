package com.dealornodeal.model.controller;

import com.apps.util.Prompter;
import com.dealornodeal.model.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Prompter prompter = new Prompter(new Scanner(System.in));
    private final String startText = prompter.info("Welcome to Deal or No Deal");

    private final Map<Integer, Double> mapAvailableBriefcases = Bank.getAllBriefcases();
    private final String pickFirstCase = prompter.prompt("Pick your first case: " + mapAvailableBriefcases.keySet(),
            "\\b(0?[1-9]|1[0-9]|2[0-6])\\b", "Choose a value from 1-26");

    public Map<Integer, Double> storedBriefcase = contestantsStoredCase(pickFirstCase);
    StringBuilder availableCases;

    public Game() {
    }

    public void startGame() {
        String pickCase;
        removeSelectedCase(pickFirstCase);
        availableCases = new StringBuilder(String.valueOf(mapAvailableBriefcases.keySet()).toString().replaceAll(",", " ] [ "));
        prompter.info("Choose 6 briefcases " + availableCases);
        gameRounds();
    }

    //TODO: move to Bank?
    private void offer() {
        prompter.info("Offer is: " + Bank.createOffer(mapAvailableBriefcases));
        String replyToOffer = prompter.prompt("Do you want to accept this offer? Yes or No", "^(?:Yes\\b|No\\b)", "Must be 'Yes' or 'No'");
        acceptOffer(replyToOffer);
        if (replyToOffer.equals("Yes")) {
            endGame();
        } else {
            prompter.info("Choose one of the following cases " + availableCases);
        }
    }

    public boolean acceptOffer(String offerReply) {
        boolean acceptance = false;
        if (offerReply.equals("Yes")) {
            acceptance = true;
        } else if (offerReply.equals("No")) {
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
            System.out.println("This is your case [ " + contestantBriefCase + " ]");
            System.out.println("This is the offer " + hostOffer);
        } else {
            //accepting the offer if your case is smaller than the offer
            prompter.info("You made the right choice! Your case had the smaller reward " + contestantBriefCase);
            System.out.println("This is your case [ " + contestantBriefCase + " ]");
            System.out.println("This is the offer " + hostOffer);

        }
        System.exit(0);
    }

    private void finalRound() {
        prompter.info("If you want to keep your case " + storedBriefcase.keySet() + " type 'keep' \n If you want the remaining case " +
                mapAvailableBriefcases.keySet() + " type 'take'");
        String keepOrTake = prompter.prompt("keep or take?");
        if (keepOrTake.equals("keep")) {
            prompter.info(String.valueOf(storedBriefcase.values()));
        } else if (keepOrTake.equals("take")) {
            prompter.info(String.valueOf(mapAvailableBriefcases.values()));
        }
        System.exit(0);
    }

    private void roundPrompt(int maxCaseCount) {
        String pickCase;
        int length;
        do {
            length = mapAvailableBriefcases.size();
            pickCase = prompter.prompt("Select case ", "\\b(0?[1-9]|1[0-9]|2[0-6])\\b", "Choose one of the remaining cases.");
            prompter.info("You chose case [ " + pickCase + " ]");
            if (mapAvailableBriefcases.containsKey(Integer.parseInt(pickCase))) {
                prompter.info("The value of that case is " + mapAvailableBriefcases.get(Integer.parseInt(pickCase)));
                removeSelectedCase(pickCase);
            } else {
                prompter.info("That case has already been selected. Please pick a new case.");
            }
            availableCases = new StringBuilder(String.valueOf(mapAvailableBriefcases.keySet()).toString().replaceAll(",", " ] [ "));
            prompter.info("Choose one of the following cases: \n" + availableCases);
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
        prompter.info("Your case is [ " + map.keySet() + " ]");
        return map;
    }

    private void gameRounds() {
        prompter.info("Round 1");
        roundPrompt(20);
        offer();

        prompter.info("Round 2");
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