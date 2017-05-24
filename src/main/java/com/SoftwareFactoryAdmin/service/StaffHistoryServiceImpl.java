package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.StaffHistoryDao;
import com.SoftwareFactoryAdmin.model.StaffHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("staffHistoryService")
public class StaffHistoryServiceImpl implements StaffHistoryService {

    private StaffHistoryDao staffHistoryDao;

    @Autowired(required = true)
    public void setStaffHistoryDao(StaffHistoryDao staffHistoryDao) {
        this.staffHistoryDao = staffHistoryDao;
    }


    @Override
    public void addNewStaffHistory(StaffHistory staffHistory) {
        staffHistoryDao.create(staffHistory);
    }

    @Override
    public void updateStaffHistory(StaffHistory staffHistory) {
        staffHistoryDao.update(staffHistory);
    }

    @Override
    public void deleteStaffInfo(StaffHistory staffHistory) {
        staffHistoryDao.delete(staffHistory);
    }

    @Override
    public List<StaffHistory> getAllStaffHistorys() {
        return staffHistoryDao.findAll();
    }

    @Override
    public StaffHistory getStaffHistoryById(Long id) {
        return staffHistoryDao.read(id);
    }


}

