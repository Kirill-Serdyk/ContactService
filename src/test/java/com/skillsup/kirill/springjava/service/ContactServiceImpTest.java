package com.skillsup.kirill.springjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceImpTest {

    private ContactServiceImp contactService;

    Contact c1 = new Contact("name1","tel1","email1");
    Contact c2 = new Contact("name2","tel2","email2");
    Contact c3 = new Contact("name3","tel3","email3");
    Contact c4 = new Contact("name4","tel4","email4");

    @Before
    public void beforeClass(){
        contactService = new ContactServiceImp();

        ContactDao contactDaoMock = mock(ContactDao.class);
        contactService.setContactDao(contactDaoMock);

        List<Contact> list = new ArrayList<Contact>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        when(contactDaoMock.getAllContacts()).thenReturn(list);
        //when(contactDaoMock.addContact(Contact.class)).then(list.add(c4));
    }

    @Test
    public void testAddContact() throws Exception {
        contactService.addContact(c4);
        assertEquals(3, contactService.getAllContacts().size());
    }

    @Test
    public void testDelleteContact() throws Exception {
        contactService.delleteContact(c3);
        assertEquals(3, contactService.getAllContacts().size());
    }

    @Test
    public void testGetAllContacts() throws Exception {
        assertEquals(3, contactService.getAllContacts().size());
    }

    @Test
    public void testClearAll() throws Exception {
        contactService.clearAll();
        assertEquals(3, contactService.getAllContacts().size());
    }
}