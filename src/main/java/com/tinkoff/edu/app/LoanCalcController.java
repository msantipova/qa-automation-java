package com.tinkoff.edu.app;

public final class LoanCalcController {

    LoanCalcService loanCalcService = new LoanCalcService();

    /**
     * TODO Validates and logs request
     * @return requestId
     */
    public LoanResponse createRequest(LoanRequest request) {
        return loanCalcService.createRequest(request);
    }

}
