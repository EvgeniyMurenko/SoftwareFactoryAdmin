package com.SoftwareFactory.service;

import com.SoftwareFactory.model.FileEstimate;
import java.util.List;

/**
 * Created by adm on 2/16/2017.
 */
public interface FileEstimateService {
    void addNewFileEstimate(FileEstimate fileEstimate);
    void updateFileEstimate(FileEstimate fileEstimate);
    void deleteFileEstimate(FileEstimate fileEstimate);
    List<FileEstimate> getAllFileEstimates();
    FileEstimate getFileEstimateById(Long id);
}
