package com.tinkoff.edu.app;

/**
 * class for calculation request from IP
 */
public class IPLoanCalcService implements LoanService {
    private LoanCalcRepository repo;

    public IPLoanCalcService(int idRequest) {
        repo = new VariableLoanCalcRepository(idRequest);
    }

    /**
     * loan calculation
     * @param request
     * @return Response
     */
    @Override
    public LoanResponse calculationAndSaveRequest(LoanRequest request) {
            return new LoanResponse(ResponseType.DECLINED, repo.saveAndGenerateRequestId(request, ResponseType.DECLINED));
    }
}
