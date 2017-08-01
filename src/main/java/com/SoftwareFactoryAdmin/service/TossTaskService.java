package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.TossTask;

import java.util.List;

public interface TossTaskService {

    void addNewTossTask(TossTask tossTask);

    void updateTossTask(TossTask tossTask);

    void deleteTossTask(TossTask tossTask);

    List<TossTask> getAllTossTasks();

    TossTask getTossTaskById(Long id);

}
