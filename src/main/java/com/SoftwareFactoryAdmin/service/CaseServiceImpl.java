package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.CaseDao;
import com.SoftwareFactoryAdmin.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("caseService")
public class CaseServiceImpl implements CaseService {

    private CaseDao caseDao;

    @Autowired(required = true)
    public void setCaseDao(CaseDao caseDao) {
        this.caseDao = caseDao;
    }

    @Override
    public void addNewCase(Case aCase) {
        caseDao.create(aCase);
    }

    @Override
    public List<Case> getAllCases() {
        return caseDao.findAll();
    }

    @Override
    public Case getCaseById(Long id) {
        return caseDao.read(id);
    }

    @Override
    public List<Case> findByField(String title, String projectName) {
        ArrayList<Case> cases = new ArrayList<>();
        if (!title.equals("")) {
            cases.addAll(caseDao.findByTitle(title));
        }
        if (!projectName.equals("")) {
            cases.addAll(caseDao.findByProjectName(projectName));
        }
        return cases;
    }

    @Override
    public void updateCase(Case aCase) {
        caseDao.update(aCase);
    }

    @Override
    public void deleteCase(Case aCase) {
        caseDao.delete(aCase);
    }

    @Override
    public List<Case> getCasesHundredLimit() {
        return caseDao.findCasesHundredLimit();
    }

    @Override
    public List<Case> findAllWhereUserIsNotDelete() {
        return caseDao.findAllWhereUserIsNotDelete();
    }

    @Override
    public List<Case> findLimitThreeCase() {
        return caseDao.findLimitThreeCase();
    }
}
