package com.tinkoff.edu.test;

import com.tinkoff.edu.app.LoanCalcController;

/**
 * Loan Calc Test
 */
public class LoanCalcTest {
    public static void main (String[] args) {
        int reguestId = LoanCalcController.createRequest();
        System.out.println(reguestId + " must by 1");
    }
}