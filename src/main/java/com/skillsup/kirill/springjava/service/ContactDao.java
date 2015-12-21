package com.skillsup.kirill.springjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 12.12.2015.
 */
@Repository
public class ContactDao {
    private List<Contact> contacts = new ArrayList<Contact>();


    public void addContact(Contact contact) {
        contacts.add(contact);
    }


    public void delleteContact(Contact contact) {
        contacts.remove(contact);
    }


    public List<Contact> getAllContacts() {
        return contacts;
    }


    public void clearAll() {
        contacts.clear();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
