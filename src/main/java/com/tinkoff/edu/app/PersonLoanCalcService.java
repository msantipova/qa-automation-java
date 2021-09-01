package com.tinkoff.edu.app;

/**
 * class for calculation request from Person
 */
public class PersonLoanCalcService implements LoanService {
    private LoanCalcRepository repo;

    public PersonLoanCalcService(int idRequest) {
        repo = new VariableLoanCalcRepository(idRequest);
    }

    /**
     * loan calculation
     * @param request
     * @return Response
     */
    @Override
    public LoanResponse calculationAndSaveRequest(LoanRequest request) {
        if ((request.getMonths() <= 12) && (request.getAmount() <= 10000))
            return new LoanResponse(ResponseType.APPROVED, repo.saveAndGenerateRequestId(request, ResponseType.APPROVED));
        else
            return new LoanResponse(ResponseType.DECLINED, repo.saveAndGenerateRequestId(request, ResponseType.DECLINED));
    }

}
