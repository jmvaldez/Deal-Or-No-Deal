package com.dealornodeal;

public class Game {
    private String gameName = "Deal or No Deal";

    private Game() {
    }

    public Game(String name){
        this.gameName = getName();
    }

    public String getName() {
        return gameName;
    }

    public void startGame(){
        System.out.println("Welcome to " + getName());
    }

    private void endGame(){

    }
}