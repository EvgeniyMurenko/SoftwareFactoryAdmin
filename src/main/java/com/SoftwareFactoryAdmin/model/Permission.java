package com.SoftwareFactoryAdmin.model;

import java.io.Serializable;


public enum  Permission implements Serializable {

    PERMISSION("PERMISSION"),
    CASE_PERMISSION("CASE_PERMISSION"),
    CUSTOMER_INFO_PERMISSION("CUSTOMER_INFO_PERMISSION");


    String permission;

    private Permission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
