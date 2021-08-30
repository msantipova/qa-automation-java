package com.tinkoff.edu.app;

public class StaticVariableLoanCalcRepository implements LoanCalcRepository {

    private int requestId;  //stores ID

    public StaticVariableLoanCalcRepository(int requestId) {
        this.requestId=requestId;
    }


    public StaticVariableLoanCalcRepository() {
        this.requestId=0;
    }
    /**
     * TODO insert request
     *
     * @return requestId
     */
    @Override
    public int saveAndGenerateRequestId(LoanRequest request, ResponseType status) {
        //save request and status
        return ++requestId;  //return ID
    }

}
