package com.SoftwareFactoryAdmin.constant;


public enum AppRequestEnum {

    AUTHORIZATION_REQUEST("AUTHORIZATION_REQUEST"),
    REQUEST_SUCCESS("REQUEST_SUCCESS"),
    REQUEST_FAIL("REQUEST_FAIL"),
    GET_STAFF_INFO_REQUEST("GET_STAFF_INFO_REQUEST"),
    LOAD_ALL_CASES_REQUEST("LOAD_ALL_CASES_REQUEST"),
    SET_READ_MESSAGE_TASK_REQUEST("SET_READ_MESSAGE_TASK_REQUEST"),

    //Group request

    LOAD_ALL_POSTS_REQUEST("LOAD_ALL_POSTS_REQUEST"),
    LOAD_COMMENTS_REQUEST("LOAD_COMMENTS_REQUEST"),
    WRITE_POST_REQUEST("WRITE_POST_REQUEST"),
    WRITE_COMMENT_REQUEST("WRITE_COMMENT_REQUEST"),
    DELETE_POST_REQUEST("DELETE_POST_REQUEST"),
    DELETE_COMMENT_REQUEST("DELETE_COMMENT_REQUEST"),
    UPDATE_POST_REQUEST("UPDATE_POST_REQUEST"),
    UPDATE_COMMENT_REQUEST("UPDATE_COMMENT_REQUEST");


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
