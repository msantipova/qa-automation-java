package com.tinkoff.edu.app;

public class LoanCalcServiceIP implements LoanService {
    private LoanCalcRepository repo;

    public LoanCalcServiceIP(LoanCalcRepository repository) {
        repo = repository;
    }

    public LoanCalcServiceIP() {
        repo = new StaticVariableLoanCalcRepository();
    }

    /**
     * TODO loan calculation
     *
     * @return Response
     */
    @Override
    public LoanResponse calculationAndSaveRequest(LoanRequest request) {
            return new LoanResponse(ResponseType.DECLINED, repo.saveAndGenerateRequestId(request, ResponseType.DECLINED));
    }
}
