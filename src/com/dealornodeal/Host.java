package com.dealornodeal;

class Host {
    private String name = "Jarvis";
    Bank bank = new Bank();

    public Host(String name) {
        this.name = name;
    }

    public double createOffer() {
        // Formulates offer based on the sum of the remaining cases
        // divided by the amount of available cases
        double sum = 0.0;
        int availCases = bank.availableCases.size();
        for (double value : bank.availableCases.values()) {
            sum += value;
        }
        return sum / availCases;
    }

    public double presentOffer() {
        return 0.0;
    }
}