package com.SoftwareFactoryAdmin.comparator;


import com.SoftwareFactoryAdmin.model.Estimate;

import java.util.Comparator;
import java.util.Date;

public class EstimateByDateComparator implements Comparator<Estimate> {

    @Override
    public int compare(Estimate estimate1, Estimate estimate2) {
        Date date1 = estimate1.getDateRequest();
        Date date2 = estimate2.getDateRequest();
        return -date1.compareTo(date2);
    }
}