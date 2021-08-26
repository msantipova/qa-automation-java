package com.tinkoff.edu.app;

public class LoanCalcController {

    private LoanService Service;

    public LoanCalcController(LoanService Service) {
        this.Service = Service;
    }

    /**
     * TODO Validates and logs request
     *
     * @return Response
     */
    public LoanResponse createRequest(LoanRequest request) {
        return Service.calculationAndSaveRequest(request);
    }

}
