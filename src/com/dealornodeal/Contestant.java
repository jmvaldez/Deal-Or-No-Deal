package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.Scanner;

public class Contestant {
    //Fields
    private String contestantName;
    Briefcase briefcase = new Briefcase();
    int round = 1;
    length =bank.availableCases.size()

    //Ctor
    public Contestant() {
    }//no-op


    public Contestant(String contestantName) {
        setContestantName(contestantName); //delegate to setter
    }

    //setters & getters
    public void setContestantName(String contestantName) {
        this.contestantName = contestantName;
    }

    public String getContestantName() {
        return contestantName;
    }

    //Methods (what business method can Contestant do?)
    public void acceptOffer() {
        System.out.println(contestantName + " accepts offer!");
    }

    public void declineOffer() {
        System.out.println(contestantName + " declines offer!");
    }

    public void chooseBriefCase() {
        //System.out.println(contestantName + "chooses briefcase number " + briefcase.getCaseNumber());
        //Game game = new Game();

        switch (round)
        {
            case 1 : length = 25;
                break;
            case 2 : length = 19;
                break;
            case 3 : length  = 14;
                break;
            case 4 : length = 10;
                break;
            case 5 : length = 7;
                break;
            case 6 : length = 6;
            break;
            case 6 : length = 5;
                break;
            case 6 : length = 4;
                break;
            case 6 : length = 3;
                break;
            case 6 : length = 2;
                break;
        }

        


//        public Round nextRound() {
//            return this.ordinal() < Round.values().length - 1
//                    ? Round.values()[this.ordinal() + 1]
//                    : null;
//        }
    }
}