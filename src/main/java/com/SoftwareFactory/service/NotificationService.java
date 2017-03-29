package com.SoftwareFactory.service;

import com.google.android.gcm.server.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Service
public class NotificationService {

    /**
     * keys is the id which android app will give to server (one time)
     **/

    public boolean pushNotificationToGCM(List<String> keys, String message , String title){

        final String GCM_API_KEY = "AIzaSyBl0L2Oa9s8atAAe2f0n-ipOl0HDkzf-hk";
        final int retries = 3;
        Sender sender = new Sender(GCM_API_KEY);

        Message msg = new Message.Builder().collapseKey("gcm_message").delayWhileIdle(true).addData("message",message).addData("title" , title).build();

        try {

            MulticastResult result = sender.send(msg, keys, retries);

            System.out.println("GCM Notification is sent successfully" + result.toString());

        } catch (InvalidRequestException e) {
            System.out.println("Invalid Request");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return false;

    }
}