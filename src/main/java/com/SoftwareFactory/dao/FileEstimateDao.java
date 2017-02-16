package com.SoftwareFactory.dao;


import com.SoftwareFactory.model.FileEstimate;
import java.util.List;

/**
 * Created by adm on 2/16/2017.
 */
public interface FileEstimateDao {
    Long create(FileEstimate fileEstimate);
    FileEstimate read(Long id);
    void update(FileEstimate fileEstimate);
    void delete(FileEstimate fileEstimate);
    List<FileEstimate> findAll();
}
