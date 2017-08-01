
package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.Toss;
import com.SoftwareFactoryAdmin.model.TossTask;

import java.util.List;


public interface TossDao {

    Long create(Toss toss);

    Toss read(Long id);

    void update(Toss toss);

    void delete(Toss toss);

    List<Toss> findAll();

    List<Toss> findTossBelongToManager(Long id);

    List<Toss> findTossBelongToManagerByStatus(Long id, String status);



}
