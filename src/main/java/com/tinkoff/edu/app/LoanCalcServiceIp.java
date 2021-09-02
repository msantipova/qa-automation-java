package com.tinkoff.edu.app;

/**
 * class for calculation request from IP
 */
public class LoanCalcServiceIp implements LoanService {

    private final LoanCalcRepository repo;

    public LoanCalcServiceIp(int idRequest) {
        repo = new VariableLoanCalcRepository(idRequest);
    }

    /**
     * loan calculation
     *
     * @param request
     * @return Response
     */
    @Override
    public LoanResponse calculationAndSaveRequest(LoanRequest request) {
        return new LoanResponse(ResponseType.DECLINED, repo.saveAndGenerateRequestId(request, ResponseType.DECLINED));
    }
}
