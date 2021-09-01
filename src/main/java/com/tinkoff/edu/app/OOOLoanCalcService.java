package com.tinkoff.edu.app;

/**
 * class for calculation request from OOO
 */
public class OOOLoanCalcService implements LoanService {
    private LoanCalcRepository repo;

    public OOOLoanCalcService(int idRequest) {
        repo = new VariableLoanCalcRepository(idRequest);
    }

    /**
     * loan calculation
     * @param request
     * @return Response
     */
    @Override
    public LoanResponse calculationAndSaveRequest(LoanRequest request) {
        if ((request.getAmount() > 10000) & (request.getMonths() < 12))
            return new LoanResponse(ResponseType.APPROVED, repo.saveAndGenerateRequestId(request, ResponseType.APPROVED));
        else
            return new LoanResponse(ResponseType.DECLINED, repo.saveAndGenerateRequestId(request, ResponseType.DECLINED));
    }

}
