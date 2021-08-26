package com.tinkoff.edu.app;

public interface LoanCalcRepository {

    int saveAndGenerateRequestId(LoanRequest request, ResponseType status);

}
