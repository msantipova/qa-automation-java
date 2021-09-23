package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.ArrayResponse;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.ResponseType;

import java.util.UUID;

/**
 * save request and status
 */
public class VariableLoanCalcRepository implements LoanCalcRepository {

    private int requestId;
    private ArrayResponse arrayResponse;//stores ID

    public VariableLoanCalcRepository(int requestId) {
        this.requestId=requestId;
    }

    /**
     * insert request in variable
     * @param request , status
     * @return requestId
     */
    @Override
    public UUID saveAndGenerateRequestId(LoanRequest request, ResponseType status) {
        //save request and status
        System.out.println(request.toString());
        return UUID.randomUUID();  //return ID
    }

}
