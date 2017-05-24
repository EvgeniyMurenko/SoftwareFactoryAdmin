package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.StaffHistory;


import java.util.List;

public interface StaffHistoryDao {

    Long create(StaffHistory staffHistory);

    StaffHistory read(Long id);

    void update(StaffHistory staffHistory);

    void delete(StaffHistory staffHistory);

    List<StaffHistory> findAll();

}
