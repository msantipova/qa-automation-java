package com.tinkoff.edu.app;

public class LoanCalcServiceOOO implements LoanService {
    private LoanCalcRepository repo;

    public LoanCalcServiceOOO(LoanCalcRepository repository) {
        repo = repository;
    }

    public LoanCalcServiceOOO() {
        repo = new StaticVariableLoanCalcRepository();
    }

    /**
     * TODO loan calculation
     *
     * @return Response
     */
    @Override
    public LoanResponse calculationAndSaveRequest(LoanRequest request) {
        if (!(request.getAmount() <= 10000) & (request.getMonths() <= 12))
            return new LoanResponse(ResponseType.APPROVED, repo.saveAndGenerateRequestId(request, ResponseType.APPROVED));
        else
            return new LoanResponse(ResponseType.DECLINED, repo.saveAndGenerateRequestId(request, ResponseType.DECLINED));
    }

}
