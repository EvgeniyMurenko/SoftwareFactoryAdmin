package com.SoftwareFactoryAdmin.constant;


public enum  GlobalEnum {
    /*webRoot ("http://a.sofac.kr");*/
   /* webRoot ("http://localhost:8080");*/
    webRoot("http://52.57.116.160:8080");

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
