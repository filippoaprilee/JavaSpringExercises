package it.apuliadigital.rubricaproject.service;

import it.apuliadigital.rubricaproject.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact createContact(Contact contact);
    Optional<Contact> getContactById(Long id);
    List<Contact> getAllContacts();
    List<Contact> searchContacts(String nome, String cognome);

    boolean updateContact(Long id, Contact contact);
    boolean deleteContact(Long id);
}
