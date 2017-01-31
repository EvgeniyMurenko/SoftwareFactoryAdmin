package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Case;
import java.util.List;

/**
 * Created by adm on 1/30/2017.
 */
public interface CaseDao {

    Long create(Case cases);
    Case read(Long id);
    void update(Case cases);
    void delete(Case cases);
    List<Case> findAll();
}