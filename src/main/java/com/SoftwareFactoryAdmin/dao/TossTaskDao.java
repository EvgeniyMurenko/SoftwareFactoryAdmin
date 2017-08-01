package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.TossTask;

import java.util.List;

public interface TossTaskDao {

    Long create(TossTask tossTask);

    TossTask  read(Long id);

    void update(TossTask tossTask);

    void delete(TossTask tossTask);

    List<TossTask> findAll();

}
