package com.dealornodeal.model.client;

import com.apps.util.SplashApp;
import com.dealornodeal.model.controller.Game;

class Main implements SplashApp {

    @Override
    public void start() {
        Game dealOrNoDeal = new Game();
        dealOrNoDeal.startGame();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.welcome("/images/DealorNoDealLogo.png");
        app.start();
    }
}