package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.ArrayResponse;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.LoanResponse;
import com.tinkoff.edu.app.ResponseType;

import java.util.UUID;

/**
 * save request and status
 */
public class UuidLoanCalcRepository implements LoanCalcRepository {

    private int requestId;
    private UUID id; //stores ID

    public UuidLoanCalcRepository() {

    }

    /**
     * insert request in variable
     * @param request , status
     * @return requestId
     */
    @Override
    public UUID saveAndGenerateRequestId(LoanRequest request, ResponseType status) {
        //save request and status
        id = UUID.randomUUID();
        ArrayResponse.setResponse(new LoanResponse(status, id, request));
        return id; //return ID
    }

}
