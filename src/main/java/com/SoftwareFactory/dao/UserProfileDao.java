package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.UserProfile;

import java.util.List;




public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
