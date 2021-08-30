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

    private LoanRequest request = new LoanRequest(LoanType.OOO, 5, 1000);
    private LoanResponse response;

    @Test
    public void shouldGetId1WhenFirstCall() {
        response = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository())).createRequest(request);

        assertEquals(1, response.getRequestId());
    }

    @Test
    public void shouldGetApprovedStatus() {
        response = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository())).createRequest(request);

        assertEquals(ResponseType.APPROVED, response.getResponseType());
    }

    @Test
    public void shouldGetDeclinedStatus() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.IP, 10, 100000);

        //When
        response = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository())).createRequest(request);

        //Then
        assertEquals(ResponseType.DECLINED, response.getResponseType());
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall(){
        LoanRequest request = new LoanRequest(null, 0, 0);
        System.out.println(request.toString());
        assertEquals(-1, new LoanCalcController().createRequest(request).getRequestId());
  //      assertEquals(6, new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository(5))).createRequest(request).getRequestId());
    }

    @Test
    public void should1(){
        response = new LoanCalcController().createRequest(request);
        System.out.println(response.getResponseType());
        assertEquals(1, response.getRequestId());
    }

}
