package com.tinkoff.edu.app;

public class LoanCalcRepository {

    private static int requestId;

    /**
     * TODO insert request
     *
     * @return requestId
     */
    public LoanResponse save(LoanRequest request) {
        if (request.getMonths() < 6)
            return new LoanResponse(ResponseType.APPROVED, ++requestId);
        else
            return new LoanResponse(ResponseType.DECLINED, ++requestId);
    }

}
