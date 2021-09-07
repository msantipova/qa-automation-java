package com.tinkoff.edu.app;

/**
 * class Request
 */
public class LoanRequest {

    private final LoanType type;
    private final int months;
    private final int amount;
    private final String fio;

    public String getFio() {
        return fio;
    }

    public LoanType getType() {
        return type;
    }

    public LoanRequest(LoanType type, int months, int amount, String fio) {
        this.type = type;
        this.months = months;
        this.amount = amount;
        this.fio = fio;
    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        return "RQ: {" + getType() + ", " + this.getAmount() + " for " + this.getMonths()
                + "}  " + this.fio;
    }

}
