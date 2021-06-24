package com.dealornodeal.model.client;

import com.apps.util.Prompter;
import com.apps.util.SplashApp;
import com.dealornodeal.model.controller.Game;

import java.util.Scanner;

class Main implements SplashApp {

    @Override
    public void start() {
        Game dealOrNoDeal = new Game();
        dealOrNoDeal.startGame();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.welcome();
        app.start();
    }
}