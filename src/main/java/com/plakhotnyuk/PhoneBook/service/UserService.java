package com.plakhotnyuk.PhoneBook.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plakhotnyuk.PhoneBook.bean.User;
import com.plakhotnyuk.PhoneBook.dao.UserDAO;

@Service
@Transactional
public class UserService {
	
	private UserDAO userDao;
	
	
	public void saveUser(User user) {
        userDao.add(user);
    }
	
	public User findById(int id) {
        return userDao.findById(id);
    }
	
	public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
