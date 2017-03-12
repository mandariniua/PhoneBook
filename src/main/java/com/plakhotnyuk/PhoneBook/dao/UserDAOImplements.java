package com.plakhotnyuk.PhoneBook.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.plakhotnyuk.PhoneBook.bean.User;


@Transactional
@SuppressWarnings("uncheked")
@Repository
public class UserDAOImplements  implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		this.sessionFactory.getCurrentSession().persist(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("from User WHERE username = ?").setParameter(0, username).uniqueResult();
	}

	

	
}
