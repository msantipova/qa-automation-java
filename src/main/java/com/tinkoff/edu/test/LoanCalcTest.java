package com.tinkoff.edu.test;

import com.tinkoff.edu.app.LoanCalcController;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.LoanResponse;
import com.tinkoff.edu.app.LoanType;

/**
 * Loan Calc Test
 */
public class LoanCalcTest {

    public static void main(String[] args) {
        LoanRequest request = new LoanRequest(LoanType.IP, 7, 100000);
        LoanResponse response = new LoanCalcController().createRequest(request);
        System.out.println(request);
        System.out.println("requestId: " + response.getRequestId() + " must by 1");
        System.out.println("status: " + response.getResponseType());
    }

}
