package com.SoftwareFactoryAdmin.comparator;

import com.SoftwareFactoryAdmin.model.Case;
import java.util.Comparator;
import java.util.Date;

public class CaseByDateComporator implements Comparator<Case> {
    @Override
    public int compare(Case aCase1, Case aCase2) {
        Date date1 = aCase1.getCreationDate();
        Date date2 = aCase2.getCreationDate();
        return -date1.compareTo(date2);
    }
}
