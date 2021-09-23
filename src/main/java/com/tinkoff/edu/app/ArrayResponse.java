package com.tinkoff.edu.app;

import java.util.UUID;


/**
 * array Responses
 */
public class ArrayResponse {

    private static final LoanResponse[] responses = new LoanResponse[10000];
    private static int counter;

    public static ResponseType getResponse(UUID id) {
        for (LoanResponse response : responses) {
            if (response.getRequestId().equals(id)) {
                return response.getResponseType();
            }
        }
       throw new RuntimeException("element not found");
    }

    public static void setResponse(LoanResponse response) {
        responses[counter++] = response;
    }


    public static void changeStatusResponse(UUID id, ResponseType status) {
        for (LoanResponse response : responses) {
            if (response.getRequestId().equals(id)) {
                response.setResponseType(status);
                break;
            }
        }
    }

    public static void toString(UUID id) {
        for (LoanResponse response : responses) {
            if (response.getRequestId().equals(id)) {
                System.out.printf("value: %s ; %s ; %s %n",
                        response.getRequestId(),
                        response.getResponseType(),
                        response.getRequest()
                );
                        break;
            }
        }
    }

}
