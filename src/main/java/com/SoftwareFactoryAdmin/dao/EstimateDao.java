package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.Estimate;

import java.util.List;

public interface  EstimateDao {

    Long create(Estimate estimate);

    Estimate read(Long id);

    void update(Estimate estimate);

    void delete(Estimate estimate);

    List<Estimate> findAll();

}
