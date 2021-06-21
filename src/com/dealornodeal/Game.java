package com.dealornodeal;

public class Game {
    private String gameName = "Deal or No Deal";

    private final Object startRound = Round.ROUND_1.getFriendlyName();
    private final Object lastRound = Round.ROUND_10.getFriendlyName();

    public Game() {
    }

    public Game(String name) {
        this.gameName = getName();
    }

    public String getName() {
        return gameName;
    }

    public void startGame() {
        System.out.println("Welcome to " + getName());
        System.out.println(startRound);
    }

    private void endGame() {
        System.out.println(lastRound);

    }
}