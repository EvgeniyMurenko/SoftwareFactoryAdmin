package com.SoftwareFactoryAdmin.util;

import com.SoftwareFactoryAdmin.constant.GlobalEnum;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

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

    public static String translate (String sourceText , String targetLanguage){

        TranslateOptions options = TranslateOptions.newBuilder().setApiKey(GlobalEnum.googleApiKey.getValue())
                .build();

        Translate translate = options.getService();
        Translation translation =
                translate.translate(sourceText,
                        Translate.TranslateOption.targetLanguage(targetLanguage));


        return translation.getTranslatedText();
    }
}
