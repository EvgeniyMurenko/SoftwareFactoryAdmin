package com.SoftwareFactory.service;

import com.SoftwareFactory.model.StaffInfo;

import java.util.List;


public interface StaffInfoService {
    void addStaffInfo(StaffInfo staffInfo);
    void updateStaffInfo(StaffInfo staffInfo);
    void deleteStaffInfo(StaffInfo staffInfo);
    List<StaffInfo> getAllStaffInfo();
    StaffInfo getStaffInfo(Long id);
}
