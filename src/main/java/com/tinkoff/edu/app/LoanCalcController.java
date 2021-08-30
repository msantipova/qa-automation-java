package com.tinkoff.edu.app;

public class LoanCalcController {

    private LoanService service;

    public LoanCalcController(LoanService service) {
        this.service = service;
    }

    public LoanCalcController() {
        this.service = new LoanCalcService(new StaticVariableLoanCalcRepository());
    }

    public LoanCalcController(int idRequest) {
        this.service = new LoanCalcService(new StaticVariableLoanCalcRepository(idRequest));
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
