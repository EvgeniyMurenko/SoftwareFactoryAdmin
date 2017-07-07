package com.SoftwareFactoryAdmin.comparator;

import com.SoftwareFactoryAdmin.model.FxmPost;
import java.util.Comparator;
import java.util.Date;

public class FxmPostByDateComporator implements Comparator<FxmPost> {
    @Override
    public int compare(FxmPost fxmPost1, FxmPost fxmPost2) {
        Date date1 = fxmPost1.getDate();
        Date date2 = fxmPost2.getDate();
        return -date1.compareTo(date2);
    }
}
