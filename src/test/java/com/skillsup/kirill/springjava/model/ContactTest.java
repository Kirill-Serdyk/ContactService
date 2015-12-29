package com.skillsup.kirill.springjava.model;

import com.skillsup.kirill.springjava.model.Contact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    public Contact contact;

    @Before
    public void beforeClass(){
        contact = new Contact("name","tel","email");
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("name", contact.getName());
    }

    @Test
    public void testSetName() throws Exception {
        contact.setName("nameSet");
        assertEquals("nameSet", contact.getName());
    }

    @Test
    public void testGetPhone() throws Exception {
        assertEquals("tel", contact.getPhone());
    }

    @Test
    public void testSetPhone() throws Exception {
        contact.setPhone("phoneSet");
        assertEquals("phoneSet", contact.getPhone());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("email", contact.getEmail());
    }

    @Test
    public void testSetEmail() throws Exception {
        contact.setEmail("emailSet");
        assertEquals("emailSet", contact.getEmail());
    }
}