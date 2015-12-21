package com.skillsup.kirill.springjava.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by Kirill on 16.12.2015.
 */

@Component
public class ContactFactory implements FactoryBean<Contact> {

    private int count = 1;

    @Override
    public Contact getObject() throws Exception {
            return new Contact("contact"+count, "+"+count+count+count+count+count+count, "contact"+count+"@email");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
