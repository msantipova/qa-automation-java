package com.tinkoff.edu.app;

public class LoanCalcService implements LoanService {

    private LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repository) {
        repo = repository;
    }

    /**
     * TODO loan calculation
     *
     * @return Response
     */
    @Override
    public LoanResponse createRequest(LoanRequest request) {
        if (request.getMonths() <= 6)
            return new LoanResponse(ResponseType.APPROVED, repo.save(request, ResponseType.APPROVED));
        else
            return new LoanResponse(ResponseType.DECLINED, repo.save(request, ResponseType.DECLINED));
    }

}
