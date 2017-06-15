package com.SoftwareFactoryAdmin.comparator;


import com.SoftwareFactoryAdmin.model.TaskMessage;

import java.util.Comparator;

public class TaskMessageByDateComparator implements Comparator<TaskMessage> {
    @Override
    public int compare(TaskMessage taskMessage1, TaskMessage taskMessage2) {
        return -1*(taskMessage1.getDate().compareTo(taskMessage2.getDate()));
    }
}
