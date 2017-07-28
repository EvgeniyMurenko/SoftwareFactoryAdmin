package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.dao.TossTaskDao;
import com.SoftwareFactoryAdmin.model.TossTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("tossTaskService")
public class TossTaskServiceImpl implements TossTaskService {


    private TossTaskDao tossTaskDao;

    @Autowired
    public void setTossTaskDao(TossTaskDao tossTaskDao) {
        this.tossTaskDao = tossTaskDao;
    }

    @Override
    public void addNewTossTask(TossTask tossTask) {
        tossTaskDao.create(tossTask);
    }

    @Override
    public void updateTossTask(TossTask tossTask) {
        tossTaskDao.update(tossTask);
    }

    @Override
    public void deleteTossTask(TossTask tossTask) {
        tossTaskDao.delete(tossTask);
    }

    @Override
    public List<TossTask> getAllTossTasks() {
        return tossTaskDao.findAll();
    }

    @Override
    public TossTask getTossTaskById(Long id) {
        return tossTaskDao.read(id);
    }

    @Override
    public List<TossTask> findAllTossTasksBelongToManager(Long id) {
        return tossTaskDao.findTossTasksBelongToManager(id);
    }

}

