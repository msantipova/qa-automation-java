package com.tinkoff.edu.app;

/**
 * class Response
 */
public class LoanResponse {
    private final ResponseType responseType;
    private final int requestId;

    public LoanResponse(ResponseType responseType, int requestId) {
        this.responseType = responseType;
        this.requestId = requestId;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public int getRequestId() {
        return requestId;
    }

}
