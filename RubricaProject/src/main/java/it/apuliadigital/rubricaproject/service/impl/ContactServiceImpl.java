package it.apuliadigital.rubricaproject.service.impl;

import it.apuliadigital.rubricaproject.entity.Contact;
import it.apuliadigital.rubricaproject.repository.ContactRepository;
import it.apuliadigital.rubricaproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public List<Contact> searchContacts(String nome, String cognome) {
        /*if (nome != null && cognome != null) {
            return contactRepository.findByNomeContainingOrCognomeContaining(nome, cognome);
        } else if (nome != null) {
            return contactRepository.findByNomeContaining(nome);
        } else if (cognome != null) {
            return contactRepository.findByCognomeContaining(cognome);
        }
        else {
            throw new IllegalArgumentException("Nome o cognome devono essere forniti per la ricerca.");
        }*/
        if (nome != null && cognome != null) {
            return contactRepository.findByNomeAndCognome(nome, cognome);
        } else {
            return contactRepository.findByNomeContainingOrCognomeContaining(nome, cognome);
        }
    }

    @Override
    public boolean updateContact(Long id, Contact contact) {
        if (contactRepository.existsById(id)) {
            contact.setId(id);
            contactRepository.save(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
