package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.User;

import java.util.List;



public interface UserDao {

    User findById(Long id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    void deleteByID(Long id);

    List<User> findAllUsers();

}
