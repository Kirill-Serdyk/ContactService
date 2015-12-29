package com.skillsup.kirill.springjava.dao;

import com.skillsup.kirill.springjava.entity.MappedContact;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Kirill on 12.12.2015.
 */
@Repository
public class ContactDao {

    @PersistenceContext
    private EntityManager em;

    public void addContact(MappedContact contact){
        em.persist(contact);
    }

    public List<MappedContact> getAllContacts(){
        return em.createQuery("SELECT mappedContact FROM MappedContact mappedContact").getResultList();
    }


//    private List<Contact> contacts = new ArrayList<Contact>();
//
//
//    public void addContact(Contact contact) {
//        contacts.add(contact);
//    }
//
//
//    public void delleteContact(Contact contact) {
//        contacts.remove(contact);
//    }
//
//
//    public List<Contact> getAllContacts() {
//        return contacts;
//    }
//
//
//    public void clearAll() {
//        contacts.clear();
//    }
//
//    public void setContacts(List<Contact> contacts) {
//        this.contacts = contacts;
//    }

}
