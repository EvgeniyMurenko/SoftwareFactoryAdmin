package com.SoftwareFactoryAdmin.service;

import org.springframework.transaction.annotation.Transactional;
import com.SoftwareFactoryAdmin.dao.ManagerInfoDao;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service("managerInfoService")
public class ManagerInfoServiceImpl implements ManagerInfoService {


    private ManagerInfoDao managerInfoDao;

    @Autowired(required = true)
    public void setManagerInfoDao(ManagerInfoDao managerInfoDao) {
        this.managerInfoDao = managerInfoDao;
    }

    @Override
    public void addNewManagerInfo(ManagerInfo managerInfo) {
        managerInfoDao.create(managerInfo);
    }

    @Override
    public List<ManagerInfo> getAllManagerInfos() {
        return managerInfoDao.findAll();
    }

    @Override
    public ManagerInfo getManagerInfoById(Long id) {
        return managerInfoDao.read(id);
    }

    @Override
    public void updateManagerInfo(ManagerInfo managerInfo) {
        managerInfoDao.update(managerInfo);
    }

    @Override
    public void deleteManagerInfo(ManagerInfo managerInfo) {
        managerInfoDao.delete(managerInfo);
    }


    @Override
    public List<ManagerInfo> getAllWithPermission() {
        return managerInfoDao.findAllWithPermissions();
    }

    @Override
    public Set<ManagerInfo> findMultiplyManagerInfoById(List<String> ids) {
        List<Long> longIds = new ArrayList<>();
        for (String id : ids) {
            longIds.add(Long.valueOf(id));
        }
        List<ManagerInfo> managerInfos = managerInfoDao.findMultiManagerInfoById(longIds);

        return managerInfos.stream().collect(Collectors.toSet());

    }

    @Override
    public List<ManagerInfo> getAllManagerInfosExceptOneManager(Long id) {
        return managerInfoDao.getAllManagerInfosExceptOneManager(id);
    }

}
