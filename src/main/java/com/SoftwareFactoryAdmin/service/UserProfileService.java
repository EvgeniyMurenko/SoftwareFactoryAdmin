package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.UserProfile;

import java.util.List;



public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
