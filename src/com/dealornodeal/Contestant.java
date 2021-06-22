package com.dealornodeal;

public class Contestant {
    //Fields
    private String contestantName;
    Briefcase briefcase = new Briefcase();

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
        System.out.println(contestantName + "chooses briefcase number " + briefcase.getCaseNumber());
    }
}