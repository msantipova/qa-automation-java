package com.tinkoff.edu.app;

import java.util.UUID;

/**
 * array Responses
 */
public class ArrayResponse {

    private static final LoanResponse[] responses = new LoanResponse[10000];
    private static int counter;

    public static ResponseType getResponse(UUID id) {
        int counter;
        for (counter = 0; counter < responses.length; counter++) {
            if (responses[counter].getRequestId().equals(id)) {
                break;
            }
        }
        return responses[counter].getResponseType();
    }

    public static void setResponse(LoanResponse response) {
        responses[counter++] = response;
    }


    public static void changeStatusResponse(UUID id, ResponseType status) {
        int counter;
        for (counter = 0; counter < responses.length; counter++) {
            if (responses[counter].getRequestId().equals(id)) {
                responses[counter].setResponseType(status);
                break;
            }
        }
    }

    public static void toString(UUID id) {
        int counter;
        for (counter = 0; counter < responses.length; counter++) {
            if (responses[counter].getRequestId().equals(id)) {
                break;
            }
        }
        System.out.println( "ArrayResponse {" + responses[counter].getRequestId()
                    + ", " + responses[counter].getResponseType() + "} " +
                     responses[counter].getRequest());
    }

}
