package com.SoftwareFactory.service;

import com.SoftwareFactory.model.Status;

import java.util.List;

/**
 * Created by adm on 1/30/2017.
 */
public interface StatusService {
    void addNewStatus(Status status);
    void updateStatus(Status status);
    void deleteStatus(Status status);
    List<Status> getAllStatuses();
}
