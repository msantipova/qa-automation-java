package com.tinkoff.edu.app;

/**
 * class validates request
 */
public class LoanCalcController {

    private LoanService service;
    private int idRequest;

    public LoanCalcController() {
        idRequest = 0;
    }

    public LoanCalcController(int idRequest) {
        this.idRequest = idRequest;
    }

    /**
     * Validates and logs request
     * @param request
     * @return Response
     */
    public LoanResponse createRequest(LoanRequest request) {
        if ((request == null) || (request.getAmount() <= 0) || (request.getMonths() <= 0)) return new LoanResponse(null, -1);
         else if (request.getType() == LoanType.IP) service= new IPLoanCalcService(idRequest);
            else if (request.getType() == LoanType.OOO) service= new OOOLoanCalcService(idRequest);
            else if (request.getType() == LoanType.PERSON) service= new PersonLoanCalcService(idRequest);

        return service.calculationAndSaveRequest(request);
    }

}
