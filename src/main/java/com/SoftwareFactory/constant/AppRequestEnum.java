package com.SoftwareFactory.constant;


public enum AppRequestEnum {

    AUTHORIZATION_REQUEST("AUTHORIZATION_REQUEST"),
    REQUEST_SUCCESS("REQUEST_SUCCESS"),
    REQUEST_FAIL("REQUEST_FAIL");

    private String value;

    AppRequestEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}