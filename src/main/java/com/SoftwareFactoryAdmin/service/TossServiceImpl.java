package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.dao.TossDao;
import com.SoftwareFactoryAdmin.model.Toss;
import com.SoftwareFactoryAdmin.model.TossTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("tossService")
public class TossServiceImpl implements TossService {


    private TossDao tossDao;

    @Autowired
    public void setTossDao(TossDao tossDao) {
        this.tossDao = tossDao;
    }

    @Override
    public void addNewToss(Toss toss) {
        tossDao.create(toss);
    }

    @Override
    public void updateToss(Toss toss) {
        tossDao.update(toss);
    }

    @Override
    public void deleteToss(Toss toss) {
        tossDao.delete(toss);
    }

    @Override
    public List<Toss> getAllToss() {
        return tossDao.findAll();
    }

    @Override
    public Toss getTossById(Long id) {
        return tossDao.read(id);
    }

    @Override
    public List<Toss> findAllTossBelongToManager(Long id) {
        return tossDao.findTossBelongToManager(id);
    }

    @Override
    public List<Toss> findAllTossBelongToManagerByStatus(Long id, String status) {
        return tossDao.findTossBelongToManagerByStatus(id, status);
    }

}

