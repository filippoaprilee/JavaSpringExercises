package it.apuliadigital.rubricaproject.repository;

import it.apuliadigital.rubricaproject.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
    List<Contact> findByNomeContainingOrCognomeContaining(String nome, String cognome);
    List<Contact> findByNomeContaining(String nome);
    List<Contact> findByCognomeContaining(String cognome);
    List<Contact> findByNomeAndCognome(String nome, String cognome);
}
