package com.SoftwareFactoryAdmin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AppMethods {


    public static Date getDateFromString(String stringDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter.parse(stringDate + ":00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String changeNull(String value){
        if (!"".equals(value) && value!=null){
            return value;
        }
        return "-";
    }

    public static String isChecked(Boolean value){
        if (value) return "checked";
        else return "";
    }
}
