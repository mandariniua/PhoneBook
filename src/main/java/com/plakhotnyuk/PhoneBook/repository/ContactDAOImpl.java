package com.plakhotnyuk.PhoneBook.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.plakhotnyuk.PhoneBook.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ContactDAOImpl() {
		
	}
	
	public ContactDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Contact> contactList() {
		
		@SuppressWarnings("unchecked")
		List<Contact> listContact = sessionFactory.getCurrentSession()
				.createCriteria(Contact.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listContact;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		Contact contactToDelete = new Contact();
		contactToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(contactToDelete);
		
	}

	@Override
	@Transactional
	public Contact get(long id) {
		String hql = "from Contact where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Contact> listContact = query.list();
		
		if(listContact != null && !listContact.isEmpty()){
			return listContact.get(0);
		}
		return null;
		
	}
	

}
