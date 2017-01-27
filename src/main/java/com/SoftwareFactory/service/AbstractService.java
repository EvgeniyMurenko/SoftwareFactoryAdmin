package com.SoftwareFactory.service;

import java.util.List;

/**
 * Created by adm on 1/27/2017.
 */
public interface AbstractService<T> {
    void addNew(T object);
    void update(T object);
    void delete(T object);
    List<T> getAll();
}
