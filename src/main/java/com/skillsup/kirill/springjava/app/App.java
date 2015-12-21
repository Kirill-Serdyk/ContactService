package com.skillsup.kirill.springjava.app;


import com.skillsup.kirill.springjava.config.SpringConfiguration;
import com.skillsup.kirill.springjava.service.Contact;
import com.skillsup.kirill.springjava.service.ContactDao;
import com.skillsup.kirill.springjava.service.ContactFactory;
import com.skillsup.kirill.springjava.service.ContactServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kirill on 12.12.2015.
 */
public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ContactServiceImp contactServiceImp = applicationContext.getBean(ContactServiceImp.class);
        ContactFactory contactFactory = applicationContext.getBean(ContactFactory.class);

        Contact contact1 = contactFactory.getObject();
        contactServiceImp.addContact(contact1);

        Contact contact2 = contactFactory.getObject();
        contactServiceImp.addContact(contact2);

        Contact contact3 = contactFactory.getObject();
        contactServiceImp.addContact(contact3);

        System.out.println(contactServiceImp.getAllContacts().toString());

        contactServiceImp.addContact(new Contact("contact4", "+4444444444", "contact4@email"));
        System.out.println(contactServiceImp.getAllContacts().toString());

        contactServiceImp.delleteContact(contact2);
        System.out.println(contactServiceImp.getAllContacts().toString());

        contactServiceImp.addContact(contact2);
        System.out.println(contactServiceImp.getAllContacts().toString());
    }
}