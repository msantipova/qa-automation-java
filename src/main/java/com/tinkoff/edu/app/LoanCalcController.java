package com.tinkoff.edu.app;

public class LoanCalcController {

    private LoanService service;

    public LoanCalcController(LoanService service) {
        this.service = service;
    }

    /**
     * TODO Validates and logs request
     *
     * @return Response
     */
    public LoanResponse createRequest(LoanRequest request) {
        return service.calculationAndSaveRequest(request);
    }

}
