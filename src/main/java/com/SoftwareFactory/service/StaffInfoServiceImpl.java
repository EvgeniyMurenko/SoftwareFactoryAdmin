package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.StaffInfoDao;
import com.SoftwareFactory.model.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("staffInfoService")
public class StaffInfoServiceImpl implements StaffInfoService {

    private StaffInfoDao staffInfoDao;

    @Autowired(required = true)
    public void setStaffInfoDao(StaffInfoDao staffInfoDao) {
        this.staffInfoDao = staffInfoDao;
    }

    @Override
    @Transactional
    public void addStaffInfo(StaffInfo staffInfo) {
        staffInfoDao.create(staffInfo);
    }

    @Override
    @Transactional
    public void updateStaffInfo(StaffInfo staffInfo) {
        staffInfoDao.update(staffInfo);
    }

    @Override
    @Transactional
    public void deleteStaffInfo(StaffInfo staffInfo) {
        staffInfoDao.delete(staffInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StaffInfo> getAllStaffInfo() {
        return staffInfoDao.findAll();
    }

    @Override
    @Transactional
    public StaffInfo getStaffInfo(Long id) {
        return staffInfoDao.read(id);
    }
}
