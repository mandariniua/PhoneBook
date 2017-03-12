package com.plakhotnyuk.PhoneBook.bean;

public enum UserProfileType {
	
	USER("USER");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }
	
    public String getUserProfileType() {
        return userProfileType;
    }
	

}
