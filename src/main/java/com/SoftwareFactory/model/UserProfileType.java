package com.SoftwareFactory.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	CUSTOMER("CUSTOMER"),
	DBA("DBA"),
	MANAGER("MANAGER");

	String userProfileType;

	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}

	public String getUserProfileType(){
		return userProfileType;
	}

}
