package com.plakhotnyuk.PhoneBook.repository;

import java.util.List;

import com.plakhotnyuk.PhoneBook.model.Contact;

public interface ContactDAO {
	
	public List<Contact> contactList();
	public void saveOrUpdate(Contact contact);
	public void delete(long id);
	public Contact get(long id);
	

}
