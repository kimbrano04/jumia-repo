package com.jumia.appcustomer.constants;

public enum State {
    VALID("VALID"), NO_VALID("NO_VALID");

    private final String value;

    private State(String _value) {
        this.value = _value;
    }

    public String getValue() {
        return value;
    }
}
