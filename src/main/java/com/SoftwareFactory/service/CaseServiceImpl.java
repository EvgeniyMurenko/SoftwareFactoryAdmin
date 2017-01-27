package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.CaseDaoImpl;
import com.SoftwareFactory.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 1/27/2017.
 */
@Service("caseService")
public class CaseServiceImpl implements AbstractService<Case> {

    private CaseDaoImpl caseDaoIml;

    @Autowired(required=true)
    public CaseServiceImpl(CaseDaoImpl caseDaoImpl){
        this.caseDaoIml = caseDaoImpl;
    }

    @Override
    @Transactional
    public void addNew(Case object) {
        caseDaoIml.create(object);
    }

    @Override
    @Transactional
    public void update(Case object) {
        caseDaoIml.update(object);
    }

    @Override
    @Transactional
    public void delete(Case object) {
        caseDaoIml.delete(object);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Case> getAll() {
        return caseDaoIml.findAll();
    }
}
