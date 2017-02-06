package com.SoftwareFactory.comparator;

import com.SoftwareFactory.model.Message;

import java.sql.Date;
import java.util.Comparator;


public class MessageComparator implements Comparator<Message> {

    @Override
    public int compare(Message message1, Message message2) {
        Date messageDate1 = message1.getMessageTime();
        Date messageDate2 = message2.getMessageTime();


        return messageDate1.compareTo(messageDate2);
    }
}