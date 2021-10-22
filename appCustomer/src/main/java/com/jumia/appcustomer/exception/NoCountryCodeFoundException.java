package com.jumia.appcustomer.exception;

public class NoCountryCodeFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoCountryCodeFoundException(String message) {
        super(message);
    }

}
