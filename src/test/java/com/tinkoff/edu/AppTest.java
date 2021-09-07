package com.tinkoff.edu;

import com.tinkoff.edu.app.ArrayResponse;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.LoanType;
import com.tinkoff.edu.app.MyException.MyException;
import com.tinkoff.edu.app.ResponseType;
import com.tinkoff.edu.app.controller.LoanCalcController;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final LoanRequest request = new LoanRequest(LoanType.OOO, 10, 100000, "Легальный Легал Легалович");
    private UUID responseId;

    @Test
    public void shouldChangeStatus() {
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);
        ArrayResponse.changeStatusResponse(responseId, ResponseType.DECLINED);
        ArrayResponse.toString(responseId);
        assertEquals(ResponseType.DECLINED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetApprovedStatus() {
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);
        assertEquals(ResponseType.APPROVED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetDeclinedStatus() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.IP, 6, 100000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);
        //Then
        assertEquals(ResponseType.DECLINED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetPersonApprovedRequest() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.PERSON, 12, 10000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.APPROVED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetPersonApproved() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.PERSON, 9, 7000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.APPROVED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetPersonDeclinedRequest() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.PERSON, 6, 15000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.DECLINED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetPersonDeclinedRequestNotValidMonth() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.PERSON, 15, 10000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.DECLINED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetOOODeclinedRequest() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.OOO, 6, 5000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.DECLINED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetOOODeclinedRequestNotValidMonth() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.OOO, 12, 15000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.DECLINED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetOOOApprovedRequest() {
        //Given
        LoanRequest request = new LoanRequest(LoanType.OOO, 6, 15000, "Легальный Легал Легалович");

        //When
        responseId = new LoanCalcController().createRequest(request);
        ArrayResponse.toString(responseId);

        //Then
        assertEquals(ResponseType.APPROVED, ArrayResponse.getResponse(responseId));
    }

    @Test
    public void shouldGetRequestNull() {
        LoanRequest request = null;
        try {
            responseId = new LoanCalcController().createRequest(request);
        } catch (Throwable e) {
            assertAll(
                    () -> assertEquals(RuntimeException.class, e.getClass(), "неверный тип ошибки"),
                    () -> assertEquals("request is null", e.getMessage(), "не та ошибка")
            );
        }
    }

    @Test
    public void shouldGetMonthNull() {
        LoanRequest request = new LoanRequest(LoanType.OOO, 0, 15000, "Легальный Легал Легалович");
        try {
            responseId = new LoanCalcController().createRequest(request);
        } catch (Throwable e) {
            assertAll(
                    () -> assertEquals(RuntimeException.class, e.getClass(), "неверный тип ошибки"),
                    () -> assertEquals("Invalid Months", e.getMessage(), "не та ошибка")
            );
        }
    }

    @Test
    public void shouldGetBigMonth() {
        LoanRequest request = new LoanRequest(LoanType.OOO, 101, 15000, "Легальный Легал Легалович");
        try {
            responseId = new LoanCalcController().createRequest(request);
        } catch (Throwable e) {
            assertAll(
                    () -> assertEquals(MyException.class, e.getClass(), "неверный тип ошибки"),
                    () -> assertEquals("Срок более 100 месяцев", e.toString(), "не та ошибка")
            );
        }
    }

    @Test
    public void shouldGetAmountNull() {
        LoanRequest request = new LoanRequest(LoanType.OOO, 12, 0, "Легальный Легал Легалович");
        try {
            responseId = new LoanCalcController().createRequest(request);
        } catch (Throwable e) {
            assertAll(
                    () -> assertEquals(RuntimeException.class, e.getClass(), "неверный тип ошибки"),
                    () -> assertEquals("amount is null", e.getMessage(), "не та ошибка")
            );
        }
    }

}
