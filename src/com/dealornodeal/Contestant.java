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
    public boolean acceptOffer(String offerReply) {
        boolean acceptance = false;
        if(offerReply.equals("Yes")){
            acceptance = true;
        }else if(offerReply.equals("No")){
            acceptance = false;
        }
        return acceptance;
    }

    public void declineOffer() {
        System.out.println(contestantName + " declines offer!");
    }
}