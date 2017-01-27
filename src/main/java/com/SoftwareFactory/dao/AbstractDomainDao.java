package com.SoftwareFactory.dao;


import java.util.List;


// CRUD
public interface AbstractDomainDao <T> {

    public Long create(T domain);
    T read(Long id);
    void update(T domain);
    void delete(T domain);
    List<T> findAll();

}
