package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.ResponseType;

import java.util.UUID;

public interface LoanCalcRepository {

    UUID saveAndGenerateRequestId(LoanRequest request, ResponseType status);

}
