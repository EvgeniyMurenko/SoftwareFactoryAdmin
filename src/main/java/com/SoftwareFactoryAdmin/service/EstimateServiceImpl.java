package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.EstimateDao;
import com.SoftwareFactoryAdmin.model.Estimate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("estimateService")
public class EstimateServiceImpl implements EstimateService {

    private EstimateDao estimateDao;

    @Autowired(required = true)
    public void setEstimateDao(EstimateDao estimateDao) {
        this.estimateDao = estimateDao;
    }

    @Override
    public void addNewEstimate(Estimate estimate) {
        estimateDao.create(estimate);
    }

    @Override
    public void updateEstimate(Estimate estimate) {
        estimateDao.update(estimate);
    }

    @Override
    public void deleteEstimate(Estimate estimate) {
        estimateDao.delete(estimate);
    }

    @Override
    public List<Estimate> getAllEstimates() {
        return estimateDao.findAll();
    }

    @Override
    public Estimate getEstimateById(long estimateId) {
        return estimateDao.read(estimateId);
    }

    @Override
    public Estimate findEstimateByCustomerInfoId(Long id) {
        return estimateDao.findEstimateByCustomerInfoId(id);
    }

    @Override
    public List<Estimate> findAllWhereUserIsNotDelete(){
        return estimateDao.findAllWhereUserIsNotDelete();
    }
}
