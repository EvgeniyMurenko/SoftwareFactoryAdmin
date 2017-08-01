package com.SoftwareFactoryAdmin.comparator;

import com.SoftwareFactoryAdmin.model.TossTask;


import java.util.Comparator;


public class TossTaskByDateComparator implements Comparator<TossTask> {
    @Override
    public int compare(TossTask tossTask1, TossTask tossTask2) {
        return -1*(tossTask1.getDate().compareTo(tossTask2.getDate()));
    }
}
