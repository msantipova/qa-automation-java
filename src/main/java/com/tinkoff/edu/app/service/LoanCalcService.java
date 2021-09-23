package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.MyException.MyException;
import com.tinkoff.edu.app.ResponseType;
import com.tinkoff.edu.app.repository.LoanCalcRepository;

import java.util.UUID;

/**
 * class for calculation request from IP
 */
public class LoanCalcService implements LoanService {

    private final LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * loan calculation
     *
     * @param request
     * @return Response
     */
    @Override
    public UUID calculationAndSaveRequest(LoanRequest request) throws MyException {

        ResponseType status = null;

        if ((request.getMonths() > 100)) {
            throw new MyException("Срок более 100 месяцев");
        } else
            switch (request.getType()) {
                case IP: {
                    status = ResponseType.DECLINED;
                    break;
                }
                case OOO: {
                    if ((request.getAmount() > 10000) && (request.getMonths() < 12))
                        status = ResponseType.APPROVED;
                    else
                        status = ResponseType.DECLINED;
                    break;
                }
                case PERSON: {
                    if ((request.getMonths() <= 12) && (request.getAmount() <= 10000))
                        status = ResponseType.APPROVED;
                    else
                        status = ResponseType.DECLINED;
                    break;
                }
            }

        return repo.saveAndGenerateRequestId(request, status);
    }
}
