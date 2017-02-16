package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.FileEstimateDao;
import com.SoftwareFactory.model.FileEstimate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FileEstimateServiceImpl implements FileEstimateService {

    private FileEstimateDao fileEstimateDao;

    @Autowired(required=true)
    public void setCaseDao(FileEstimateDao fileEstimateDao) {
        this.fileEstimateDao = fileEstimateDao;
    }

    @Override
    @Transactional
    public void addNewFileEstimate(FileEstimate fileEstimate) {
        fileEstimateDao.create(fileEstimate);
    }

    @Override
    @Transactional
    public void updateFileEstimate(FileEstimate fileEstimate) {
        fileEstimateDao.update(fileEstimate);
    }

    @Override
    @Transactional
    public void deleteFileEstimate(FileEstimate fileEstimate) {
        fileEstimateDao.delete(fileEstimate);
    }

    @Override
    @Transactional(readOnly=true)
    public List<FileEstimate> getAllFileEstimates() {
        return fileEstimateDao.findAll();
    }

    @Override
    @Transactional
    public FileEstimate getFileEstimateById(Long id) {
        return fileEstimateDao.read(id);
    }
}
