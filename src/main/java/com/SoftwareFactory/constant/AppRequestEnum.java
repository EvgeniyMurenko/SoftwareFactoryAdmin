package com.SoftwareFactory.constant;


public enum AppRequestEnum {

    AUTHORIZATION_REQUEST("AUTHORIZATION_REQUEST");

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
