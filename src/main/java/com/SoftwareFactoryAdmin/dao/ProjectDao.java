package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.Project;

import java.util.List;


public interface ProjectDao {

    Long create(Project project);

    Project read(Long id);

    void update(Project project);

    void delete(Project project);

    List<Project> findAll();

    List<Project> findAllWhereUserIsNotDelete();

}
