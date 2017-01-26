package com.SoftwareFactory.service;

import com.SoftwareFactory.model.Estimate;

import java.util.List;

/**
 * Created by Alex on 1/18/2017.
 */
public interface EstimateService {
    void addNewEstimate(Estimate estimate);
    void updateEstimate(Estimate estimate);
    void deleteEstimate(Estimate estimate);
    List<Estimate> getAllEstimates();
}
