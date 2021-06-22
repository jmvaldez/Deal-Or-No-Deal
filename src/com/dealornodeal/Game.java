package com.dealornodeal;

public class Game {
    private String gameName = "Deal or No Deal";

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
        System.out.println("startRound");
    }

    private void endGame() {
        System.out.println("lastRound");

    }
}