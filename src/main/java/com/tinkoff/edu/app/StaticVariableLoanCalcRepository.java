package com.tinkoff.edu.app;

public class StaticVariableLoanCalcRepository implements LoanCalcRepository {

    private static int requestId;  //stores ID

    /**
     * TODO insert request
     *
     * @return requestId
     */
    @Override
    public int save(LoanRequest request, ResponseType status) {
        //save request and status
        return ++requestId;  //return ID
    }

}
