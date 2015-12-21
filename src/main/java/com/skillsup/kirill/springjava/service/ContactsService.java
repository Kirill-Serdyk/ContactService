package com.skillsup.kirill.springjava.service;

import java.util.List;

/**
 * Created by Kirill on 12.12.2015.
 */
public interface ContactsService {
    void addContact(Contact contact);
    void delleteContact(Contact contact);
    List<Contact> getAllContacts();
    void clearAll();
}