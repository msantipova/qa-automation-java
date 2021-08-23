package com.tinkoff.edu.app;

/**
 * class Request
 */
public class LoanRequest {
    private final LoanType type;
    private final int months;
    private final int amount;

    public LoanType getType() {
        return type;
    }

    public LoanRequest(LoanType type, int months, int amount) {
        this.type = type;
        this.months = months;
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        return "RQ: {" + getType() +", " + this.getAmount() + " for " + this.getMonths()+ "}";
    }

}
