package com.skillsup.kirill.springjava.service.impl;

import com.skillsup.kirill.springjava.dao.ContactDao;
import com.skillsup.kirill.springjava.entity.MappedContact;
import com.skillsup.kirill.springjava.model.Contact;
import com.skillsup.kirill.springjava.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 14.12.2015.
 */

@Service
public class ContactServiceImp implements ContactsService {

    @Autowired
    private ContactDao contactDao;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        MappedContact mappedContact = new MappedContact();
        mappedContact.setName(contact.getName());
        mappedContact.setPhone(contact.getPhone());
        mappedContact.setEmail(contact.getEmail());

        contactDao.addContact(mappedContact);
    }

    @Override
    public void delleteContact(Contact contact) {
        //contactDao.delleteContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        List<MappedContact> listMappedContact = contactDao.getAllContacts();
        List<Contact> listContact = new ArrayList<Contact>();
        for (MappedContact mappedContact : listMappedContact){
            Contact contact = new Contact();
            contact.setName(contact.getName());
            contact.setPhone(contact.getPhone());
            contact.setEmail(contact.getEmail());
            listContact.add(contact);
        }

        return listContact;
    }

    @Override
    public void clearAll() {
        //contactDao.clearAll();
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}