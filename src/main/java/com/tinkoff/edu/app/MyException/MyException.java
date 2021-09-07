package com.tinkoff.edu.app.MyException;

public class MyException extends RuntimeException {
    String message;

    public MyException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
