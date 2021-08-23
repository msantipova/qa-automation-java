package com.tinkoff.edu.app;

public class LoanCalcService {

    /**
     * TODO loan calculation
     * @return
     */
    public LoanResponse createRequest(LoanRequest request) {
       return new LoanCalcRepository().save(request);
    }

}
