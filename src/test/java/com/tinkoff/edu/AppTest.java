package com.tinkoff.edu;

import com.tinkoff.edu.app.LoanCalcController;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.LoanResponse;
import com.tinkoff.edu.app.LoanType;
import com.tinkoff.edu.app.ResponseType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final LoanRequest request = new LoanRequest(LoanType.OOO, 10, 100000);
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
        LoanRequest request = new LoanRequest(LoanType.IP, 6, 100000);

        //When
        response = new LoanCalcController(5).createRequest(request);

        //Then
        assertEquals(ResponseType.DECLINED, response.getResponseType());
    }

    @Test
    public void shouldGetErrorWhenApplyNullRequest () {
        //Given
        LoanRequest request = null;

        //When
        response = new LoanCalcController().createRequest(request);

        //Then
        assertEquals(-1, response.getRequestId());
    }

    @Test
    public void shouldGetErrorWhenApplyZeroOrNegativeAmountRequest () {
        //Given
        LoanRequest request = new LoanRequest(LoanType.OOO, 10, 0);

        //When
        response = new LoanCalcController().createRequest(request);

        //Then
        assertEquals(-1, response.getRequestId());
    }

    @Test
    public void shouldGetErrorWhenApplyZeroOrNagativeMonthsRequest  () {
        //Given
        LoanRequest request = new LoanRequest(LoanType.OOO, 0, 100000);

        //When
        response = new LoanCalcController().createRequest(request);

        //Then
        assertEquals(-1, response.getRequestId());
    }

    @Test
    public void shouldGetPersonApprovedRequest  () {
        //Given
        LoanRequest request = new LoanRequest(LoanType.PERSON, 6, 5000);

        //When
        response = new LoanCalcController(8).createRequest(request);

        //Then
        assertEquals(ResponseType.APPROVED, response.getResponseType());
    }

    @Test
    public void shouldGetPersonDeclinedRequest  () {
        //Given
        LoanRequest request = new LoanRequest(LoanType.PERSON, 6, 15000);

        //When
        response = new LoanCalcController().createRequest(request);

        //Then
        assertEquals(ResponseType.DECLINED, response.getResponseType());
    }

    @Test
    public void shouldGetOOODeclinedRequest  () {
        //Given
        LoanRequest request = new LoanRequest(LoanType.OOO, 6, 5000);

        //When
        response = new LoanCalcController(6).createRequest(request);

        //Then
        assertEquals(ResponseType.DECLINED, response.getResponseType());
    }

}
