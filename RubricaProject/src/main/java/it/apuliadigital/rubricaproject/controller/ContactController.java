package it.apuliadigital.rubricaproject.controller;

import it.apuliadigital.rubricaproject.entity.Contact;
import it.apuliadigital.rubricaproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        try {
            Contact newContact = contactService.createContact(contact);
            return new ResponseEntity<>(newContact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nell'inserimento del contatto.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContact(@PathVariable Long id) {
        try {
            Optional<Contact> contact = contactService.getContactById(id);
            if (contact.isEmpty()) {
                return new ResponseEntity<>("Errore: contatto con id " + id + " non trovato.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella lettura del contatto con id " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllContacts() {
        try {
            List<Contact> contacts = contactService.getAllContacts();
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella lettura dei contatti.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchContacts(@RequestParam(required = false) String nome, @RequestParam(required = false) String cognome) {
        try {
            List<Contact> contacts = contactService.searchContacts(nome, cognome);
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella ricerca dei contatti.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        try {
            boolean updatedContact = contactService.updateContact(id, contact);
            if (!updatedContact) {
                return new ResponseEntity<>("Errore: contatto con id " + id + " non trovato.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Contatto con id " + id + " aggiornato con successo.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nell'aggiornamento del contatto con id " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        try {
            boolean deletedContact = contactService.deleteContact(id);
            if (!deletedContact) {
                return new ResponseEntity<>("Errore: contatto con id " + id + " non trovato.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Contatto con id " + id + " eliminato con successo.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nell'eliminazione del contatto con id " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
