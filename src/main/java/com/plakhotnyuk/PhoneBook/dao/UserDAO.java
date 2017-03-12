package com.plakhotnyuk.PhoneBook.dao;

import com.plakhotnyuk.PhoneBook.bean.User;

public interface UserDAO {
	
	public void save(User user);
	public User findByUsername(String username);

}
