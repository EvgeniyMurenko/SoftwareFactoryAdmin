package com.SoftwareFactoryAdmin.constant;


public enum  GlobalEnum {
    webRoot ("http://a.sofac.kr"),
   /* webRoot ("http://localhost:8080");*/
    /*webRoot("http://52.211.242.225:8080");*/
    googleApiKey("AIzaSyDZJmgv9fvQnQkc5vvCx8bPFcUqSYDVhnM");

    private String value;

    GlobalEnum(final String value) {
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
