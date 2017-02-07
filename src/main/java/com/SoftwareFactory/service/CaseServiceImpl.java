package com.SoftwareFactory.service;

import com.SoftwareFactory.constant.StatusEnum;
import com.SoftwareFactory.dao.CaseDao;
import com.SoftwareFactory.dao.CaseDaoImpl;
import com.SoftwareFactory.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service("caseService")
public class CaseServiceImpl implements CaseService {

    private CaseDao caseDao;

    @Autowired(required=true)
    public void setCaseDao(CaseDao caseDao) {
        this.caseDao = caseDao;
    }

    @Override
    @Transactional
    public void addNewCase(Case aCase) {
        caseDao.create(aCase);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Case> getAllCases() {
        return caseDao.findAll();
    }

    @Override
    @Transactional
    public Case getCaseById(Long id) {
        Case aCase = caseDao.read(id);
        return aCase;
    }

    @Override
    @Transactional
    public void updateCase(Case aCase) {
        caseDao.update(aCase);
    }

    @Override
    @Transactional
    public void deleteCase(Case aCase) {
        caseDao.delete(aCase);
    }

    @Transactional(readOnly=true)
    public List<Case> sortByStatusDate() {
        List<Case> aCases = caseDao.findAll();
        int msgMax = -1;
        for (Case aCase:aCases){
            if(aCase.getStatus().equals(StatusEnum.OPEN.toString())){
                aCases.add(0, aCase);
            }
        }

        return aCases;
    }
}
