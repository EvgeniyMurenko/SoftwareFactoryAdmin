package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.StatusDaoImpl;
import com.SoftwareFactory.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 1/27/2017.
 */
@Service("statusService")
public class StatusServiceImpl implements AbstractService<Status> {

    private StatusDaoImpl statusDao;

    @Autowired(required=true)
    public StatusServiceImpl(StatusDaoImpl statusDao) {
        this.statusDao = statusDao;
    }

    @Override
    @Transactional
    public void addNew(Status object) {
        statusDao.create(object);
    }

    @Override
    @Transactional
    public void update(Status object) {
        statusDao.update(object);
    }

    @Override
    @Transactional
    public void delete(Status object) {
        statusDao.delete(object);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Status> getAll() {
        return statusDao.findAll();
    }
}
