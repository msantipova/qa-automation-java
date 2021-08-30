package com.tinkoff.edu;

import com.tinkoff.edu.app.LoanCalcController;
import com.tinkoff.edu.app.LoanCalcService;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.LoanResponse;
import com.tinkoff.edu.app.LoanType;
import com.tinkoff.edu.app.ResponseType;
import com.tinkoff.edu.app.StaticVariableLoanCalcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final LoanRequest request = new LoanRequest(LoanType.IP, 5, 100000);;
    private LoanResponse response;

    @Test
    public void shouldGetId1WhenFirstCall() {
        response = new LoanCalcController().createRequest(request);

        assertEquals(1, response.getRequestId());
    }

    @Test
    public void shouldGetApprovedStatus() {
        response = new LoanCalcController().createRequest(request);

        assertEquals(ResponseType.APPROVED, response.getResponseType());
    }

    @Test
    public void shouldGetDeclinedStatus() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.IP, 10, 100000);

        //When
        response = new LoanCalcController().createRequest(request);

        //Then
        assertEquals(ResponseType.DECLINED, response.getResponseType());
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall(){
        assertEquals(6, new LoanCalcController(5).createRequest(request).getRequestId());
    }

}
