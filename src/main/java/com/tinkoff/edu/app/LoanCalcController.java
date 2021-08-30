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
            if (request.getType() == LoanType.IP) service= new LoanCalcServiceIP();
            else if (request.getType() == LoanType.OOO) service= new LoanCalcServiceOOO();
            else if (request.getType() == LoanType.PERSON) service= new LoanCalcServicePerson();
            else return new LoanResponse(null, -1);
        return service.calculationAndSaveRequest(request);
    }

}
