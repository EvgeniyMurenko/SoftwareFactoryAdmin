package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.Case;
import java.util.List;


public interface CaseDao {

    Long create(Case cases);

    Case read(Long id);

    void update(Case cases);

    void delete(Case cases);

    List<Case> findAll();

    List<Case> findByTitle(String title);

    List<Case> findByProjectName(String projectName);

    List<Case> findCasesHundredLimit();

}
