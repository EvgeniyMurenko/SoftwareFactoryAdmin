package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.StaffInfo;
import java.util.List;


public interface StaffInfoDao {
    Long create(StaffInfo staffInfo);
    StaffInfo read(Long id);
    void update(StaffInfo staffInfo);
    void delete(StaffInfo staffInfo);
    List<StaffInfo> findAll();
    void deleteAllByStaff(Long staffId);
}
