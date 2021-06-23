package com.dealornodeal;

import com.apps.util.Prompter;

import java.util.Scanner;

public class Contestant {
    //Fields
    private String contestantName;
    Bank bank = new Bank();


    //Ctor
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
}