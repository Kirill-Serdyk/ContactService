package com.skillsup.kirill.springjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kirill on 14.12.2015.
 */

@Service
public class ContactServiceImp implements ContactsService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    public void delleteContact(Contact contact) {
        contactDao.delleteContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    public void clearAll() {
        contactDao.clearAll();
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}