
package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.Toss;


import java.util.List;


public interface TossService {

    void addNewToss(Toss toss);

    void updateToss(Toss toss);

    void deleteToss(Toss toss);

    List<Toss> getAllToss();

    Toss getTossById(Long id);

    List<Toss> findAllTossBelongToManager(Long id);

    List<Toss> findAllTossBelongToManagerByStatus(Long id, String status);

}

