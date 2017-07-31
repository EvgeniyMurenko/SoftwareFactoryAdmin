package com.SoftwareFactoryAdmin.comparator;



import com.SoftwareFactoryAdmin.model.TossTaskMessage;

import java.util.Comparator;

public class TossTaskMessagesByDateComparator implements Comparator<TossTaskMessage> {
    @Override
    public int compare(TossTaskMessage tossTaskMessage1, TossTaskMessage tossTaskMessage2) {
        return -1*(tossTaskMessage1.getDate().compareTo(tossTaskMessage2.getDate()));
    }
}