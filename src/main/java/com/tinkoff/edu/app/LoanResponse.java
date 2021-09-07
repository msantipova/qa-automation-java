package com.tinkoff.edu.app;

import java.util.Objects;
import java.util.UUID;

/**
 * class Response
 */
public class LoanResponse {

    private final LoanRequest request;
    private ResponseType responseType;
    private final UUID requestId;


    public LoanResponse(ResponseType responseType, UUID requestId, LoanRequest request) {
        this.responseType = responseType;
        this.requestId = requestId;
        this.request = request;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public String getRequest() {
        return request.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanResponse that = (LoanResponse) o;
        return Objects.equals(request, that.request) &&
                responseType == that.responseType &&
                Objects.equals(requestId, that.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, responseType, requestId);
    }
}
