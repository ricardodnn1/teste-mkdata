package br.ricardo.crud.domain.service;

import java.util.List;

import br.ricardo.crud.domain.entity.Contact;

public interface ContactService {
        
    List<Contact> getContacts();

    Contact saveContact(Contact contact);

    Contact updateContact(Contact contact);

    Contact getContact(Long id);

    Contact deleteContact(Long id);

}
