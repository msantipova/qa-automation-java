package com.tinkoff.edu.app;

public class LoanCalcController {

    private LoanService repo;

    public LoanCalcController(LoanService Srepo){
        this.repo = Srepo;
    }

    /**
     * TODO Validates and logs request
     * @return requestId
     */
    public LoanResponse createRequest(LoanRequest request) {
        return repo.createRequest(request);
    }

}
