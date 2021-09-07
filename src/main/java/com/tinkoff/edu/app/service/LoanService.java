package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.MyException.MyException;

import java.util.UUID;

public interface LoanService {

    UUID calculationAndSaveRequest(LoanRequest request) throws MyException;

}
