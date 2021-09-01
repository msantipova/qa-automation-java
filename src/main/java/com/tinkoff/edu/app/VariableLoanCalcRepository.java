package com.tinkoff.edu.app;

/**
 * save request and status
 */
public class VariableLoanCalcRepository implements LoanCalcRepository {

    private int requestId;  //stores ID

    public VariableLoanCalcRepository(int requestId) {
        this.requestId=requestId;
    }

    /**
     * insert request in variable
     * @param request
     * @return requestId
     */
    @Override
    public int saveAndGenerateRequestId(LoanRequest request, ResponseType status) {
        //save request and status
        System.out.println(request.toString());
        return ++requestId;  //return ID
    }

}
