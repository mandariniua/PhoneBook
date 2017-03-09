package com.plakhotnyuk.PhoneBook.dao;

import com.plakhotnyuk.PhoneBook.bean.User;

public interface UserDAO {
	
	public void add(User user);
	public User findById(int id);
	public User findByUsername(String username);

}
