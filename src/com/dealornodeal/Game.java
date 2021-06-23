package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private String gameName = "Deal or No Deal";
    private String replyToOffer;

    private Bank bank = new Bank();
    private Host host = new Host("Jarvis");
    private Contestant contestant = new Contestant("Joe");

    private Prompter prompter = new Prompter(new Scanner(System.in));
    private String startText = prompter.info("Welcome to " + getName());
    private String pickFirstCase = prompter.prompt("Pick your first case: " + bank.getAllBriefcases().keySet());
    private Map<Integer, Double> availableBriefcases = bank.getAllBriefcases();

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

        int length;
        Round round = Round.ROUND_1;
        switch (round) {
            case ROUND_1:
                prompter.info(Round.ROUND_1.getFriendlyName());
                roundPrompt(20);

                prompter.info("Offer is: " + host.createOffer(availableBriefcases));
                replyToOffer = prompter.prompt("Do you want to accept this offer? Yes or No");
                contestant.acceptOffer(replyToOffer);
                if (replyToOffer.equals("Yes")) {
                    endGame();
                }

            case ROUND_2:
                System.out.println(Round.ROUND_2.getFriendlyName());
                roundPrompt(15);
            case ROUND_3:
                System.out.println(Round.ROUND_3.getFriendlyName());
                roundPrompt(11);
            case ROUND_4:
                System.out.println(Round.ROUND_4.getFriendlyName());
                roundPrompt(8);
            case ROUND_5:
                System.out.println(Round.ROUND_5.getFriendlyName());
                roundPrompt(6);
            case ROUND_6:
                System.out.println(Round.ROUND_6.getFriendlyName());
                roundPrompt(5);
            case ROUND_7:
                System.out.println(Round.ROUND_7.getFriendlyName());
                roundPrompt(4);
            case ROUND_8:
                System.out.println(Round.ROUND_8.getFriendlyName());
                roundPrompt(3);
                length = 4;
            case ROUND_9:
                System.out.println(Round.ROUND_9.getFriendlyName());
                roundPrompt(2);
            case ROUND_10:
                System.out.println(Round.ROUND_10.getFriendlyName());
                break;
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

    private void roundPrompt(int maxCaseCount) {
        String pickCase;
        int length;
        do {
            length = availableBriefcases.size();
            pickCase = prompter.prompt("Select case ");
            prompter.info("You chose case " + pickCase);
            removeSelectedCase(pickCase);
            prompter.info("Choose one of the following cases " + availableBriefcases);
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

        if (bank.getAllBriefcases().containsKey(chosenCase)) {
            double value = bank.getAllBriefcases().get(chosenCase);
            map.put(chosenCase, value);
        }
        prompter.info("Your case is " + map.keySet());
        return map;
    }
}