package com.plakhotnyuk.PhoneBook.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.plakhotnyuk.PhoneBook.bean.User;

@Transactional
@SuppressWarnings("uncheked")
@Repository
public class UserDAOImplements implements UserDAO {
	
	private SessionFactory sessionFactory;

	public void add(User user) {
		this.sessionFactory.getCurrentSession().persist(user);
		
	}
	

	
}
