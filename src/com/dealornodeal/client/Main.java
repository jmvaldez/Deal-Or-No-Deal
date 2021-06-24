package com.dealornodeal.client;

import com.apps.util.SplashApp;
import com.dealornodeal.controller.Game;

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