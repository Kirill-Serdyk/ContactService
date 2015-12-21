package com.skillsup.kirill.springjava.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFactoryTest {

    public ContactFactory contactFactory = new ContactFactory();

    @Test
    public void testGetObject() throws Exception {
        assertEquals(Contact.class, contactFactory.getObject().getClass());
    }

    @Test
    public void testGetObjectType() throws Exception {
        assertNull(contactFactory.getObjectType());
    }

    @Test
    public void testIsSingleton() throws Exception {
        assertNotNull(contactFactory.isSingleton());
    }
}