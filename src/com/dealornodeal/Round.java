package com.dealornodeal;

enum Round {
    ROUND_1("Round 1")
    ,ROUND_2("Round 2")
    ,ROUND_3("Round 3")
    ,ROUND_4("Round 4")
    ,ROUND_5("Round 5")
    ,ROUND_6("Round 6")
    ,ROUND_7("Round 7")
    ,ROUND_8("Round 8")
    ,ROUND_9("Round 9")
    ,ROUND_10("Round 10");

    //FIELD
    private final String friendlyName;

    // CONSTRUCTOR
    Round(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}
