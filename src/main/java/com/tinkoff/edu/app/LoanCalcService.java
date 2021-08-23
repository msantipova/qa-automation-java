package com.tinkoff.edu.app;

public class LoanCalcService {

    LoanCalcRepository loanCalcRepository = new LoanCalcRepository();

    /**
     * TODO loan calculation
     * @return Response
     */
    public LoanResponse createRequest(LoanRequest request) {
       return loanCalcRepository.save(request);
    }

}
