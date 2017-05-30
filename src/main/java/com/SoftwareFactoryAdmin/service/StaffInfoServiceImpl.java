package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.StaffInfoDao;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.StaffHistory;
import com.SoftwareFactoryAdmin.model.StaffInfo;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.util.AppMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Service("staffInfoService")
public class StaffInfoServiceImpl implements StaffInfoService {

    private StaffInfoDao staffInfoDao;

    @Autowired(required = true)
    public void setStaffInfoDao(StaffInfoDao staffInfoDao) {
        this.staffInfoDao = staffInfoDao;
    }


    @Override
    public void addNewStaffInfo(StaffInfo staffInfo) {
        staffInfoDao.create(staffInfo);
    }

    @Override
    public void updateStaffInfo(StaffInfo staffInfo) {
        staffInfoDao.update(staffInfo);
    }

    @Override
    public void deleteStaffInfo(StaffInfo staffInfo) {
        staffInfoDao.delete(staffInfo);
    }

    @Override
    public List<StaffInfo> getAllStaffInfos() {
        return staffInfoDao.findAll();
    }

    @Override
    public StaffInfo getStaffInfoById(Long id) {
        return staffInfoDao.read(id);
    }

    @Override
    public void updateStaffInfoWithParameters(Long id, User user, ManagerInfo managerInfo, String password,
                                              String name, String phone, String email, String birthDate,
                                              int android, int iOs, int iot, int java, int php, int javascript, int cSharp,
                                              int cPlusPlus, int frontend, int design) {

        StringBuilder historyChanges = new StringBuilder();
        historyChanges.append("Staff update : <br><br>");


        StaffInfo staffInfo = staffInfoDao.read(id);

        if (!staffInfo.getName().equals(name)) {
            historyChanges.append("name changed from - " + staffInfo.getName() + " to  " + name + "<br>");
            staffInfo.setName(name);
        }
        if (!user.getPassword().equals(password)) {
            user.setPassword(password);
            staffInfo.setUser(user);
        }
        if (!staffInfo.getPhone().equals(phone)) {
            historyChanges.append("phone changed from - " + staffInfo.getPhone() + " to  " + phone + "<br>");
            staffInfo.setPhone(phone);
        }
        if (!staffInfo.getEmail().equals(email)) {
            historyChanges.append("email changed from - " + staffInfo.getEmail() + " to  " + email + "<br>");
            staffInfo.setEmail(email);
        }
        SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (!dateFormatShow.format(staffInfo.getBirthDate()).equals(birthDate)) {
            historyChanges.append("birth date changed from - " + staffInfo.getBirthDate() + " to  " + birthDate + "<br>");
            staffInfo.setBirthDate(AppMethods.getDateFromString(birthDate));
        }
        if (staffInfo.getAndroid() != android) {
            historyChanges.append("android level changed from - " + staffInfo.getAndroid() + " to  " + android + "<br>");
            staffInfo.setAndroid(android);
        }
        if (staffInfo.getiOs() != iOs) {
            historyChanges.append("iOS level changed from - " + staffInfo.getiOs() + " to  " + iOs + "<br>");
            staffInfo.setiOs(iOs);
        }
        if (staffInfo.getIot() != iot) {
            historyChanges.append("IOT level changed from - " + staffInfo.getIot() + " to  " + iot + "<br>");
            staffInfo.setIot(iot);
        }
        if (staffInfo.getJava() != java) {
            historyChanges.append("java level changed from - " + staffInfo.getJava() + " to  " + java + "<br>");
            staffInfo.setJava(java);
        }
        if (staffInfo.getPhp() != php) {
            historyChanges.append("php level changed from - " + staffInfo.getPhp() + " to  " + php + "<br>");
            staffInfo.setPhp(php);
        }
        if (staffInfo.getJavascript() != javascript) {
            historyChanges.append("javascript level changed from - " + staffInfo.getJavascript() + " to  " + javascript + "<br>");
            staffInfo.setJavascript(javascript);
        }
        if (staffInfo.getcSharp() != cSharp) {
            historyChanges.append("c# level changed from - " + staffInfo.getcSharp() + " to  " + cSharp + "<br>");
            staffInfo.setcSharp(cSharp);
        }
        if (staffInfo.getcPlusPlus() != cPlusPlus) {
            historyChanges.append("c++ level changed from - " + staffInfo.getcPlusPlus() + " to  " + cPlusPlus + "<br>");
            staffInfo.setcPlusPlus(cPlusPlus);
        }
        if (staffInfo.getFrontend() != frontend) {
            historyChanges.append("frontend (HTML - CSS) level changed from - " + staffInfo.getFrontend() + " to  " + frontend + "<br>");
            staffInfo.setFrontend(frontend);
        }
        if (staffInfo.getDesign() != design) {
            historyChanges.append("design level changed from - " + staffInfo.getDesign() + " to  " + design + "<br>");
            staffInfo.setDesign(design);
        }

        List<StaffHistory> staffHistories = staffInfo.getStaffHistories();
        staffHistories.add(new StaffHistory(historyChanges.toString(), new Date(), staffInfo, managerInfo.getName(), managerInfo.getId()));

        staffInfoDao.update(staffInfo);
    }

}

