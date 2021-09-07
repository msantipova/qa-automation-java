package com.tinkoff.edu.app.controller;

import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.MyException.MyException;
import com.tinkoff.edu.app.repository.LoanCalcRepository;
import com.tinkoff.edu.app.repository.UuidLoanCalcRepository;
import com.tinkoff.edu.app.service.LoanCalcService;

import java.util.UUID;

/**
 * class validates request
 */
public class LoanCalcController {

    private final LoanCalcRepository repo = new UuidLoanCalcRepository();

    /**
     * Validates and logs request
     *
     * @param request
     * @return Response
     */
    public UUID createRequest(LoanRequest request) {

        if (request == null) {
            throw new RuntimeException("request is null");
        } else if (request.getMonths() <= 0) {
            throw new RuntimeException("Invalid Months");
        } else if (request.getType() == null) {
            throw new RuntimeException("type is null");
        } else if (request.getAmount() <= 0) {
            throw new RuntimeException("amount is null");
        }
            try {
                return new LoanCalcService(repo).calculationAndSaveRequest(request);
            }
            catch (MyException e){
                throw new MyException(e.toString());
            }
    }

}
