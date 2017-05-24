package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.StaffHistory;
import com.SoftwareFactoryAdmin.model.StaffInfo;
import com.SoftwareFactoryAdmin.model.User;


import java.util.Date;
import java.util.List;


public interface StaffInfoService {

    void addNewStaffInfo(StaffInfo staffInfo);

    void updateStaffInfo(StaffInfo staffInfo);

    void deleteStaffInfo(StaffInfo staffInfo);

    List<StaffInfo> getAllStaffInfos();

    StaffInfo getStaffInfoById(Long id);

    void updateStaffInfoWithParameters(Long id, User user, ManagerInfo managerInfo ,String password,String name, String phone, String email, String birthDate, int rating, int android, int iOs, int java, int php, int javascript, int cSharp, int cPlusPlus, int frontend, int design);

}
