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
        userDao.save(user);
    }
	
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	public User loginUser(String username, String password) {
        User user = this.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
	
}
