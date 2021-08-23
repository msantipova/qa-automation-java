package com.tinkoff.edu.test;

import com.tinkoff.edu.app.*;

import java.util.Random;

/**
 * Loan Calc Test
 */
public class LoanCalcTest {

    public static void main(String[] args) {
        Random random = new Random();
        for (int count = 0; count < 5; count++) {
            LoanRequest request = new LoanRequest(LoanType.IP, random.nextInt(11) + 1, 100000);
            LoanResponse response = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository())).createRequest(request);
            System.out.println(request);
            System.out.println("requestId: " + response.getRequestId() + " must by 1");
            System.out.println("status: " + response.getResponseType());
        }
    }

}
