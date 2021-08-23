package com.tinkoff.edu.app;

public final class LoanCalcController {

    /**
     * TODO Validates and logs request
     * @return requestId
     */
    public LoanResponse createRequest(LoanRequest request) {
        return new LoanCalcService().createRequest(request);
    }

}
