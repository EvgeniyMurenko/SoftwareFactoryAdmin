package com.SoftwareFactoryAdmin.comparator;

import com.SoftwareFactoryAdmin.model.Case;
import com.SoftwareFactoryAdmin.model.Message;

import java.util.*;

public class CaseByDateComporator implements Comparator<Case> {
    @Override
    public int compare(Case aCase1, Case aCase2) {
        Date date1 = getLastMessageDate(aCase1);
        Date date2 = getLastMessageDate(aCase2);
        return -Long.compare(date1.getTime(), date2.getTime());
    }

    private Date getLastMessageDate(Case aCase){
        List<Message> messageList = new ArrayList<>(aCase.getMessages());
        Collections.sort(messageList, new MessageByDateComparator());
        Date date = messageList.get(messageList.size()-1).getMessageTime();
        return date;

    }
}
